package hu.nive.ujratervezes.kepesitovizsga.vaccinaiton;

public class Person {

    private String name;
    private int age;
    private String email;
    private String taj;
    private VaccinationType type;

    public Person(String name, int age, String email, String taj) {
        this(name, age, email, taj, VaccinationType.NONE);
    }

    public Person(String name, int age, String email, String taj, VaccinationType type) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.taj = taj;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getTaj() {
        return taj;
    }

    public VaccinationType getType() {
        return type;
    }
}
