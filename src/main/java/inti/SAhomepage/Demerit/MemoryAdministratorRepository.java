package inti.SAhomepage.Demerit;

import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class MemoryAdministratorRepository implements AdministratorRepository{
    private final DataSource dataSource;

    public MemoryAdministratorRepository(DataSource dataSource) {
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
    public Optional<Integer> check(Administrator administrator) {
        String sql="select count(*) from administrator where password=?";
        Connection conn =null;
        PreparedStatement pst = null;
        ResultSet rs=null;
        try{
            conn=getConnection();
            pst=conn.prepareStatement(sql);
            pst.setInt(1, administrator.getPassword());
            rs=pst.executeQuery();
            if(rs.next()){
                Integer num=rs.getInt(1);
                return Optional.of(num);
            }else{
                return Optional.empty();
            }
        }catch (Exception e){
            throw new IllegalStateException(e);
        }finally {
            close(conn,pst,rs);
        }
    }
}
