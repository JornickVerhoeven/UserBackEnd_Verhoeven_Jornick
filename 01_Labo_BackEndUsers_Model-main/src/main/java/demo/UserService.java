package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService() {
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersWithAgeOlderThan(int age) {
        return userRepository.findUsersByAgeAfter(age);
    }

    public List<User> findAllByOrderByAgeDesc() {
        return userRepository.findAllByOrderByAgeDesc();
    }

    public User getOldestUser() {
        if (userRepository.findAllByOrderByAgeDesc() == null) {
            return null;
        }

        return userRepository.findAllByOrderByAgeDesc().get(0);

    }

    public User getUserWithName(String name) {
        return userRepository.stream().filter(user -> user.getName().equals(name)).toList().get(0);
    }

    public boolean addUser(User user) {
        if (getUserWithEmail(user.getEmail()) != null)
            return false;
        userRepository.save(user);
        return true;
    }

    public User getUserWithEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User removeUser(String string) {
        User user = getUserWithEmail(string);
        if (user == null) {
            return null;
        }
        userRepository.delete(user);
        return user;

    }

    public List<User> getUsersFromYear(int year) {
        List<User> newList = new ArrayList<>();
        for (User user : userRepository) {
            for (Integer jaar : user.membershipYears) {
                if (jaar == year) {
                    newList.add(user);
                }
            }

        }
        return newList;

    }

    public List<User> functieBart(String email, int age) {
        List<User> david = getUsersWithAgeOlderThan(age);
        List<User> Bart = new ArrayList<>();
        for (User user : david) {
            if (user.getEmail().equals(email)) {
                Bart.add(user);

            }
        }
        return Bart;
    }

    public List<User> functieTom(int min, int max) {
        List<User> Tom = new ArrayList<>();
        for (User user : userRepository) {
            if (user.getAge() > min && user.getAge() < max) {
                Tom.add(user);

            }
        }
        return Tom;
    }
}