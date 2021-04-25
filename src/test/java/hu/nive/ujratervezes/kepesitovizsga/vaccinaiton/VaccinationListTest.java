package hu.nive.ujratervezes.kepesitovizsga.vaccinaiton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class VaccinationListTest {

    private VaccinationList list;

    @BeforeEach
    public void setUp() {
        list = new VaccinationList();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(VaccinationListTest.class.getResourceAsStream("/vaccinationlist_2021-03-02_1234.csv")))) {
            list.readFromFile(br);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    @Test
    void testSetUp() {
        assertEquals(16, list.getVaccinations().size());
        assertEquals("1234", list.getMetaData().getPostalCode());
        assertEquals("Kukutyin", list.getMetaData().getTownName());
        assertEquals(LocalDate.of(2021, 3, 2), list.getMetaData().getDate());
    }

    @Test
    void testGetPersonsMoreThanHundredYearsOld() {
        assertEquals(11, list.getPersonsMoreThanHundredYearsOld().size());
        assertEquals("Lurlene Dunphie", list.getPersonsMoreThanHundredYearsOld().get(3).getName());
        assertEquals(116, list.getPersonsMoreThanHundredYearsOld().get(5).getAge());
    }

    @Test
    void testGetAfternoonPersons() {
        assertEquals(7, list.getAfternoonPersons().size());
        assertEquals("Benny Wallis", list.getAfternoonPersons().get(1).getName());
        assertEquals(72, list.getAfternoonPersons().get(4).getAge());
    }

    @Test
    void testValidateTaj() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> list.validateTaj());
        assertEquals("787340842, 190339732", ex.getMessage());
    }

    @Test
    void testInviteExactPerson() {
        assertEquals("Kedves Evie Waddams! Ön következik. Kérem, fáradjon be!", list.inviteExactPerson(LocalTime.of(13, 30)));
    }

    @Test
    void testGetTown() {
        assertEquals("1234", list.getTown().getPostalCode());
        assertEquals("Kukutyin", list.getTown().getTownName());
    }

    @Test
    void testGetDateOfVaccination() {
        assertEquals(LocalDate.of(2021, 3, 2), list.getDateOfVaccination());
    }

    @Test
    public void testGetVaccinationStatistics() {
        Map<VaccinationType, Long> expected = list.getVaccinationStatistics();

        assertEquals(9, expected.get(VaccinationType.NONE));
        assertEquals(3, expected.get(VaccinationType.PFIZER));
    }

}