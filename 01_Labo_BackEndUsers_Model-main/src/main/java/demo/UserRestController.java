package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

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

    @GetMapping("/search/{name}")
    public User searchUserWithName(@PathVariable("name") String name) {
        return userService.getUserWithName(name);
    }

    @GetMapping("/adults")
    public List<User> searchUsersAdults() {
        return userService.getUsersWithAgeOlderThan(17);
    }

    @GetMapping("/search/email/{email}")
    public User searchUsersEmail(@PathVariable("email") String email) {
        return userService.getUserWithEmail(email);
    }

    @GetMapping("/search")
    public List<User> searchUsersWithAgeOlderThanAndEmail(@RequestParam("email") String email,
            @RequestParam("age") int age) {
        return userService.functieBart(email, age);

    }

    @GetMapping("search/age/{min}/{max}")
    public List<User> searchWithAgeMinMax(@PathVariable("min") int min, @PathVariable("max") int max) {
        return userService.functieTom(min, max);

    }

    @GetMapping("search/{year}")
    public List<User> extra(@PathVariable("year") int year) {
        return userService.getUsersFromYear(year);

    }

}