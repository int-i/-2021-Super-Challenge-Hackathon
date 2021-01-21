package inti.SAhomepage.Demerit;

import java.util.List;
import java.util.Optional;

public class MemoryDemeritRepository implements DemeritRepository{
    @Override
    public Demerit save(Demerit demerit) {
        return null;
    }

    @Override
    public Optional<Demerit> findByid(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<Demerit> findBynum(int num) {
        return Optional.empty();
    }

    @Override
    public Optional<Demerit> findByvalue(Float value) {
        return Optional.empty();
    }

    @Override
    public Optional<Demerit> findByreason(String reason) {
        return Optional.empty();
    }

    @Override
    public List<Demerit> findAll() {
        return null;
    }
}
