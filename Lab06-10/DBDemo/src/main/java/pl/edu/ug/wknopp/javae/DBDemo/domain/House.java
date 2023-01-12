package pl.edu.ug.wknopp.javae.DBDemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class House {

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
    }

    public House(Integer numberOfFloors, Integer area, Double price, Integer yearOfConstruction) {
        this.numberOfFloors = numberOfFloors;
        this.area = area;
        this.price = price;
        this.yearOfConstruction = yearOfConstruction;
    }
    public House(Integer numberOfFloors, Integer area, Double price, Integer yearOfConstruction, String description) {
        this.numberOfFloors = numberOfFloors;
        this.area = area;
        this.price = price;
        this.yearOfConstruction = yearOfConstruction;
        this.description = description;
    }

    public House(Integer numberOfFloors, Integer area, Double price, Integer yearOfConstruction, ConstructionCompany constructionCompany, List<Person> owners, String description) {
        this.numberOfFloors = numberOfFloors;
        this.area = area;
        this.price = price;
        this.yearOfConstruction = yearOfConstruction;
        this.description = description;
        this.constructionCompany = constructionCompany;
        this.owners = owners;
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

    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    public ConstructionCompany getConstructionCompany() {
        return constructionCompany;
    }

    public void setConstructionCompany(ConstructionCompany constructionCompany) {
        this.constructionCompany = constructionCompany;
    }

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    public List<Person> getOwners() {
        return owners;
    }

    public void setOwners(List<Person> owners) {
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", numberOfFloors=" + numberOfFloors +
                ", area=" + area +
                ", address=" + address +
                ", price=" + price +
                ", yearOfConstruction=" + yearOfConstruction +
                ", description='" + description + '\'' +
                ", constructionCompany=" + constructionCompany +
                ", owners=" + owners +
                '}';
    }
}
