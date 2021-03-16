package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {
    private final DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        List<String> result = new ArrayList<>();
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement("select name from dog_types where country = ?")
        ) {
            ps.setString(1, country.toUpperCase());


            dataProcessing(result, ps);
        } catch (SQLException sql) {
            throw new IllegalStateException("Cannot select name based on country", sql);
        }

        return result;
    }

    private void dataProcessing(List<String> result, PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.add(rs.getString("name").toLowerCase());
            }
        } catch (SQLException sql) {
            throw new IllegalArgumentException("No data", sql);
        }
    }
}
