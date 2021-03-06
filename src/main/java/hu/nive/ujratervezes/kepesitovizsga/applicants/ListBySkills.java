package hu.nive.ujratervezes.kepesitovizsga.applicants;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListBySkills implements ApplicantListGenerator {

    @Override
    public List<Applicant> getListFromDatabase(DataSource dataSource) {
        List<Applicant> result = new ArrayList<>();
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT first_name, last_name, skill FROM applicants WHERE skill LIKE '___';")
        ) {
            loadResultList(result, ps);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed", sqlException);
        }
        return result;
    }

    private void loadResultList(List<Applicant> result, PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String skill = rs.getString("skill");
                result.add(new Applicant(firstName, lastName, skill));
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot query", sqlException);
        }
    }
}
