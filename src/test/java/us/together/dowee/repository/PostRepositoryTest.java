package us.together.dowee.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import us.together.dowee.domain.Couple;
import us.together.dowee.domain.Post;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostRepositoryTest {

    @Autowired PostRepository postRepository;

    @Autowired
    CoupleRepository coupleRepository;

    @Test
    void couplePost_연관관계(){

        Couple couple = new Couple();
        couple.setUserName("HyungGeun");
        couple.setEmail("goorm94@naver.com");
        couple.setPassword("pass");

        coupleRepository.save(couple);

        Post post = Post.createPost("첫번째 제목입니다", "첫번째 내용입니다", couple);

        postRepository.save(post);

        assertThat(postRepository.findById(post.getPostId()).get().getCouple()).isSameAs(couple);




    }

}