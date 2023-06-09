package org.example;

public class Human {
    private String name;
    private String surname;
    private int age;
    public Human(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("Имя: %s, Фамилия: %s, Возраст: %s.", getName(), getSurname(), getAge());
    }
}
