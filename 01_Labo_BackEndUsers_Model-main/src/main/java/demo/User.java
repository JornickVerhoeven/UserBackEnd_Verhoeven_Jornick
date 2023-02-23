package demo;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private int age;
    private List<Integer> membershipYears = new ArrayList<Integer>();
    private String email;
    private String password;

    public User(String name, int age, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = "@$-" + password + "&%#";

        if (age >= 0)
            this.age = age;
    }

    public int countMembershipYearsAfter1999() {
        int result = 0;
        for (Integer year : membershipYears) {
            if (year > 1999)
                result++;
        }
        return result;
    }

    public int getNumberOfMembershipYearsIn2000() {
        int result = 0;
        for (Integer year : membershipYears) {
            if (year >= 2000 && year < 3000)
                result++;
        }
        return result;
    }

    public boolean isPasswordCorrect(String password) {
        if (this.password.equals("@$-" + password + "&%#"))
            return true;
        else
            return false;
    }

    public int countYearsOfMembership() {
        return membershipYears.size();
    }

    public void addMembershipYear(int year) {
        membershipYears.add(year);
    }

    public int getFirstMembershipYear() {
        int result = Integer.MAX_VALUE;
        for (Integer year : membershipYears) {
            if (year < result)
                result = year;
        }
        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {

        if (email.contains("@") && email.contains(".") && email.length() > 5)
            return email;
        else
            return null;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return name + " is " + age + " years old and has as email " + email;
    }
}