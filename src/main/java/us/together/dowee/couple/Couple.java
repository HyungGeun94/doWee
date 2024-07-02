package us.together.dowee.couple;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Getter
@Setter
public class Couple {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer coupleId;

    @Column(unique = true)
    private String userName;

    private String password;
//    private String role;

    @Column(unique = true)
    private String email;

}
