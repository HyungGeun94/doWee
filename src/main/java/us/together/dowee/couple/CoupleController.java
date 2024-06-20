package us.together.dowee.couple;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;

@Controller
@RequiredArgsConstructor
public class CoupleController {

    private final CoupleService coupleService;


    @GetMapping("/couple/create")
    public String create(CoupleForm coupleForm) {

        return "coupleCreate";
    }


    @PostMapping("/couple/create")
    public String create(@Valid CoupleForm coupleForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "coupleCreate";
        }

        if(!coupleForm.getPassword1().equals(coupleForm.getPassword2())){
            bindingResult.rejectValue("password2","errorpassword2","비밀번호가 일치하지 않습니다.");

            return "coupleCreate";
        }

        try {
            Integer coupldId = coupleService.join(coupleForm);
            System.out.println("coupldId = " + coupldId);
        }catch (Exception e){
            bindingResult.reject("404","전체예외로잡아내기.");
            return "coupleCreate";
        }


        return "redirect:/";
    }
}
