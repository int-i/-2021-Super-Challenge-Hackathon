package inti.SAhomepage.Locker.Repository;

import inti.SAhomepage.Locker.Domain.Lock;
import inti.SAhomepage.Locker.Domain.Payer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.*;

public class JdbcLockerRepository implements LockerRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcLockerRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add(Lock lock) {
        String sql = "INSERT INTO Locker VALUES (?)";
        jdbcTemplate.update(sql,
                lock.getLocker_id());
    }

    public void delete(int id) {
        String sql = "DELETE FROM Locker WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Lock> findEmptyLocker() {
        String sql = "select count(p.locker_id) as usercnt, l.locker_id, l.no_user from locker l left join payer p" +
                "on l.locker_id = p.locker_id group by l.locker_id having usercnt < " +
                "(select no_user from locker where locker_id = l.locker_id)";
        return jdbcTemplate.query(sql, lockRowMapper2());
    }

    private RowMapper<Lock> lockRowMapper2() {
        return (rs, rowNum) -> {
            Lock lock1 = new Lock();
            lock1.setLocker_id(rs.getInt("locker_id"));
            lock1.setNo_user(rs.getInt("no_user"));
            lock1.setUsercnt(rs.getInt("usercnt"));
            return lock1;
        };
    }

    @Override
    public List<Lock> findAll() {
        String sql = "SELECT * FROM Locker";
        return jdbcTemplate.query(sql, lockRowMapper());
    }

    private RowMapper<Lock> lockRowMapper() {
        return (rs, rowNum) -> {
            Lock lock = new Lock();
            lock.setLocker_id(rs.getInt("Locker_id"));
            lock.setNo_user(rs.getInt("No_user"));
            return lock;
        };
    }


}
