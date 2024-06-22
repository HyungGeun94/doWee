package us.together.dowee.couple;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class CoupleController {

    private final CoupleService coupleService;


//    @GetMapping("/couple/create")
//    public String create(CoupleForm coupleForm) {
//        return "coupleCreate";
//    }


    @PostMapping("/couple/create")
    public ResponseEntity<?> create(@Valid @RequestBody CoupleForm coupleForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("값이 올바르지 않습니다(@Valid)에 걸림");
        }

        if(!coupleForm.getPassword1().equals(coupleForm.getPassword2())){
            bindingResult.rejectValue("password2","errorpassword2","비밀번호가 일치하지 않습니다.");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("값이 올바르지 않습니다(비밀번호가 두개가 다름)");

        }

        try {
            Integer coupldId = coupleService.join(coupleForm);
            System.out.println("coupldId = " + coupldId);
        }catch (Exception e){
            bindingResult.reject("404", "이메일 혹은 아이디 " +
                    "이미 존재");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이메일 혹은 아이디가 이미존재합니다");
        }


        return ResponseEntity.ok("ok");
    }
}
