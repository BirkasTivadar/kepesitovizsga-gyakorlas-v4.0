package hu.nive.ujratervezes.kepesitovizsga.applicants;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApplicantsTest {

    private ApplicantListGenerator generator;
    private MysqlDataSource dataSource = new MysqlDataSource();

    @BeforeEach
    public void setUp() {
        dataSource.setUrl("jdbc:mysql://localhost:3306/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        Flyway fw = Flyway.configure().dataSource(dataSource).load();
        fw.clean();
        fw.migrate();
    }

    @Test
    void testListByApplicantsPersonal() {
        generator = new ListByApplicantsPersonal();
        List<Applicant> applicants = generator.getListFromDatabase(dataSource);

        assertEquals(1000, applicants.size());
        assertEquals("Bolding", applicants.get(12).getLastName());
        assertEquals("+353 (391) 686-0269", applicants.get(307).getPhoneNumber());
        assertEquals("sbuchananll@goodreads.com", applicants.get(777).getEmail());
        assertNull(applicants.get(456).getSkill());
        assertTrue(applicants.contains(new Applicant("Margarette", "Vaudin", "+33 (596) 756-4732", "mvaudin76@gov.uk")));
    }

    @Test
    void testListBySkills() {
        generator = new ListBySkills();
        List<Applicant> applicants = generator.getListFromDatabase(dataSource);

        assertEquals(178, applicants.size());
        assertEquals("Ashbridge", applicants.get(10).getLastName());
        assertEquals("Yuri", applicants.get(15).getFirstName());
        assertEquals("EKG", applicants.get(174).getSkill());
        assertNull(applicants.get(34).getPhoneNumber());
        assertNull(applicants.get(122).getEmail());
        assertTrue(applicants.contains(new Applicant("Zackariah", "Strewther", "DLX")));
    }
}