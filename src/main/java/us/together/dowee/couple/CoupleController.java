package us.together.dowee.couple;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CoupleController {

    private final CoupleService coupleService;


    @GetMapping("/couple/create")
    public String create(CoupleForm coupleForm) {

        return "coupleCreate";
    }


    @PostMapping("/couple/create")
    @ResponseBody
    public String create(@Valid @RequestBody CoupleForm coupleForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "error";
        }

        if(!coupleForm.getPassword1().equals(coupleForm.getPassword2())){
            bindingResult.rejectValue("password2","errorpassword2","비밀번호가 일치하지 않습니다.");
            return "error";
        }

        try {
            Integer coupldId = coupleService.join(coupleForm);
            System.out.println("coupldId = " + coupldId);
        }catch (Exception e){
            bindingResult.reject("404","오류야");
            return "error";
        }


        return "OK";
    }
}
