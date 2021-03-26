package wmdaini.car.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCar;

    private String registrationNumber;

    private String brand;

    private String picture;

    @Column(length = 3000)
    private String description;

    private String model;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private List<Comment> comments;

    public Car(String registrationNumber, String brand, String picture, String model, String description) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.picture = picture;
        this.description = description;
        this.model = model;
    }
}
