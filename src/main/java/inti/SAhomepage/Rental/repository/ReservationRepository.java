package inti.SAhomepage.Rental.repository;

import inti.SAhomepage.Rental.domain.Reservation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    void save(Reservation reservation);

    void delete(int product_id);

    Optional<Reservation> findByProductId(int product_id);

    Optional<Reservation> findByPayerId(int payer_id);

    List<Reservation> findAll();
}
