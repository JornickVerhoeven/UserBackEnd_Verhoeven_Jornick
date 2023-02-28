package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private List<User> userRepository = new ArrayList<>();

    public UserService() {
    }

    public List<User> getAllUsers() {
        return userRepository;
    }

    public List<User> getUsersWithAgeOlderThan(int age) {
        return userRepository.stream().filter(user -> user.getAge() > age).toList();
    }

    public List<User> getUserWithEmailAndAge(String email, int age) {
        if (userRepository.stream().filter(user -> user.getEmail().equals(email) && user.getAge() == age).toList()
                .size() == 0)
            return null;
        return userRepository.stream().filter(user -> user.getEmail().equals(email) && user.getAge() == age).toList();
    }

    public User getOldestUser() {
        User oldest = null;
        if (userRepository.size() > 0) {
            oldest = userRepository.get(0);
            for (User user : userRepository) {
                if (user.getAge() > oldest.getAge())
                    oldest = user;
            }
        }
        return oldest;
    }

    public List<User> getUsersWithAgeBetween(int minAge, int maxAge) {
        if (userRepository.stream().filter(user -> user.getAge() >= minAge && user.getAge() <= maxAge).toList()
                .size() == 0)
            return null;
        return userRepository.stream().filter(user -> user.getAge() >= minAge && user.getAge() <= maxAge).toList();
    }

    public User getUserWithName(String name) {
        return userRepository.stream().filter(user -> user.getName().equals(name)).toList().get(0);
    }

    public User getUserWithEmail(String email) {
        if (userRepository.stream().filter(user -> user.getEmail().equals(email)).toList().size() == 0)
            return null;
        return userRepository.stream().filter(user -> user.getEmail().equals(email)).toList().get(0);
    }

    public User removeUser(String email) {
        User user = getUserWithEmail(email);
        if (user != null) {
            userRepository.remove(user);
        }
        return user;
    }

    public boolean addUser(User user) {
        for (User u : userRepository) {
            if (u.getEmail().equals(user.getEmail())) {
                return false;
            }
        }
        userRepository.add(user);
        return true;

    }

}
