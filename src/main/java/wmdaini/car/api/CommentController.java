package wmdaini.car.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wmdaini.car.entity.Car;
import wmdaini.car.entity.Comment;
import wmdaini.car.repository.CommentRepository;

import java.util.List;

@RestController
@RequestMapping(value = "comment/")
@CrossOrigin("*")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping(value = "/getComments",method = RequestMethod.POST)
    public List<Comment> getComments(@RequestBody Car car){
        return this.commentRepository.findByCarOrderByDate(car);
    }

    @RequestMapping(value = "/addComment",method = RequestMethod.POST)
    public Comment getComments(@RequestBody Comment comment){
        return this.commentRepository.save(comment);
    }
}
