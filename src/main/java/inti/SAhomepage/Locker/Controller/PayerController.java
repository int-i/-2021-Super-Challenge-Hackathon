package inti.SAhomepage.Locker.Controller;

import inti.SAhomepage.Demerit.Demerit;
import inti.SAhomepage.Demerit.DemeritForm;
import inti.SAhomepage.Locker.Service.PayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Optional;
import inti.SAhomepage.Locker.Domain.Lock;
@Controller
public class PayerController {

    private final PayerService payerService;

    @Autowired
    public PayerController(PayerService payerService) {
        this.payerService = payerService;
    }

    @GetMapping("locker/control")
    public String list(Model model){
        return "/locker/ControlLocker";
    }

}
