package inti.SAhomepage.Locker.Repository;

import inti.SAhomepage.Locker.Domain.Payer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class JdbcPayerRepository implements PayerRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPayerRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Payer payer) {
        String sql = "INSERT INTO Payer VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                payer.getId(),
                payer.getName(),
                payer.getPhone(),
                payer.getLocker_id());
    }

    public void delete(int id) {
        String sql = "DELETE FROM Payer WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void update(int id, int Locker_id) {
        String sql = "UPDATE Payer SET Locker_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, Locker_id, id);
    }

    @Override
    public Optional<Payer> findByPayer_Id(int id) {
        String sql = "SELECT * FROM Payer WHERE id = ?";
        List<Payer> result = jdbcTemplate.query(sql, payerRowMapper(), id);
        return result.stream().findAny();
    }

    @Override
    public Optional<Payer> findByLocker_Id(int Locker_id) {
        String sql = "SELECT * FROM Payer WHERE Locker_id = ?";
        List<Payer> result = jdbcTemplate.query(sql, payerRowMapper(), Locker_id);
        return result.stream().findAny();
    }

    @Override
    public List<Payer> findAll() {
        String sql = "SELECT * FROM Payer";
        return jdbcTemplate.query(sql, payerRowMapper());
    }

    private RowMapper<Payer> payerRowMapper() {
        return (rs, rowNum) -> {
            Payer payer = new Payer();
            payer.setId(rs.getInt("id"));
            payer.setName(rs.getString("name"));
            payer.setPhone(rs.getString("phone"));
            payer.setLocker_id(rs.getInt("Locker_id"));
            return payer;
        };
    }
}
