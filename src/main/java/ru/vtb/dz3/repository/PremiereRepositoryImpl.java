package ru.vtb.dz3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.vtb.dz3.model.Premiere;

import java.util.List;
import java.util.Locale;

@Repository
public class PremiereRepositoryImpl implements PremiereRepository{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PremiereRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int save(Premiere premiere) {
        String sqlInsert = "insert into premieres (id, name, description, ageCategory, numberOfSeats) " +
                "values( ?, ?, ?, ?, ?);";
        return jdbcTemplate.update(sqlInsert,
                premiere.getId(),
                premiere.getName(),
                premiere.getDescription(),
                premiere.getAgeCategory(),
                premiere.getNumberOfSeats()
        );
    }


    @Override
    public int delete(String name) {
        String sqlDelete = "delete from  premieres where upper(name)= ?";
        return jdbcTemplate.update(sqlDelete,name.toUpperCase(Locale.ROOT));
    }

    @Override
    public int update(Premiere premiere) {
        String sqlUpdate = "update  premieres set name = ?, description = ?, ageCategory = ?, numberOfSeats = ? where id= ?";
        return jdbcTemplate.update(sqlUpdate,
                premiere.getName(),
                premiere.getDescription(),
                premiere.getAgeCategory(),
                premiere.getNumberOfSeats(),
                premiere.getId()
        );
    }

    @Override
    public List<Premiere> findAll() {
        String sqlAll = "select * from premieres";
        return jdbcTemplate.query(sqlAll, new PremiereRepositoryRowMapper());
    }

    @Override
    public List<Premiere> findByName(String name) {
        String sqlByName = "select * from premieres where upper(name) = ?";
        return jdbcTemplate.query(sqlByName, new PremiereRepositoryRowMapper(), name.toUpperCase(Locale.ROOT));
    }
}
