package JavaProject.Sqlite.domain.user.repository;

import JavaProject.Sqlite.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByAccountId(String accountId);

    boolean existsByAccountId(String accountId);

    List<User> findTop10ByOrderByScoreDesc();
}
