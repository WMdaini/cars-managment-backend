package wmdaini.car.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import wmdaini.car.entity.Car;
import wmdaini.car.entity.Comment;
import wmdaini.car.entity.User;
import wmdaini.car.repository.CarRepository;
import wmdaini.car.repository.CommentRepository;
import wmdaini.car.repository.UserRepository;

import java.util.List;


@Component
public class Initializer implements CommandLineRunner {

    @Autowired private CarRepository carRepository;

    @Autowired private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Car> cars = carRepository.findAll();
        List<User> users = userRepository.findAll();
        if(cars.size() == 0) {
            Car car1 = new Car("GT20 BHP","volkswagen","volkswagen.jpg","TIGAN","The Volkswagen Tiguan is a compact crossover SUV manufactured by German automaker Volkswagen");
            Car car2 = new Car("PII N40","Audi","audi.jpg","A3","Powered by fuel, battery or a combination of both - and a purely electric range of up to 41 miles1 per charge - the new A3 Sportback TFSI e is the latest in our range of plug-in hybrids and is the successor to the original Audi plug-in hybrid, the A3 e-tron.");
            Car car3 = new Car("Y50 D0L","Fiat","fiat.jpg","F500","is a rear-engined, four-seat, small city car that was manufactured and marketed by Fiat Automobiles from 1957 to 1975 ");
            cars.add(car1);
            cars.add(car2);
            cars.add(car3);
            carRepository.saveAll(cars);
        }
        if(users.size() == 0) {
            User user = new User("user","user");
            users.add(user);
            userRepository.saveAll(users);
        }
    }
}
