package pl.edu.ug.wknopp.javae.lab03.zadanieAPI.domain;

public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String companyName;
    private String position;

    public Person(){
        System.out.println("Person object created");
    }

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Person(String firstName, String lastName, String email, String companyName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.companyName = companyName;
    }
    public Person(String firstName, String lastName, String email, String companyName, String position){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.companyName = companyName;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
