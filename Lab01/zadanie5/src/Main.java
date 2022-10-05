public class Main {
    public static void main(String[] args) {
        Author A1 = new Author("Jan", "Jan@gmail.com", Gender.MALE);
        System.out.println(A1.getName());
        System.out.println(A1.getEmail());
        System.out.println(A1.getGender());
        A1.setEmail("Jan2@gmail.com");
        System.out.println(A1);

        Book B1 = new Book("100 wysp", 12.37, A1, 5);
        System.out.println(B1.getName());
        System.out.println(B1.getAuthor());
        System.out.println(B1.getPrice());
        System.out.println(B1.getQty());
        B1.setQty(20);
        System.out.println(B1);
    }
}
