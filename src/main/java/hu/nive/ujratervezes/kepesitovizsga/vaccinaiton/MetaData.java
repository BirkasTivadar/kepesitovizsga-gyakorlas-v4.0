package hu.nive.ujratervezes.kepesitovizsga.vaccinaiton;

import java.time.LocalDate;

public class MetaData {

    private String postalCode;
    private String townName;
    private LocalDate date;

    public MetaData(String postalCode, String townName, LocalDate date) {
        this.postalCode = postalCode;
        this.townName = townName;
        this.date = date;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getTownName() {
        return townName;
    }

    public LocalDate getDate() {
        return date;
    }
}
