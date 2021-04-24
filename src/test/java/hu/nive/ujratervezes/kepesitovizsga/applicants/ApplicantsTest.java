package hu.nive.ujratervezes.kepesitovizsga.applicants;

import static org.junit.jupiter.api.Assertions.*;

class ApplicantsTest {
//    private ApplicantListGenerator generator;
//    private MariaDbDataSource dataSource;
//
//    @BeforeEach
//    public void setUp() {
//        try {
//            dataSource = new MariaDbDataSource();
//            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
//            dataSource.setUser("employees");
//            dataSource.setPassword("employees");
//        } catch (SQLException sqle) {
//            throw new IllegalStateException("Can not get data.", sqle);
//        }
//
//        Flyway fw = Flyway.configure().dataSource(dataSource).load();
//        fw.clean();
//        fw.migrate();
//    }
//
//    @Test
//    public void testListByApplicantsPersonal() {
//        generator = new ListByApplicantsPersonal();
//        List<Applicant> applicants = generator.getListFromDatabase(dataSource);
//
//        Assertions.assertEquals(1000, applicants.size());
//        Assertions.assertEquals("Bolding", applicants.get(12).getLastName());
//        Assertions.assertEquals("+353 (391) 686-0269", applicants.get(307).getPhoneNumber());
//        Assertions.assertEquals("sbuchananll@goodreads.com", applicants.get(777).getEmail());
//        Assertions.assertNull(applicants.get(456).getSkill());
//        Assertions.assertTrue(applicants.contains(new Applicant("Margarette", "Vaudin", "+33 (596) 756-4732", "mvaudin76@gov.uk")));
//    }
//
//    @Test
//    public void testListBySkills() {
//        generator = new ListBySkills();
//        List<Applicant> applicants = generator.getListFromDatabase(dataSource);
//
//        Assertions.assertEquals(178, applicants.size());
//        Assertions.assertEquals("Ashbridge", applicants.get(10).getLastName());
//        Assertions.assertEquals("Yuri", applicants.get(15).getFirstName());
//        Assertions.assertEquals("EKG", applicants.get(174).getSkill());
//        Assertions.assertNull(applicants.get(34).getPhoneNumber());
//        Assertions.assertNull(applicants.get(122).getEmail());
//        Assertions.assertTrue(applicants.contains(new Applicant("Zackariah", "Strewther", "DLX")));
//    }

}