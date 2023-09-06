package org.example;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;
    public PersonBuilder() {
    }

    public PersonBuilder(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public PersonBuilder setName(String name) {
        return new PersonBuilder(name, this.surname, this.age, this.address);
    }

    public PersonBuilder setSurname(String surname) {
        return new PersonBuilder(this.name, surname, this.age, this.address);
    }

    public PersonBuilder setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Введен некорректный возраст");
        }
        return new PersonBuilder(this.name, this.surname, age, this.address);
    }

    public PersonBuilder setAddress(String address) {
        return new PersonBuilder(this.name, this.surname, this.age, address);
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Имя или фамилия не введены.");
        }

        if (age != 0) {
            if (address == null) {
                return new Person(name, surname, age);
            }
            Person person = new Person(name, surname, age);
            person.setAddress(address);
            return person;
        }

        if (address == null) {
            return new Person(name, surname);
        }

        Person person = new Person(name, surname, age);
        person.setAddress(address);
        return person;
    }
}