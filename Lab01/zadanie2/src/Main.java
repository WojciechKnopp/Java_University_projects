import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {

        //int n = 1;     //LICZBA ARMSTRONGA
        //int n = 10;
        //int n = 123;
        int n = 153;   //LICZBA ARMSTRONGA
        double dlugosc = 0;
        int wynik = 0;
        ArrayList<Integer> cyfry = new ArrayList<>();

        for(int i=n; i>0; dlugosc++, i/=10){
            cyfry.add(i%10);
        }

        for(int i=cyfry.size(); i>0; i--){
            wynik+= Math.pow(cyfry.get(i-1), dlugosc);
        }

        if(wynik==n) System.out.println(true);
        else System.out.println(false);
    }
}