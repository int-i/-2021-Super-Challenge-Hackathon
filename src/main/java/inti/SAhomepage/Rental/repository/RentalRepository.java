package inti.SAhomepage.Rental.repository;

import inti.SAhomepage.Rental.domain.Rental;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface RentalRepository {
    void save(Rental rental);

    void delete(int product_id);

    Optional<Rental> findByProduct(int product_id);

    Optional<Rental> findByPayer(int payer_id);

    List<Rental> findAll();
}
