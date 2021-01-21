package inti.SAhomepage.Rental.repository;

import inti.SAhomepage.Rental.domain.Rental;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class JdbcRentalRepository implements RentalRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcRentalRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Rental rental) {
        String sql = "INSERT INTO rental VALUES (?, ?, now(), ?)";
        jdbcTemplate.update(sql,
                rental.getProduct_id(),
                rental.getPayer_id(),
                rental.getChecker()
        );
    }

    public void delete(int product_id) {
        String sql = "DELETE FROM rental WHERE product_id = ?";
        jdbcTemplate.update(sql, product_id);
    }

    @Override
    public Optional<Rental> findByProduct(int product_id) {
        String sql = "SELECT * FROM rental WHERE product_id = ?";
        List<Rental> result = jdbcTemplate.query(sql, rentalRowMapper(), product_id);
        return result.stream().findAny();
    }


    @Override
    public Optional<Rental> findByPayer(int payer_id) {
        String sql = "SELECT * FROM rental WHERE payer_id = ?";
        List<Rental> result = jdbcTemplate.query(sql, rentalRowMapper(), payer_id);
        return result.stream().findAny();
    }

    @Override
    public List<Rental> findAll() {
        String sql = "SELECT * FROM rental";
        return jdbcTemplate.query(sql, rentalRowMapper());
    }

    private RowMapper<Rental> rentalRowMapper() {
        return (rs, rowNum) -> {
            Rental rental = new Rental();
            rental.setProduct_id(rs.getInt("product_id"));
            rental.setPayer_id(rs.getInt("payer_id"));
            rental.setRental_date(rs.getTimestamp("rental_date"));
            rental.setChecker(rs.getString("checker"));
            return rental;
        };
    }
}
