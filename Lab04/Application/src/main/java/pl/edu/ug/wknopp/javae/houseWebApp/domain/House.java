package pl.edu.ug.wknopp.javae.houseWebApp.domain;

public class House {
    private String id;
    private Integer numberOfFloors;
    private Integer area;
    private String address;
    private Double price;
    private Integer yearOfConstruction;
    private String description;

    public House(){
        System.out.println("House object created");
    }

    public House(String id, Integer numberOfFloors, Integer area, String address, Double price, Integer yearOfConstruction, String description){
        this.id = id;
        this.numberOfFloors = numberOfFloors;
        this.area = area;
        this.address = address;
        this.price = price;
        this.yearOfConstruction = yearOfConstruction;
        this.description = description;
        System.out.println("House object created");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
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
}
