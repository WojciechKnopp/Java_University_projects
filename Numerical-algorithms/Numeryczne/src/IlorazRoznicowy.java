public class IlorazRoznicowy {
    int x_pocz, x_kon;
    Ulamek wartosc;
    IlorazRoznicowy(int x_pocz, int x_kon, Ulamek wartosc){
        this.x_pocz=x_pocz;
        this.x_kon=x_kon;
        this.wartosc=wartosc;
    }

    public IlorazRoznicowy policz_kolejny(IlorazRoznicowy i0){
        Ulamek wynik = (wartosc.odejmij(i0.wartosc)).podziel(new Ulamek(x_kon - i0.x_pocz));
        return new IlorazRoznicowy(i0.x_pocz, x_kon, wynik);
    }
}
