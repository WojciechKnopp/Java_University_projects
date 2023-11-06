import java.util.ArrayList;

public class Wielomian {
    ArrayList<Ulamek> wsp;

    Wielomian(ArrayList<Ulamek> wspolczynniki){
        this.wsp=wspolczynniki;
    }

    public String wyswietl(){
        String wynik = "";
        for(int i=wsp.size()-1; i>0; i--){
            if(wsp.get(i).licznik!=0){
                if(wsp.get(i).licznik >= 0)
                    wynik+=(wsp.get(i).wyswietl() + "x");
                else
                    wynik+=("(" + wsp.get(i).wyswietl() + ")x");
                if(i>1)
                    wynik+=("^" + i + " + ");
                else
                    wynik+=(" + ");
            }
        }
        wynik+=wsp.get(0).wyswietl();
        return wynik;
    }

    public Wielomian dodaj(Wielomian w2){
        Wielomian wynik = new Wielomian(new ArrayList<>());
        for(int i = 0; i<wsp.size() || i<w2.wsp.size(); i++){
            if(i>= wsp.size()){
                wynik.wsp.add(w2.wsp.get(i));
            }
            else if(i>=w2.wsp.size()){
                wynik.wsp.add(wsp.get(i));
            }else{
                wynik.wsp.add(wsp.get(i).dodaj(w2.wsp.get(i)));
            }
        }
        return wynik;
    }

    public Wielomian pomnoz(Wielomian w2){
        ArrayList<Ulamek> wynik = new ArrayList<>();
        for(int i=0; i<wsp.size()+w2.wsp.size()-1; i++){ //po kolei potęgi wynikowego wielomianu
            Ulamek tmp = new Ulamek(0);
            for(int x=0, y=i; x<=i && y>=0; x++, y--){ //kombinacje które dają odpowiednią potęgę
                if(x< wsp.size() && y<w2.wsp.size())
                    tmp = tmp.dodaj(wsp.get(x).pomnoz(w2.wsp.get(y)));
            }
            wynik.add(tmp);
        }
        return new Wielomian(wynik);
    }


}
