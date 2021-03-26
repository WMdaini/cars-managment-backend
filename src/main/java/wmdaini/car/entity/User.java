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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;

    private String login;

    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Comment> comments;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
