package inti.SAhomepage.Demerit;

import java.util.Optional;

public class AdministratorService {
    private AdministratorRepository administratorRepository;

    public AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    public Optional<Integer> check(Administrator administrator){
        return administratorRepository.check(administrator);
    }
}
