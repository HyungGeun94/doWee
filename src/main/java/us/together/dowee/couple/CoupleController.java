package us.together.dowee.couple;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


//@RestController
@RequiredArgsConstructor
@Controller
public class CoupleController {

    private final CoupleService coupleService;

    @GetMapping("/couple/create")
    public String getCreate(CoupleForm coupleForm) {
        return "coupleCreate";
    }


    @PostMapping("/couple/create")
    public String create(@Valid CoupleForm coupleForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "coupleCreate";
        }

        if(!coupleForm.getPassword1().equals(coupleForm.getPassword2())){

            return "coupleCreate";

        }

        try {
            Integer coupldId = coupleService.join(coupleForm);
        }catch (Exception e){

            return "coupleCreate";
        }


        return "redirect:/";
    }
}
