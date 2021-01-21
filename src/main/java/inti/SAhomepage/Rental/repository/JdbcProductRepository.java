package inti.SAhomepage.Rental.repository;

import inti.SAhomepage.Rental.domain.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcProductRepository implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProductRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Product save(Product product) {
        String sql = "INSERT INTO product VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                product.getProduct_id(),
                product.getProduct_name(),
                product.getProduct_num(),
                product.getState(),
                product.getImage_path()
        );
        return product;
    }

    public void updateState(int product_id, int state) {
        String sql = "UPDATE product SET state = ? WHERE product_id = ?";
        jdbcTemplate.update(sql, state, product_id);
    }

    @Override
    public Optional<Product> findByProductId(int product_id) {
        String sql = "SELECT * FROM product WHERE product_id = ?";
        List<Product> result = jdbcTemplate.query(sql, productRowMapper(), product_id);
        return result.stream().findAny();
    }

    @Override
    public Optional<Product> findByProductName(String product_name) {
        String sql = "SELECT * FROM product WHERE product_name = ?";
        List<Product> result = jdbcTemplate.query(sql, productRowMapper(), product_name);
        return result.stream().findAny();
    }

    @Override
    public Optional<Product> findByIdAndName(int product_id, String product_name) {
        String sql = "SELECT * FROM product WHERE product_id = ? AND product_name = ?";
        List<Product> result = jdbcTemplate.query(sql, productRowMapper(), product_id, product_name);
        return result.stream().findAny();
    }

    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Product product = new Product();
            product.setProduct_id(rs.getInt("product_id"));
            product.setProduct_name(rs.getString("product_name"));
            product.setProduct_num(rs.getInt("product_num"));
            product.setState(rs.getInt("state"));
            return product;
        });
    }

    private RowMapper<Product> productRowMapper() {
        return (rs, rowNum) -> {
            Product product = new Product();
            product.setProduct_id(rs.getInt("product_id"));
            product.setProduct_name(rs.getString("product_name"));
            product.setProduct_num(rs.getInt("product_num"));
            product.setState(rs.getInt("state"));
            return product;
        };
    }

}
