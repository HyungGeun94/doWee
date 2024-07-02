package us.together.dowee.couple;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class CoupleRepositoryTest {

    @Autowired CoupleRepository coupleRepository;


    @Test
    void 가입테스트(){

        Couple couple = new Couple();
        couple.setUserName("HyungGeun");
        couple.setPassword("password");
        couple.setEmail("goorm94@naver.com");

        coupleRepository.save(couple);

        Couple findCouple = coupleRepository.findById(1).get();

        assertThat(findCouple.getCoupleId()).isEqualTo(1);
    }
}
