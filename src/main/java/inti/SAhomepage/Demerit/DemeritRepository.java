package inti.SAhomepage.Demerit;
import inti.SAhomepage.Demerit.Demerit;
import java.util.List;
import java.util.Optional;
public interface DemeritRepository {
    Demerit save(Demerit demerit);
    Optional<Demerit> findByid(int id);
    Optional<Demerit> findBynum(int num);
    Optional<Demerit> findByvalue(Float value);
    Optional<Demerit> findByreason(String reason);
    List<Demerit> findAll();
}
