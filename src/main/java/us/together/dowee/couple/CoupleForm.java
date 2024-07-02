package us.together.dowee.couple;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoupleForm {

    @NotEmpty(message = "아이디는 비어있을 수 없습니다.")
    @Size(min = 3, max =20, message = "아이디는 5자 이상 20자 이하여야합니다.")
    String username;

    @NotEmpty(message = "비밀번호는 비어 있을 수 없습니다.")
    @Size(min = 3,max = 20, message = "비밀번호는 3자 이상, 20자 이하여야 합니다.")
    String password1;

    @NotEmpty(message = "비밀번호는 비어 있을 수 없습니다.")
    @Size(min = 3,max = 20, message = "비밀번호는 3자 이상, 20자 이하여야 합니다.")
    String password2;

    @NotEmpty(message = "이메일 주소를 입력해주세요")
    @Size(min=5, message = "올바른 이메일 주소를 입력해주세요")
    private String email;

}
