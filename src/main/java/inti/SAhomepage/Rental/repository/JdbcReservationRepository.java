package inti.SAhomepage.Rental.repository;

import inti.SAhomepage.Rental.domain.Rental;
import inti.SAhomepage.Rental.domain.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class JdbcReservationRepository implements ReservationRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcReservationRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Reservation reservation) {
        String sql = "INSERT INTO reservation VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                reservation.getProduct_id(),
                reservation.getPayer_id(),
                reservation.getDate()
        );
    }

    @Override
    public void delete(int product_id) {
        String sql = "DELETE FROM reservation WHERE product_id = ?";
        jdbcTemplate.update(sql, product_id);
    }

    @Override
    public Optional<Reservation> findByProductId(int product_id) {
        String sql = "SELECT * FROM reservation WHERE product_id = ?";
        List<Reservation> result = jdbcTemplate.query(sql, reservationRowMapper(), product_id);
        return result.stream().findAny();
    }

    @Override
    public Optional<Reservation> findByPayerId(int payer_id) {
        String sql = "SELECT * FROM reservation WHERE payer_id = ?";
        List<Reservation> result = jdbcTemplate.query(sql, reservationRowMapper(), payer_id);
        return result.stream().findAny();
    }

    @Override
    public String findReserver(int payer_id) {
        String sql = "SELECT name FROM payer WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{payer_id}, String.class);
    }

    @Override
    public List<Reservation> findAll() {
        String sql = "SELECT * FROM reservation";
        return jdbcTemplate.query(sql, reservationRowMapper());
    }

    private RowMapper<Reservation> reservationRowMapper() {
        return (rs, rowNum) -> {
            Reservation reservation = new Reservation();
            reservation.setProduct_id(rs.getInt("product_id"));
            reservation.setPayer_id(rs.getInt("payer_id"));
            reservation.setDate(rs.getDate("date"));
            return reservation;
        };
    }
}
