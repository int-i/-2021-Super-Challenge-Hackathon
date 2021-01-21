package inti.SAhomepage.Rental.service;

import inti.SAhomepage.Locker.Domain.Payer;
import inti.SAhomepage.Locker.Repository.PayerRepository;
import inti.SAhomepage.Rental.domain.Product;
import inti.SAhomepage.Rental.domain.Rental;
import inti.SAhomepage.Rental.domain.Reservation;
import inti.SAhomepage.Rental.repository.ProductRepository;
import inti.SAhomepage.Rental.repository.RentalRepository;
import inti.SAhomepage.Rental.repository.ReservationRepository;

import java.util.List;
import java.util.Optional;

public class RentalService {
    private final RentalRepository rentalRepository;
    private final ProductRepository productRepository;
    private final ReservationRepository reservationRepository;
    private final PayerRepository payerRepository;

    public RentalService(ProductRepository productRepository,
                         RentalRepository rentalRepository,
                         ReservationRepository reservationRepository,
                         PayerRepository payerRepository) {
        this.rentalRepository = rentalRepository;
        this.productRepository = productRepository;
        this.reservationRepository = reservationRepository;
        this.payerRepository = payerRepository;
    }

    public void addProduct(Product product) {
        validateDuplicateProduct(product);
        productRepository.save(product);
    }

    // 물품 이름과 번호가 같은 상품이 있는지 검사
    private void validateDuplicateProduct(Product member) {
        productRepository.findByIdAndName(member.getProduct_id(), member.getProduct_name())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 물품번호 입니다.");
                });
    }

    public List<Product> findProducts() {
        List<Product> all = productRepository.findAll();
        for (Product p : all) {
            reservationRepository.findByProductId(p.getProduct_id())
                    .ifPresentOrElse(
                            (r) -> {
                                p.setReserver(reservationRepository.findReserver(r.getPayer_id()));
                            },
                            () -> {
                                p.setReserver(null);
                            });
            rentalRepository.findByProduct(p.getProduct_id())
                    .ifPresentOrElse(
                            (r) -> {
                                p.setChecker(r.getChecker());
                            },
                            () -> {
                                p.setChecker(null);
                            });
        }
        return all;
    }

    public Optional<Product> findOneProduct(int product_id) {
        return productRepository.findByProductId(product_id);
    }

    public void rent(Rental rental) {
        rentalRepository.save(rental);
        reservationRepository.findByProductId(rental.getProduct_id())
                .ifPresent(r -> {
                    reservationRepository.delete(rental.getProduct_id());
                });
        productRepository.updateState(rental.getProduct_id(), 1);
    }

    public void back(int product_id) {
        rentalRepository.delete(product_id);
        productRepository.updateState(product_id, 0);
    }


    public List<Rental> findRentals() {
        return rentalRepository.findAll();
    }

    public void reserve(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public boolean reserved(int product_id) {
        return reservationRepository.findByProductId(product_id).isPresent();
    }

    public Optional<Reservation> findOneReservation(int product_id) {
        return reservationRepository.findByProductId(product_id);
    }

    public boolean paid(int payer_id) {
        return payerRepository.findByPayer_Id(payer_id).isPresent();
    }
}
