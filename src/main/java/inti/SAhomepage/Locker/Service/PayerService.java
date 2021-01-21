package inti.SAhomepage.Locker.Service;

import inti.SAhomepage.Locker.Domain.Lock;
import inti.SAhomepage.Locker.Domain.Payer;
import inti.SAhomepage.Locker.Repository.JdbcLockerRepository;
import inti.SAhomepage.Locker.Repository.JdbcPayerRepository;
import inti.SAhomepage.Locker.Repository.LockerRepository;
import inti.SAhomepage.Locker.Repository.PayerRepository;

import java.util.List;

public class PayerService {

    private final PayerRepository payerRepository;
    private final LockerRepository lockerRepository;

    public PayerService(PayerRepository payerRepository,
                        LockerRepository lockerRepository) {
        this.lockerRepository = lockerRepository;
        this.payerRepository = payerRepository;
    }

    public void addPayer(Payer payer) {
        validateDuplicateId(payer);
        payerRepository.save(payer);
    }

    private void validateDuplicateId(Payer payer) {
        payerRepository.findByPayer_Id(payer.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 과자치비를 납부하였습니다");
                });
    }
    public List<Payer> show(){return payerRepository.findAll(); }
    public void findEmptyLocker() {
        lockerRepository.findEmptyLocker();
    }

    public void changeLocker(int Locker_id, int id) {
        payerRepository.update(id, Locker_id);
    }
}
