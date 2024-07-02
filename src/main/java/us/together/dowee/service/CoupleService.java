package us.together.dowee.service;


import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.together.dowee.controller.CoupleForm;
import us.together.dowee.domain.Couple;
import us.together.dowee.repository.CoupleRepository;


@RequiredArgsConstructor
@Service
@Transactional
public class CoupleService {

    private final CoupleRepository coupleRepository;

    public Integer join(CoupleForm coupleForm) throws Exception{

        if (!coupleRepository.findByEmail(coupleForm.getEmail()).isEmpty()) {

            throw new DataIntegrityViolationException("이미 존재하는 이메일입니다");
        }

        if (!coupleRepository.findByUserName(coupleForm.getUsername()).isEmpty()) {
            throw new DataIntegrityViolationException("이미 존재하는 회원입니다");

        }


        Couple couple = new Couple();
        couple.setUserName(coupleForm.getUsername());
        couple.setPassword(coupleForm.getPassword1());
        couple.setEmail(coupleForm.getEmail());

        coupleRepository.save(couple);

        return couple.getCoupleId();
    }

}
