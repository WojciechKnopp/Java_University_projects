public class Author {
    String name;
    String email;
    Enum<Gender> gender;

    Author(String name, String email, Enum<Gender> gender){
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Enum<Gender> getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Author[" + "name=" + name +  ", email=" + email + ", gender=" + gender + "]";
    }
}
