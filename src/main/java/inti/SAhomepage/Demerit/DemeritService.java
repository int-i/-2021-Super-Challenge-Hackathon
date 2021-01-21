package inti.SAhomepage.Demerit;

import java.util.List;

public class DemeritService {


    private DemeritRepository demeritRepository;

    public DemeritService(DemeritRepository demeritRepository) {
        this.demeritRepository = demeritRepository;
    }

    public List<Demerit> findDemeritsbyid(int id){
        return demeritRepository.findByid(id);
    }
    public List<Demerit> findDemerits(){
        return demeritRepository.findAll();
    }
}
