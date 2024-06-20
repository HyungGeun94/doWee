package us.together.dowee.couple;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Couple {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer coupleId;
    private String userName;
    private String password;
//    private String role;

}
