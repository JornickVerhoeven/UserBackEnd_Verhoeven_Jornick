package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class User {

    private String name;
    private int age;
    private String Email;
    private String Password;
    public List<Integer> membershipYears = new ArrayList<Integer>();

    public User(String name, int age, String Email, String Password) {
        this.name = name;
        if (age >= 0) {
            this.age = age;
        } else {
            this.age = 0;
        }
        // this.age = age;
        this.Email = Email;
        this.Password = Password;
    }

    public int countMembershipYearsAfter1999() {
        int result = 0;
        for (Integer year : membershipYears) {
            if (year > 1999)
                result++;
        }
        return result;
    }

    public int countYearsOfMembership() {
        return membershipYears.size();
    }

    public void addMembershipYear(int year) {
        membershipYears.add(year);
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public boolean traverseString(String str) {
        char[] ch = str.toCharArray();

        // Traverse the character array
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '@') {
                return true;
            }
        }
        return false;
    }

    public String getEmail() {
        if (traverseString(this.Email) == false) {
            return null;
        }
        return this.Email;
    }

    public String getPassword() {
        if (this.Password == "    ") {
            this.Password = "t";
        }
        return "@$-" + this.Password + "&%#";
    }

    public int getFirstMembershipYear() {
        if (membershipYears.size() == 0) {
            return 0;
        }
        Collections.sort(membershipYears);
        return membershipYears.get(0);
    }

    public int countMembershipYearsAfter2999() {
        int result = 0;
        for (Integer year : membershipYears) {
            if (year > 2999)
                result++;
        }
        return result;
    }

    public int getNumberOfMembershipYearsIn2000() {
        return countMembershipYearsAfter1999() - countMembershipYearsAfter2999();

    }

    public boolean isPasswordCorrect(String string) {
        if (string == this.Password) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.name + " is " + this.age + " years old and has as email " + this.Email;

    }

}