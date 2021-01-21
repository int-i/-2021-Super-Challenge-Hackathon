package inti.SAhomepage.Demerit;

import java.util.Optional;

public interface AdministratorRepository {
    Optional<Integer> check(Administrator administrator);
}
