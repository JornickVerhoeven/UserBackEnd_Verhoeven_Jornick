package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private List<User> userRepository = new ArrayList<>();

    public UserService() {
        User elke = new User("Elke", 44, "elke@ucll.be", "elke");
        User miyo = new User("Miyo", 15, "miyo@ucll.be", "miyo");
        User eric = new User("Eric", 65, "eric@kuleuven.be", "eric");
        User yuki = new User("Yuki", 13, "yuki@ucll.be", "yuki");
        User stijn = new User("Stijn", 45, "stijn@ucll.be", "stijn");
        this.addUser(elke);
        this.addUser(miyo);
        this.addUser(eric);
        this.addUser(yuki);
        this.addUser(stijn);
    }

    public List<User> getAllUsers() {
        return userRepository;
    }

    public List<User> getUsersWithAgeOlderThan(int age) {
        return userRepository.stream().filter(user -> user.getAge() > age).toList();
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

    public User getUserWithName(String name) {
        return userRepository.stream().filter(user -> user.getName().equals(name)).toList().get(0);
    }

    public boolean addUser(User user) {
        for (User userL : userRepository) {
            if (userL.getEmail().equals(user.getEmail())) {
                return false;
            }
        }
        return userRepository.add(user);
    }

    public User getUserWithEmail(String email) {
        User rightUser = null;
        for (User user : userRepository) {
            if (user.getEmail().equals(email)) {
                rightUser = user;

            }
        }
        return rightUser;

    }

    public User removeUser(String string) {
        User foundUser = getUserWithEmail(string);
        if (foundUser == null) {
            return null;
        }
        int i = 0;
        int j = 0;
        for (User user : userRepository) {
            if (foundUser.equals(user)) {
                j = i;

            }
            i++;
        }
        userRepository.remove(j);
        return foundUser;

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