import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double epsilon;
        double x0;
        System.out.println("Dla równania e^-x + 3x - 4:");
        Scanner input = new Scanner(System.in);
        System.out.print("\t* Podaj przybliżenie z jakim ma być policzone (maksymalna dokładność to 0,000001): ");
        epsilon = input.nextDouble();
        System.out.print("\t* Podaj punkt początkowy z zakresu [-709; 1000] (maksymalna liczba miejsc po przecinku: 16): x = ");
        x0 = input.nextDouble();
        System.out.println();
        try{
            Newton N1 = new Newton(epsilon, x0);
            double msc_zeroweN = N1.policz();

            Iteracje I1 = new Iteracje(epsilon, x0, msc_zeroweN);
            double msc_zeroweI = I1.policz();

            int i;
            int k = -1;
            for(double test = epsilon; test>0; k++, test*=10){
                i = (int)test;
                test = test - (double)i;
            }
            if(k == 1){
                System.out.printf("Przybliżenie rozwiązania tego równania otrzymane metodą Newtona wynosi: x = %.1f\n", msc_zeroweN);
                System.out.println("Ilość kroków: " + N1.k);
                System.out.println();
                System.out.printf("Przybliżenie rozwiązania tego równania otrzymane metodą iteracji prostych wynosi: x = %.1f\n", msc_zeroweI);
                System.out.println("Ilość kroków: " + I1.k);
            }else if(k == 2){
                System.out.printf("Przybliżenie rozwiązania tego równania otrzymane metodą Newtona wynosi: x = %.2f\n", msc_zeroweN);
                System.out.println("Ilość kroków: " + N1.k);
                System.out.println();
                System.out.printf("Przybliżenie rozwiązania tego równania otrzymane metodą iteracji prostych wynosi: x = %.2f\n", msc_zeroweI);
                System.out.println("Ilość kroków: " + I1.k);
            }
            else if(k == 3){
                System.out.printf("Przybliżenie rozwiązania tego równania otrzymane metodą Newtona wynosi: x = %.3f\n", msc_zeroweN);
                System.out.println("Ilość kroków: " + N1.k);
                System.out.println();
                System.out.printf("Przybliżenie rozwiązania tego równania otrzymane metodą iteracji prostych wynosi: x = %.3f\n", msc_zeroweI);
                System.out.println("Ilość kroków: " + I1.k);
            }
            else if(k == 4){
                System.out.printf("Przybliżenie rozwiązania tego równania otrzymane metodą Newtona wynosi: x = %.4f\n", msc_zeroweN);
                System.out.println("Ilość kroków: " + N1.k);
                System.out.println();
                System.out.printf("Przybliżenie rozwiązania tego równania otrzymane metodą iteracji prostych wynosi: x = %.4f\n", msc_zeroweI);
                System.out.println("Ilość kroków: " + I1.k);
            }
            else if(k == 5){
                System.out.printf("Przybliżenie rozwiązania tego równania otrzymane metodą Newtona wynosi: x = %.5f\n", msc_zeroweN);
                System.out.println("Ilość kroków: " + N1.k);
                System.out.println();
                System.out.printf("Przybliżenie rozwiązania tego równania otrzymane metodą iteracji prostych wynosi: x = %.5f\n", msc_zeroweI);
                System.out.println("Ilość kroków: " + I1.k);
            }
            else if(k == 6){
                System.out.printf("Przybliżenie rozwiązania tego równania otrzymane metodą Newtona wynosi: x = %.6f\n", msc_zeroweN);
                System.out.println("Ilość kroków: " + N1.k);
                System.out.println();
                System.out.printf("Przybliżenie rozwiązania tego równania otrzymane metodą iteracji prostych wynosi: x = %.6f\n", msc_zeroweI);
                System.out.println("Ilość kroków: " + I1.k);
            }
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
}
