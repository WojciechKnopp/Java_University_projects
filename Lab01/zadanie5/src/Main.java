public class Main {
    public static void main(String[] args) {
        Author exAuthor = new Author("Jan", "Jan@gmail.com", Gender.MALE);
        System.out.println(exAuthor.getName());
        System.out.println(exAuthor.getEmail());
        System.out.println(exAuthor.getGender());
        exAuthor.setEmail("Jan2@gmail.com");
        System.out.println(exAuthor);

        Book exBook = new Book("100 wysp", 12.37, exAuthor, 5);
        System.out.println(exBook.getName());
        System.out.println(exBook.getAuthor());
        System.out.println(exBook.getPrice());
        System.out.println(exBook.getQty());
        exBook.setQty(20);
        System.out.println(exBook);
    }
}
