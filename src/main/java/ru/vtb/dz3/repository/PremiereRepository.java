package ru.vtb.dz3.repository;

import ru.vtb.dz3.model.Premiere;

import java.util.List;

public interface PremiereRepository {
    int save(Premiere premiere);
    int delete(String name);
    int update(Premiere premiere);
    List<Premiere> findAll();
    List<Premiere> findByName(String name);


}
