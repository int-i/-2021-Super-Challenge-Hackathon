package inti.SAhomepage.Demerit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class DemeritController {
    private final DemeritService demeritService;

    @Autowired
    public DemeritController(DemeritService demeritService) {
        this.demeritService = demeritService;
    }
    @GetMapping ("demerit/view")
    public String createForm(){
        return "demerit/createview";
    }
    @PostMapping("demerit/view")
    public String list(DemeritForm form,Model model){
        List<Demerit> demerits = demeritService.findDemeritsbyid(form.getId());

        model.addAttribute("demerits",demerits);
        return "demerit/demeritView";
    }

    @GetMapping("demerit/all")
    public String all_list(Model model){
        List<Demerit> demerits = demeritService.findDemerits();
        model.addAttribute("demerits",demerits);
        return "demerit/demeritList";
    }
}
