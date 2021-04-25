package hu.nive.ujratervezes.kepesitovizsga.vaccinaiton;

public class Town {

    private String townName;

    private String postalCode;

    public Town(String townName, String postalCode) {
        this.townName = townName;
        this.postalCode = postalCode;
    }

    public String getTownName() {
        return townName;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
