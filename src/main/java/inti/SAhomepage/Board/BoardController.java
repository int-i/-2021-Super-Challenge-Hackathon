package inti.SAhomepage.Board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController { // index로 보냄.
    @RequestMapping(value = "/index")
    public String index(){
        return index();
    }
}