package us.together.dowee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import us.together.dowee.domain.Couple;

import java.util.Optional;

public interface CoupleRepository extends JpaRepository<Couple, Integer> {

    Optional<Couple> findByUserName(String userName);

    Optional<Couple> findByEmail(String email);

}
