import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ulamek[][] liczby = {
                {new Ulamek(2),new Ulamek(-1),new Ulamek(-3)},
                {new Ulamek(6),new Ulamek(-2),new Ulamek(-7)},
                {new Ulamek(-4),new Ulamek(3),new Ulamek(7)},
        };

        int choice = 0;
        int odstep = 6;
        while(choice == 0){
            System.out.println("Wybierz macierz którą chcerz przedstawić w postaci LU.");
            System.out.println("1. Macierz z własnych liczb (do ustawienia w kodzie programu).");
            System.out.println("2. Macierz Hilberta [N x N].");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            if(choice == 2){
                System.out.print("Podaj wymiar [N] macierzy: ");
                int n = input.nextInt();
                Ulamek alpha = new Ulamek(1,4);
                if(n >= 3){
                    System.out.print("Podaj wartość którą chcesz wstawić w miejsce wszystkich 1/4 (ułamki podawaj w postaci a/b): ");
                    String s1 = input.next();
                    String[] s1_pd = s1.split("/");
                    if(s1_pd.length==2)
                        alpha = new Ulamek(Integer.parseInt(s1_pd[0]), Integer.parseInt(s1_pd[1]));
                    else
                        alpha = new Ulamek(Integer.parseInt(s1_pd[0]));
                }
                odstep += n+1;
                liczby = new Ulamek[n][n];
                for(int i = 1; i <= n; i++){
                    for(int j = i; j < i + n; j++){
                        if(j == 4)
                            liczby[i-1][j-i] = new Ulamek(alpha.licznik, alpha.mianownik);
                        else
                            liczby[i-1][j-i] = new Ulamek(1,j);
                    }
                }
            }else if(choice != 1){
                System.out.println("Nie ma takiej opcji.");
                choice = 0;
            }
        }

        Macierz M1 = new Macierz(liczby);

        System.out.println("Macierz A:");
        M1.pokaz(M1.a, odstep);
        try{

            M1.LU();
            System.out.println("\nMacierz L: ");
            M1.pokaz(M1.L, odstep);
            System.out.println("\nMacierz U:");
            M1.pokaz(M1.U, odstep);

        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
}
