package wmdaini.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wmdaini.car.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByIdCar(Long id);
}
