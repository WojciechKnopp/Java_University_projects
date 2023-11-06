public class Newton {
    double epsilon;
    double x0;
    int k;

    Newton(double epsilon, double x0){
        this.epsilon=epsilon;
        this.x0=x0;
    }

    private double fx(double x){
        double wynik;
        wynik = Math.exp(-x);
        wynik+= 3*x-4;
        if(wynik == Double.POSITIVE_INFINITY)
            throw(new ArithmeticException("Program nie może wyliczyć wyniku funkcji w punkcie x = " +x+ ".\n Prawdopodobnie ten punkt jest mniejszy niż -709, co powoduje, że wynik e^(-x) wychodzi poza zakres zmiennej."));
        return wynik;
    }

    private double f1x(double x){
        if(x == -Math.log(3))
            throw(new ArithmeticException("Styczna w punkcie x = "+x+" jest stała, więc metoda Newtona nie zwróci wyniku."));
        double wynik;
        wynik = -Math.exp(-x);
        wynik += 3;
        return wynik;
    }

    public double policz(){
        k = 0;
        double x = x0;
        boolean czy_policzone = false;

        while(!czy_policzone){
            try{
                x = x - (fx(x) / f1x(x));
                if (Math.abs(fx(x)) < epsilon)
                    czy_policzone = true;
                k++;
            }catch(ArithmeticException e){
                throw(new ArithmeticException(e.getMessage()));
            }
        }
        return x;
    }
}
