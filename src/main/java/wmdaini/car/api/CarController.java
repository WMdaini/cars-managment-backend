package wmdaini.car.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wmdaini.car.entity.Car;
import wmdaini.car.repository.CarRepository;
import wmdaini.car.repository.CommentRepository;
import wmdaini.car.util.StorageService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/car/")
@CrossOrigin("*")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private StorageService storageService;

    @RequestMapping(value = "getAll",method = RequestMethod.GET)
    public List<Car> getAllCars(){
        return this.carRepository.findAll();
    }

    @GetMapping(path = "/getImage/{idCar}")
    public ResponseEntity<Resource> getCarImg(@PathVariable Long idCar) throws IOException {
        Car car = this.carRepository.findByIdCar(idCar);
        Resource imageRs = storageService.loadFile(car.getPicture());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imageRs.getFilename() + "\"")
                .body(imageRs);
    }
}
