package hu.nive.ujratervezes.kepesitovizsga.applicants;

import java.util.Objects;

public class Applicant {

    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
    private String codeNumber;
    private String skill;

    public Applicant(String firstName, String lastName, String gender, String phoneNumber, String email, String codeNumber, String skill) {
        this(firstName, lastName, phoneNumber, email);
        this.gender = gender;
        this.codeNumber = codeNumber;
        this.skill = skill;
    }

    public Applicant(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Applicant(String firstName, String lastName, String skill) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.skill = skill;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public String getSkill() {
        return skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Applicant applicant = (Applicant) o;
        return Objects.equals(firstName, applicant.firstName) && Objects.equals(lastName, applicant.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
