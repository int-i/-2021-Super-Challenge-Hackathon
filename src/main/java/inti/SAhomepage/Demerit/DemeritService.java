package inti.SAhomepage.Demerit;

import java.util.List;
import java.util.Optional;

public class DemeritService {


    private DemeritRepository demeritRepository;

    public DemeritService(DemeritRepository demeritRepository) {
        this.demeritRepository = demeritRepository;
    }
    public void Demerit(Demerit demerit){
        demeritRepository.save(demerit);
    }
    public void update(Demerit demerit){
        demeritRepository.update(demerit);
    }
    public void delete(Demerit demerit){
        demeritRepository.delete(demerit);
    }
    public Optional<Float> Demeritsum(int id){
        return demeritRepository.sumByid(id);
    }
    public List<Demerit> findDemeritsbyid(int id){
        return demeritRepository.findByid(id);
    }
    public List<Demerit> findDemerits(){
        return demeritRepository.findAll();
    }
}
