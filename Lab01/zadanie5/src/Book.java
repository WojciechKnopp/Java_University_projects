public class Book {
    String name;
    Author author;
    double price;
    int qty = 0;

    Book(String name, double price, Author author){
        this.name = name;
        this.price = price;
        this.author = author;
    }

    Book(String name, double price, Author author, int qty){
        this.name = name;
        this.price = price;
        this.author = author;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Book[" + "name='" + name + ", author=" + author + ", price=" + price + ", qty=" + qty + "]";
    }
}
