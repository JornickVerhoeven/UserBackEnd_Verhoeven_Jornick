package demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
@RequestMapping("/users")
public class UserRestController {

    private UserService userService;

    @Autowired
    UserRestController(UserService userService) {
        this.userService = userService;

        User elke = new User("Elke", 44, "elke.steegmans@ucll.be", "t");

        this.userService.addUser(elke);

        User miyo = new User("Miyo", 14, "myo@gmail.com", "t");
        this.userService.addUser(miyo);

        User yuki = new User("Yuki", 12, "yuki@gmail.com", "t");
        this.userService.addUser(yuki);

        User eric = new User("Eric", 65, "Eric@gmail.com", "t");
        this.userService.addUser(eric);

    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/oldest")
    public User getOldestUser() {
        return userService.getOldestUser();
    }

    @GetMapping("/search/olderthan")
    public List<User> searchUsersWithAgeOlderThan(@RequestParam("age") int age) {
        return userService.getUsersWithAgeOlderThan(age);
    }

    @GetMapping("/adults")
    public List<User> searchAdults() {
        return userService.getUsersWithAgeOlderThan(18);
    }

    @GetMapping("/search/email/{email}")
    public User searchUserWithEmail(@PathVariable("email") String email) {
        return userService.getUserWithEmail(email);
    }

    @GetMapping("/search/{email}/{age}")
    public List<User> searchUserWithEmailAndAge(@PathVariable("email") String email, @PathVariable("age") int age) {
        return userService.getUserWithEmailAndAge(email, age);
    }

    @GetMapping("/search/age/{min}/{max}")
    public List<User> searchUserWithAgeBetween(@PathVariable("min") int min, @PathVariable("max") int max) {
        return userService.getUsersWithAgeBetween(min, max);
    }

    @GetMapping("/search/{name}")
    public User searchUserWithName(@PathVariable("name") String name) {
        return userService.getUserWithName(name);
    }

}
