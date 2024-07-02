package us.together.dowee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import us.together.dowee.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
