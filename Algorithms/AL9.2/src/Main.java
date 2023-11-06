import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Podaj pierwszy ciąg: ");
        Scanner input = new Scanner(System.in);
        String x = input.next();
        System.out.print("Podaj drugi ciąg: ");
        input = new Scanner(System.in);
        String y = input.next();

        NWP n1 = new NWP(x,y);
        n1.policz_dlugosc();
        System.out.print("Najdłuższy wspólny podciąg to: ");
        n1.wyswietl(n1.x,n1.b,n1.m,n1.n);

        NWP_wszystkie n2 = new NWP_wszystkie(x,y);
        n2.policz_dlugosc();
        System.out.println("\n\nWszystkie najdłuższe ciągi:");
        n2.wyswietl();


    }
}
