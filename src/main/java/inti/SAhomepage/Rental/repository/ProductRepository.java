package inti.SAhomepage.Rental.repository;

import inti.SAhomepage.Rental.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);

    void updateState(int product_id, int state);

    Optional<Product> findByProductId(int product_id);

    Optional<Product> findByProductName(String product_name);

    Optional<Product> findByIdAndName(int product_id, String product_name);

    List<Product> findAll();
}
