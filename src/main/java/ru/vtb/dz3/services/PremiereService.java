package ru.vtb.dz3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vtb.dz3.model.Premiere;
import ru.vtb.dz3.repository.PremiereRepository;

import java.util.List;


@Service
public class PremiereService {

    private final PremiereRepository premiereRepository;

    @Autowired
    public PremiereService(PremiereRepository premiereRepository) {
        this.premiereRepository = premiereRepository;
    }

    public void addPremiere(Premiere premiere) {
        premiereRepository.save(premiere);
    }

    public void deletePremiere(String premiereName) {
        premiereRepository.delete(premiereName);
    }


    public void changePremiere(String premiereName, String newDescription,
                               Integer newAgeCategory, Integer newNumberOfSeats) {
        List<Premiere> list = premiereRepository.findByName(premiereName);
        if (!list.isEmpty()) {
            Premiere premiere = list.get(0);
            premiere.setDescription(newDescription);
            premiere.setAgeCategory(newAgeCategory);
            premiere.setNumberOfSeats(newNumberOfSeats);
            premiereRepository.update(premiere);
        }
    }

    public boolean buyTickets(String premiereName, Integer numTikets) {
        List<Premiere> list = premiereRepository.findByName(premiereName);
        if (!list.isEmpty()) {
            Premiere premiere = list.get(0);
            if (premiere.getName().equalsIgnoreCase(premiereName) && premiere.getNumberOfSeats() - numTikets >= 0) {
                premiere.setNumberOfSeats(premiere.getNumberOfSeats() - numTikets);
                premiereRepository.update(premiere);
                return true;
            }
        }
        return false;
    }

    public void returnTickets(String premiereName, Integer numTikets) {
        List<Premiere> list = premiereRepository.findByName(premiereName);
        if (!list.isEmpty()) {
            Premiere premiere = list.get(0);
            premiere.setNumberOfSeats(premiere.getNumberOfSeats() + numTikets);
            premiereRepository.update(premiere);
        }
    }

    public List<Premiere> getPremieres() {
        return premiereRepository.findAll();
    }


    public String getPremeiresInfo(String premiereName) {
        String ret = null;
        if (premiereName != null) {
            List<Premiere> list = premiereRepository.findByName(premiereName);
            if (!list.isEmpty()) {
                ret = list.get(0).toString();
            }
        } else {
            List<Premiere> list = premiereRepository.findAll();
            StringBuilder sb = new StringBuilder();
            for (Premiere p : list) {
                sb.append(p.toString()).append("\n");
            }
            ret = sb.toString();
        }
        return ret;
    }
}
