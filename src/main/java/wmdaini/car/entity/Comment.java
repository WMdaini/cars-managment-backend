package wmdaini.car.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idComment;

    private String comment;

    private Date date;

    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Comment(String comment) {
        this.comment = comment;
    }

    @PrePersist
    void generateDate(){
        this.date = new Date();
    }
}
