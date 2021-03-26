package wmdaini.car.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wmdaini.car.entity.User;
import wmdaini.car.repository.UserRepository;

@RestController
@RequestMapping(value = "/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public User login(@RequestBody User user){
        return this.userRepository.findByLoginAndAndPassword(user.getLogin(),user.getPassword());
    }
}
