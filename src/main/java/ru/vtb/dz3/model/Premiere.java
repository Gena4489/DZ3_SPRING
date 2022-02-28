package ru.vtb.dz3.model;

public class Premiere {
    private Long id;
    private String name;
    private String description;
    private Integer ageCategory;
    private Integer numberOfSeats;


    public Premiere(Long id, String name, String description, Integer ageCategory, Integer numberOfSeats) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ageCategory = ageCategory;
        this.numberOfSeats = numberOfSeats;
    }

    public Premiere(String name, String description, Integer ageCategory, Integer numberOfSeats) {
        this.name = name;
        this.description = description;
        this.ageCategory = ageCategory;
        this.numberOfSeats = numberOfSeats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(Integer ageCategory) {
        this.ageCategory = ageCategory;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Премьера{" +
                "Наименование='" + name + '\'' +
                ", Описание='" + description + '\'' +
                ", Возростная категория=" + ageCategory +
                ", Количестиво доступных мест=" + numberOfSeats +
                '}';
    }
}
