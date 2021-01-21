package inti.SAhomepage.Locker.Repository;

import inti.SAhomepage.Locker.Domain.Payer;

import java.util.List;
import java.util.Optional;

public interface PayerRepository {
    void save(Payer payer);
    void delete(int id);
    void update(int id, int Locker_id);
    Optional<Payer> findByPayer_Id(int id);
    Optional<Payer> findByLocker_Id(int Locker_id);
    List<Payer> findAll();
}
