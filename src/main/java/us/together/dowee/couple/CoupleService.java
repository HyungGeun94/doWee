package us.together.dowee.couple;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CoupleService {

    private final CoupleRepository coupleRepository;

    public Integer join(CoupleForm coupleForm) {

        Couple couple = new Couple();
        couple.setUserName(coupleForm.getUsername());
//        couple.setRole();
        couple.setPassword(coupleForm.getPassword1());
        couple.setEmail(coupleForm.getEmail());

        coupleRepository.save(couple);
        return couple.getCoupleId();
    }

}
