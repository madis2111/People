package org.example;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder(1)
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        try {
            Person dima = new PersonBuilder()
                    .setName("Dima")
                    .setSurname("Pupkin")
                    .setAge(20)
                    .build();
            System.out.println(dima);
            System.out.println(dima.getAge().getAsInt());
            dima.happyBirthday();
            System.out.println(dima.getAge().getAsInt());
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}