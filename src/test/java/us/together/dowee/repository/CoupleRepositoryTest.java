package us.together.dowee.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;
import us.together.dowee.controller.CoupleForm;
import us.together.dowee.domain.Couple;
import us.together.dowee.repository.CoupleRepository;
import us.together.dowee.service.CoupleService;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional(readOnly = true)
public class CoupleRepositoryTest {

    @Autowired CoupleRepository coupleRepository;

    @Autowired CoupleService coupleService;


    @Test
    @Transactional
    void 가입테스트O(){

        Couple couple = new Couple();
        couple.setUserName("HyungGeun");
        couple.setPassword("password");
        couple.setEmail("goorm94@naver.com");
        coupleRepository.save(couple);


        Couple findCouple = coupleRepository.findById(1).get();



        assertThat(coupleRepository.count()).isEqualTo(1);
        assertThat(findCouple.getCoupleId()).isEqualTo(couple.getCoupleId());
    }

    @Test
    @Transactional
    void 중복_가입이름_예외() throws Exception{

        CoupleForm coupleFormA = new CoupleForm();
        coupleFormA.setUsername("Jeon");
        coupleFormA.setPassword1("asdasd");
        coupleFormA.setEmail("Dif1");

        coupleService.join(coupleFormA);

        assertThat(coupleRepository.findByEmail("Dif1").get()).isNotNull();
        assertThat(coupleRepository.findByUserName("Jeo")).isEmpty();


        CoupleForm coupleFormB = new CoupleForm();
        coupleFormB.setUsername("Jeon");
        coupleFormB.setPassword1("asdasd");
        coupleFormB.setEmail("Dif2");

        DataIntegrityViolationException exception = assertThrows(DataIntegrityViolationException.class,() ->coupleService.join(coupleFormB));

        assertThat(exception.getMessage()).contains("회원입니다");

    }

    @Test
    @Transactional
    void 중복_가입이메일_예외() throws Exception{

        CoupleForm coupleFormA = new CoupleForm();
        coupleFormA.setUsername("Je");
        coupleFormA.setPassword1("asdasd");
        coupleFormA.setEmail("Dif1");

        coupleService.join(coupleFormA);

        assertThat(coupleRepository.findByEmail("Dif1").get()).isNotNull();
        assertThat(coupleRepository.findByUserName("Jeo")).isEmpty();


        CoupleForm coupleFormB = new CoupleForm();
        coupleFormB.setUsername("Jeon");
        coupleFormB.setPassword1("asdasd");
        coupleFormB.setEmail("Dif1");

        DataIntegrityViolationException exception = assertThrows(DataIntegrityViolationException.class,() ->coupleService.join(coupleFormB));

        assertThat(exception.getMessage()).contains("메일입니다");
    }
}
