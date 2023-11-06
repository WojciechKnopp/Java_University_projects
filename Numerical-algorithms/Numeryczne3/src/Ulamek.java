public class Ulamek {
    int licznik;
    int mianownik;

    Ulamek(int licznik){
        this.licznik=licznik;
        this.mianownik=1;
    }

    Ulamek(int licznik, int mianownik){
        if(mianownik<0){ //wrzucenie minusa do licznika
            mianownik*=-1;
            licznik*=-1;
        }
        this.licznik=licznik;
        this.mianownik=mianownik;
    }

    public String wyswietl(){
        if(mianownik==1)
            return String.valueOf(licznik);
        else
            return licznik+"/"+mianownik;
    }

    private int NWD(int l1, int l2){
        while(l1!=l2){
            if(l1>l2)
                l1-=l2;
            else
                l2-=l1;
        }
        return l1;
    }

    private int NWW(int l1, int l2){
        return l1/NWD(l1,l2)*l2;
    }

    private void skroc(){
        if(licznik==0){
            mianownik=1;
            return;
        }
        int dzielnik=NWD(Math.abs(licznik),mianownik);
        if(dzielnik!=1){
            licznik/=dzielnik;
            mianownik/=dzielnik;
        }
    }

    public Ulamek dodaj(Ulamek U2){
        Ulamek wynik = new Ulamek(0);
        if(mianownik!=U2.mianownik){
            int wielokrotnosc = NWW(mianownik, U2.mianownik);
            wynik.licznik = licznik*(wielokrotnosc/mianownik) + U2.licznik*(wielokrotnosc/U2.mianownik);
            wynik.mianownik = mianownik*(wielokrotnosc/mianownik);
        }else{
            wynik.licznik = licznik + U2.licznik;
            wynik.mianownik = mianownik;
        }
        wynik.skroc();
        return wynik;
    }

    public Ulamek odejmij(Ulamek U2){
        Ulamek wynik = new Ulamek(0);
        if(mianownik!=U2.mianownik){
            int wielokrotnosc = NWW(mianownik, U2.mianownik);
            wynik.licznik = licznik*(wielokrotnosc/mianownik) - U2.licznik*(wielokrotnosc/U2.mianownik);
            wynik.mianownik = mianownik*(wielokrotnosc/mianownik);
        }else{
            wynik.licznik = licznik - U2.licznik;
            wynik.mianownik = mianownik;
        }
        wynik.skroc();
        return wynik;
    }

    public Ulamek pomnoz(Ulamek U2){
        Ulamek wynik = new Ulamek(1);
        wynik.licznik = licznik*U2.licznik;
        wynik.mianownik = mianownik*U2.mianownik;
        wynik.skroc();
        return wynik;
    }

    public Ulamek podziel(Ulamek U2){
        if(U2.licznik==0){
            throw new ArithmeticException("Próbowano podzielić przez 0!");
        }
        Ulamek tmp = new Ulamek(U2.licznik, U2.mianownik);
        tmp.mianownik+=tmp.licznik; //swap
        tmp.licznik=tmp.mianownik-tmp.licznik;
        tmp.mianownik-=tmp.licznik;
        if(tmp.mianownik<0){ //wrzucenie minusa do licznika
            tmp.mianownik*=-1;
            tmp.licznik*=-1;
        }
        return pomnoz(tmp);
    }
}