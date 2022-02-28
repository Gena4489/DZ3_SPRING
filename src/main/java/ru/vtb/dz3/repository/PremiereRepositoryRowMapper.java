package ru.vtb.dz3.repository;

import org.springframework.jdbc.core.RowMapper;
import ru.vtb.dz3.model.Premiere;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PremiereRepositoryRowMapper implements RowMapper<Premiere> {

    @Override
    public Premiere mapRow(ResultSet rs, int i) throws SQLException {
        return new Premiere(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getInt("ageCategory"),
                rs.getInt("numberOfSeats")
        );
    }

}
