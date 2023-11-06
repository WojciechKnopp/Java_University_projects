import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        System.out.println(Wezel.T);
        try {
            File drzewo = new File("drzewo");

        }catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
}
