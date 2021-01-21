package inti.SAhomepage.Demerit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class DemeritController {
    private final DemeritService demeritService;
    private final AdministratorService administratorService;


    @Autowired
    public DemeritController(DemeritService demeritService, AdministratorService administratorService) {
        this.demeritService = demeritService;
        this.administratorService = administratorService;
    }
    @GetMapping ("demerit/view")
    public String createForm(){
        return "demerit/createview";
    }
    @PostMapping("demerit/view")
    public String list(DemeritForm form,Model model){
        List<Demerit> demerits = demeritService.findDemeritsbyid(form.getId());
        Optional<Float> sum=demeritService.Demeritsum(form.getId());
        model.addAttribute("demerits",demerits);
        model.addAttribute("id",form.getId());
        model.addAttribute("sum",sum.get());
        return "demerit/demeritView";
    }
    @PostMapping("demerit/insert")
    public String manager_insert(Demerit form,Model model){
        demeritService.Demerit(form);
        List<Demerit> demerits = demeritService.findDemerits();
        model.addAttribute("demerits",demerits);
        return "demerit/demeritList";
    }
    @PostMapping("demerit/update")
    public String manager_update(Demerit form,Model model){
        demeritService.update(form);
        List<Demerit> demerits = demeritService.findDemerits();
        model.addAttribute("demerits",demerits);
        return "demerit/demeritList";
    }
    @PostMapping("demerit/delete")
    public String manager_delete(Demerit form,Model model){
        demeritService.delete(form);
        List<Demerit> demerits = demeritService.findDemerits();
        model.addAttribute("demerits",demerits);
        return "demerit/demeritList";
    }
    @GetMapping("demerit/manager")
    public String all_list(Model model){
        List<Demerit> demerits = demeritService.findDemerits();
        model.addAttribute("demerits",demerits);
        return "demerit/demeritList";
    }

    @GetMapping ("demerit/check")
    public String checkForm(){
        return "demerit/check";
    }

    @PostMapping("demerit/checking")
    public String check(Administrator administrator,Model model){
        Optional<Integer> res=administratorService.check(administrator);
        if(res.get()==0)return "/demerit/check";
        else {
            List<Demerit> demerits = demeritService.findDemerits();
            model.addAttribute("demerits",demerits);
            return "demerit/demeritList";
            }
    }
}
