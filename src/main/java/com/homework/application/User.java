package com.homework.application;

import org.springframework.stereotype.Component;

@Component
public class User {
    private static String username;
    private static String password;

    private String name;
    private String lastName;
    private int age;

    public User(String name, String lastName, int age) {
        setName(name);
        setLastName(lastName);
        setAge(age);
    }

    public User() {

    }

    public static User getSpecificUserByUsername() {
        switch (username) {
            case "Mishu":
                return new User("Mihai", "Toncu", 32);
            case "Cristian":
                return new User("Cristian", "Popescu", 25);
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return
                "The information for the logged in user is: \n" +
                        "Name: " + name + "\n" +
                        "Last Name: " + lastName + "\n" +
                        "Age: " + age + "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}