public class Macierz {
    Ulamek[][] a, L, U;

    Macierz(Ulamek[][] a){
        this.a=a;
        U = new Ulamek[a.length][a.length];
        L = new Ulamek[a.length][a.length];
        for(int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length; j++){
                U[i][j] = new Ulamek(a[i][j].licznik, a[i][j].mianownik);
                L[i][j] = new Ulamek(0);
            }
    }

    private void zamien_rzad(int row){
        boolean czy_zamieniono = false;
        for(int i = row + 1; i < U.length && !czy_zamieniono; i++){
            //Znalezienie rzędu bez 0.
            if(U[i][row].licznik != 0){
                //Zamiana rzędów miejscami.
                for(int j = 0; j < U.length; j++){
                    //swap
                    U[row][j] = U[row][j].dodaj(U[i][j]);
                    U[i][j] = U[row][j].odejmij(U[i][j]);
                    U[row][j] = U[row][j].odejmij(U[i][j]);

                    L[row][j] = L[row][j].dodaj(L[i][j]);
                    L[i][j] = L[row][j].odejmij(L[i][j]);
                    L[row][j] = L[row][j].odejmij(L[i][j]);
                }
                czy_zamieniono = true;
            }
        }
        if(!czy_zamieniono)
            throw(new ArithmeticException("Nie da się zamienić wierszy w trakcie wyznaczania macierzy U."));
    }

    public void LU(){
        for(int k = 0; k < U.length - 1; k++){
            if(U[k][k].licznik == 0)
                try{
                    zamien_rzad(k);
                }catch(SecurityException e){
                    throw(new ArithmeticException(e.getMessage()));
                }

            L[k][k] = new Ulamek(1);
            for(int i = k + 1; i < L.length; i++)
                L[i][k] = U[i][k].podziel(U[k][k]);

            for(int i = U.length - 1; i > k; i--){
                for(int j = U.length - 1; j >= k; j--){
                    U[i][j] = U[i][j].odejmij(U[k][j].pomnoz(U[i][k].podziel(U[k][k])));
                }
            }
        }
        L[L.length-1][L.length-1] = new Ulamek(1);
    }

    public void pokaz(Ulamek[][] x, int odstep){
        String format = "%-"+odstep+"s ";
        for(int i = 0; i < x.length; i++){
            System.out.print("| ");
            for(int j = 0; j < x.length; j++)
                if(x[i][j].licznik < 0)
                    System.out.format(format, x[i][j].wyswietl());
                else
                    System.out.format(format, " "+x[i][j].wyswietl());
            System.out.println("|");
        }
        System.out.println();
    }


}
