package wmdaini.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wmdaini.car.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByLoginAndAndPassword(String login, String password);
}
