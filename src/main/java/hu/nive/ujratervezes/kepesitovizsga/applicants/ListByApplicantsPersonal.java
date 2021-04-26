package hu.nive.ujratervezes.kepesitovizsga.applicants;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListByApplicantsPersonal implements ApplicantListGenerator {

    @Override
    public List<Applicant> getListFromDatabase(DataSource dataSource) {

        List<Applicant> result = new ArrayList<>();

        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT first_name, last_name, phone_number, email FROM applicants;")
        ) {

            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                result.add(new Applicant(firstName, lastName, phoneNumber, email));
            }

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed", sqlException);
        }
        return result;
    }
}
