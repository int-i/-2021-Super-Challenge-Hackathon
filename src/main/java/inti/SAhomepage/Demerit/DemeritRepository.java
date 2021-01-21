package inti.SAhomepage.Demerit;
import java.util.List;
import java.util.Optional;
public interface DemeritRepository {

    Demerit save(Demerit demerit);
    List<Demerit> findByid(int id);
    List<Demerit> findAll();
}
