import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        do{
            System.out.print("Podaj liczbę naturalną: ");
            try{
                n = input.nextInt();
            }catch(InputMismatchException e){
                String trash = input.next(); //Naprawia zepsuty input po exception
                n = -1;
            }
            if(n < 1) System.out.println("To nie jest liczba naturalna!");
        }while(n < 1);

        System.out.println(Pattern.draw(n));
    }
}
