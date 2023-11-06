import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        IlorazRoznicowy[] poczatkowe = new IlorazRoznicowy[6];
        poczatkowe[0] = new IlorazRoznicowy(0, 0, new Ulamek(1));
        poczatkowe[1] = new IlorazRoznicowy(1, 1, new Ulamek(2));
        poczatkowe[2] = new IlorazRoznicowy(2, 2, new Ulamek(4));
        poczatkowe[3] = new IlorazRoznicowy(3, 3, new Ulamek(8));
        poczatkowe[4] = new IlorazRoznicowy(-1, -1, new Ulamek(0));
        poczatkowe[5] = new IlorazRoznicowy(-1, -1, new Ulamek(0));
        Scanner sc = new Scanner(System.in);

        // POBIERANIE WARTOSCI //
        System.out.println("Podaj 2 kolejne wyrazy ciągu: 1, 2, 4, 8.");
        System.out.println("Możliwe liczby do wprowadzenia to liczby całkowite, ułamki zwykłe i niewłaściwe. Ułamki podawaj w postaci \"a/b\".");
        System.out.println("Wprowadzane liczby oddziel za pomocą spacji.");
        boolean czy_poprawne=false;
        String s1="", s2="";
        while(!czy_poprawne){
            czy_poprawne = true;
            s1 = sc.next();
            s2 = sc.next();
            if(!(s1.matches("-?[1-9][0-9]*/[1-9][0-9]*") || s1.matches("-?0/[1-9][0-9]*") || s1.matches("-?[1-9][0-9]*") || s1.matches("0"))) {
                System.out.println("Pierwsza liczba jest podana w złej postaci.");
                czy_poprawne = false;
            }
            if(!(s2.matches("-?[1-9][0-9]*/[1-9][0-9]*") || s2.matches("-?0/[1-9][0-9]*") || s2.matches("-?[1-9][0-9]*") || s2.matches("0"))){
                System.out.println("Druga liczba jest podana w złej postaci.");
                czy_poprawne = false;
            }
            if(!czy_poprawne)
                System.out.println("Podaj obie liczby jeszcze raz.");
        }
        String[] podzielone1 = s1.split("/");
        String[] podzielone2 = s2.split("/");

        // PRZYPISANIE WARTOSCI //
        poczatkowe[4].x_pocz = 4;
        poczatkowe[4].x_kon = 4;
        if(podzielone1.length==2)
            poczatkowe[4].wartosc = new Ulamek(Integer.parseInt(podzielone1[0]), Integer.parseInt(podzielone1[1]));
        else
            poczatkowe[4].wartosc = new Ulamek(Integer.parseInt(podzielone1[0]));

        poczatkowe[5].x_pocz = 5;
        poczatkowe[5].x_kon = 5;
        if(podzielone2.length==2)
            poczatkowe[5].wartosc = new Ulamek(Integer.parseInt(podzielone2[0]), Integer.parseInt(podzielone2[1]));
        else
            poczatkowe[5].wartosc = new Ulamek(Integer.parseInt(podzielone2[0]));

        // WYLICZENIE WSPOLCZYNNIKOW //
        IlorazRoznicowy[][] ilorazy = new IlorazRoznicowy[6][6];
        for(int i=0; i<6; i++)
            for(int j=0; j<6; j++)
                ilorazy[i][j] = new IlorazRoznicowy(0,0,new Ulamek(0));
        for(int i=0; i<6; i++){
            ilorazy[0][i] = poczatkowe[i];
        }
        for(int i=1; i<6;i++){
            for(int j=i; j<6; j++){
                ilorazy[i][j] = ilorazy[i-1][j].policz_kolejny (ilorazy[i-1][j-1]);
            }
        }

        Wielomian[] wspolczynniki = new Wielomian[6];
        for(int i=0; i<6; i++){
            ArrayList<Ulamek> tmp = new ArrayList<>();
            tmp.add(ilorazy[i][i].wartosc);
            wspolczynniki[i] = new Wielomian(tmp);
        }

        // POLICZENIE KONCOWEGO WIELOMIANU //
        Wielomian[] podstawowe = new Wielomian[5];
        for(int i=0; i<5; i++){
            ArrayList<Ulamek> tmp = new ArrayList<>();
            tmp.add(new Ulamek(-i));
            tmp.add(new Ulamek(1));
            podstawowe[i] = new Wielomian(tmp);
        }

        Wielomian[] czesciowe = new Wielomian[6];
        czesciowe[0] = wspolczynniki[0];
        czesciowe[1] = wspolczynniki[1].pomnoz(podstawowe[0]);
        czesciowe[2] = wspolczynniki[2].pomnoz(podstawowe[0]).pomnoz(podstawowe[1]);
        czesciowe[3] = wspolczynniki[3].pomnoz(podstawowe[0]).pomnoz(podstawowe[1]).pomnoz(podstawowe[2]);
        czesciowe[4] = wspolczynniki[4].pomnoz(podstawowe[0]).pomnoz(podstawowe[1]).pomnoz(podstawowe[2]).pomnoz(podstawowe[3]);
        czesciowe[5] = wspolczynniki[5].pomnoz(podstawowe[0]).pomnoz(podstawowe[1]).pomnoz(podstawowe[2]).pomnoz(podstawowe[3]).pomnoz(podstawowe[4]);
        Wielomian Px;
        Px = czesciowe[0].dodaj(czesciowe[1]). dodaj(czesciowe[2]). dodaj(czesciowe[3]). dodaj(czesciowe[4]). dodaj(czesciowe[5]);

        System.out.println("Gratulacje!\nPoprawnie odgadłeś 2 kolejne wyrazy ciągu.");
        System.out.println("Wielomian, z którego pochodzą dane:");
        System.out.println("P(x) = "+Px.wyswietl()+".");
    }
}
