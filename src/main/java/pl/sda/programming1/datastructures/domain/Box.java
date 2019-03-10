package pl.sda.programming1.datastructures.domain;

public class Box {

    private String name;
    private Long id;
    private String model;

    public String getName() {
        return name;
    }

    public Box setName(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Box setId(Long id) {
        this.id = id;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Box setModel(String model) {
        this.model = model;
        return this;
    }
}
