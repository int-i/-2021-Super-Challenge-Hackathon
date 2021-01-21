package inti.SAhomepage.Locker.Repository;

import inti.SAhomepage.Locker.Domain.Lock;

import java.util.List;
import java.util.Optional;

public interface LockerRepository {

    void add(Lock lock);
    void delete(int id);
    List<Lock> findEmptyLocker();
    List<Lock> findAll();
}
