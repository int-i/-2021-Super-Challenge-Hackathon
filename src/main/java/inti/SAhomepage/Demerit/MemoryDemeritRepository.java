package inti.SAhomepage.Demerit;

import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryDemeritRepository implements DemeritRepository{

    private final DataSource dataSource;

    public MemoryDemeritRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    private Connection getConnection(){
        return DataSourceUtils.getConnection(dataSource);
    }
    private void close(Connection conn, PreparedStatement pst, ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(pst!=null){
                pst.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(conn!=null){
                close(conn);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private void close(Connection conn) throws SQLException{
        DataSourceUtils.releaseConnection(conn,dataSource);
    }
    @Override
    public Demerit save(Demerit demerit) {
        String sql="insert into demerit(id,value,reason) values(?,?,?)";
        Connection conn =null;
        PreparedStatement pst = null;
        ResultSet rs=null;

        try{
            conn=getConnection();
            pst=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, demerit.getId());
            pst.setFloat(2, demerit.getValue());
            pst.setString(3, demerit.getReason());
            pst.executeUpdate();
            rs=pst.getGeneratedKeys();
            if(rs.next()){
                demerit.setNum(rs.getInt(1));
            }else{
                throw new SQLException("error 발생");
            }
            return demerit;
        }catch (Exception e){
            throw new IllegalStateException(e);
        }finally {
            close(conn,pst,rs);
        }

    }

    @Override
    public void update(Demerit demerit){
        String sql="update demerit set value=?,reason=? where num=?";
        Connection conn =null;
        PreparedStatement pst = null;
        ResultSet rs=null;
        int count=0;
        try{
            conn=getConnection();
            pst=conn.prepareStatement(sql);
            pst.setFloat(1, demerit.getValue());
            pst.setString(2, demerit.getReason());
            pst.setInt(3, demerit.getNum());
            count=pst.executeUpdate();

            if(count!=0){
            }else{
                throw new SQLException("error 발생");
            }
        }catch (Exception e){
            throw new IllegalStateException(e);
        }finally {
            close(conn,pst,rs);
        }
    }

    @Override
    public void delete(Demerit demerit){
        String sql="delete from demerit where num=?";
        Connection conn =null;
        PreparedStatement pst = null;
        ResultSet rs=null;
        int count=0;
        try{
            conn=getConnection();
            pst=conn.prepareStatement(sql);
            pst.setInt(1, demerit.getNum());
            count=pst.executeUpdate();

            if(count!=0){
            }else{
                throw new SQLException("error 발생");
            }
        }catch (Exception e){
            throw new IllegalStateException(e);
        }finally {
            close(conn,pst,rs);
        }
    }

    @Override
    public Optional<Float> sumByid(int id) {
        String sql="select sum(value) from demerit where id=?";
        Connection conn =null;
        PreparedStatement pst = null;
        ResultSet rs=null;
        try{
            conn=getConnection();
            pst=conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs=pst.executeQuery();
            if(rs.next()){
                Float sum=rs.getFloat(1);
                return Optional.of(sum);
            }else{
                return Optional.empty();
            }
        }catch (Exception e){
            throw new IllegalStateException(e);
        }finally {
            close(conn,pst,rs);
        }
    }
    @Override
    public List<Demerit> findByid(int id) {
        String sql="select * from demerit where id=?";
        Connection conn =null;
        PreparedStatement pst = null;
        ResultSet rs=null;

        try{
            conn=getConnection();
            pst=conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs=pst.executeQuery();
            List<Demerit> demerits=new ArrayList<>();
            while(rs.next()){
                Demerit demerit=new Demerit();
                demerit.setValue(rs.getFloat("value"));
                demerit.setReason(rs.getString("reason"));
                demerits.add(demerit);
            }
            return demerits;
        }catch (Exception e){
            throw new IllegalStateException(e);
        }finally {
            close(conn,pst,rs);
        }

    }

    @Override
    public List<Demerit> findAll() {
        String sql="select * from demerit";
        Connection conn =null;
        PreparedStatement pst = null;
        ResultSet rs=null;

        try{
            conn=getConnection();
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            List<Demerit> demerits=new ArrayList<>();
            while(rs.next()){
                Demerit demerit= new Demerit();
                demerit.setNum(rs.getInt("num"));
                demerit.setId(rs.getInt("id"));
                demerit.setValue(rs.getFloat("value"));
                demerit.setReason(rs.getString("reason"));
                demerits.add(demerit);
            }
            return demerits;
        }catch (Exception e){
            throw new IllegalStateException(e);
        }finally {
            close(conn,pst,rs);
        }
    }

}
