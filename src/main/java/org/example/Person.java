package org.example;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private int age;
    private String address;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public PersonBuilder newChildBuilder(int age) {
        if (age <= 0 | age >= 18) {
            throw new IllegalArgumentException("Введен некорректный возраст");
        }
        return new PersonBuilder(null, this.surname, age, this.address);
    }


    public boolean hasAge() {
        return age != 0;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (age != 0) {
            return OptionalInt.of(age);
        }
        return OptionalInt.empty();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        this.age++;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}