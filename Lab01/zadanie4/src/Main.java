import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        do{
            System.out.print("Podaj liczbę naturalną: ");
            n = input.nextInt();
            if(n < 1) System.out.println("To nie jest liczba naturalna!");
        }while(n < 1);

        System.out.println(Pattern.draw(n));
    }
}
