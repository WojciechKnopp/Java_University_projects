package pl.edu.ug.wknopp.javae.DBDemo.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class House {

    @Id
    private long id;
    private Integer numberOfFloors;
    private Integer area;
    private Address address;
    private Double price;
    private Integer yearOfConstruction;
    private String description;
    private ConstructionCompany constructionCompany;
    private List<Person> owners;

    public House(){
        System.out.println("House object created");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    @OneToOne
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getYearOfConstruction() {
        return yearOfConstruction;
    }

    public void setYearOfConstruction(Integer yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne
    public ConstructionCompany getConstructionCompany() {
        return constructionCompany;
    }

    public void setConstructionCompany(ConstructionCompany constructionCompany) {
        this.constructionCompany = constructionCompany;
    }

    @ManyToMany
    public List<Person> getOwners() {
        return owners;
    }

    public void setOwners(List<Person> owners) {
        this.owners = owners;
    }
}
