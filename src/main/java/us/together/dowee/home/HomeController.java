package us.together.dowee.home;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


    @ResponseBody
    @GetMapping("/")
    public String Home(){
        return "여기가홈이야";
    }
}
