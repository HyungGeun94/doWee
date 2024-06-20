package us.together.dowee.couple;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoupleForm {

    @NotEmpty
    String username;

    @NotEmpty
    @Size(min = 10,max = 20)
    String password1;

    @NotEmpty
    @Size(min = 10,max = 20)
    String password2;
}
