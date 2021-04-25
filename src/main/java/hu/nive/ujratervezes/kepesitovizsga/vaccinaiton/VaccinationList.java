package hu.nive.ujratervezes.kepesitovizsga.vaccinaiton;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class VaccinationList {

    private MetaData metaData;

    private Town town;

    private Map<LocalTime, Person> vaccinations = new LinkedHashMap<>();


    public MetaData getMetaData() {
        return metaData;
    }

    public Town getTown() {
        return town;
    }

    public Map<LocalTime, Person> getVaccinations() {
        return new LinkedHashMap<>(vaccinations);
    }

    public void readFromFile(BufferedReader br) {
        try {
            String line1 = br.readLine();
            String line2 = br.readLine();
            loadMetaData(line1, line2);

            town = new Town(metaData.getTownName(), metaData.getPostalCode());

            br.readLine();
            br.readLine();

            loadVaccinations(br);

        } catch (IOException ioException) {
            throw new IllegalStateException("Cannot read file");
        }
    }


    public List<Person> getPersonsMoreThanHundredYearsOld() {
        return vaccinations.values().stream().filter(e -> e.getAge() > 100).collect(Collectors.toList());
    }

    public List<Person> getAfternoonPersons() {
        List<LocalTime> temp = vaccinations.keySet().stream().filter(e -> e.isAfter(LocalTime.of(12, 0))).collect(Collectors.toList());
        List<Person> result = new ArrayList<>();
        for (LocalTime time : temp) {
            result.add(vaccinations.get(time));
        }
        return result;
    }

    public void validateTaj() throws Exception {
        StringBuilder message = new StringBuilder();
        boolean existInvalidTaj = false;
        for (Person person : vaccinations.values()) {
            if (!isTaj(person.getTaj())) {
                existInvalidTaj = true;
                message.append(person.getTaj()).append(", ");
            }
        }
        if (existInvalidTaj) {
            String exceptionMessage = message.substring(0, message.length() - 2);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public boolean isTaj(String taj) {
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            String str = taj.substring(i, i + 1);
            int digit = Integer.parseInt(str);
            if (i % 2 == 0) {
                sum += digit * 3;
            } else {
                sum += digit * 7;
            }
        }
        if (Integer.parseInt(taj.substring(8)) == sum % 10) {
            return true;
        }
        return false;
    }

    public String inviteExactPerson(LocalTime time) {
        if (vaccinations.containsKey(time)) {
            return String.format("Kedves %s! Ön következik. Kérem, fáradjon be!", vaccinations.get(time).getName());
        }
        throw new IllegalArgumentException("Ilyen időpontra nincs betegregisztráció");
    }

    public LocalDate getDateOfVaccination() {
        return metaData.getDate();
    }

    public Map<VaccinationType, Long> getVaccinationStatistics() {
        return vaccinations.values().stream().collect(Collectors.groupingBy(Person::getType, Collectors.counting()));
    }

    private void loadMetaData(String line1, String line2) {
        int commaIndex = line1.indexOf(",");

        String postalCode = line1.substring(commaIndex - 4, commaIndex);

        String afterCommaindex = line1.substring(commaIndex + 2);
        String townName = afterCommaindex.split(" ")[0];

        String date = line2.split(" ")[1];

        metaData = new MetaData(postalCode, townName, LocalDate.parse(date));
    }

    private void loadVaccinations(BufferedReader br) throws IOException {
        String line1;
        while ((line1 = br.readLine()) != null) {

            String[] lineArr = line1.split(";");

            LocalTime time = LocalTime.parse(lineArr[0]);

            Person person = null;

            if (lineArr.length == 6) {
                person = createPersonWithoutVaccination(lineArr);
            } else if (lineArr.length == 7) {
                person = createPersonWithVaccination(lineArr);
            }
            vaccinations.put(time, person);
        }
    }

    private Person createPersonWithVaccination(String[] lineArr) {
        String name = lineArr[1];
        int age = Integer.parseInt(lineArr[3]);
        String email = lineArr[4];
        String taj = lineArr[5];
        VaccinationType type = VaccinationType.valueOf(lineArr[6]);
        return new Person(name, age, email, taj, type);
    }

    private Person createPersonWithoutVaccination(String[] lineArr) {
        String name = lineArr[1];
        int age = Integer.parseInt(lineArr[3]);
        String email = lineArr[4];
        String taj = lineArr[5];
        return new Person(name, age, email, taj);
    }
}
