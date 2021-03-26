package wmdaini.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wmdaini.car.entity.Car;
import wmdaini.car.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByCarOrderByDate(Car car);
}
