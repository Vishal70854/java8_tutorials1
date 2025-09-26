package org.example.streamAPI.maxMinExampleStreamApi;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() { return age; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name + " ->(" + age + ")";
    }
}
