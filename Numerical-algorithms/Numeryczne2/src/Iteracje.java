public class Iteracje{
    double epsilon;
    double x0;
    double msc_zerowe;
    int k;

    Iteracje(double epsilon, double x0, double msc_zerowe){
        this.epsilon=epsilon;
        this.x0=x0;
        this.msc_zerowe=msc_zerowe;
    }

    private double fx(double x){
        double wynik;
        if(msc_zerowe >= 0)
            wynik = (4-Math.exp(-x))/3;
        else
            wynik = -Math.log(4-3*x);
        return wynik;
    }

    public double policz(){
        k = 0;
        double x = x0;
        boolean czy_policzone = false;

        while(!czy_policzone){
            x = fx(x);
            if(Math.abs(fx(x)-x)<epsilon)
                czy_policzone = true;
            k++;
        }
        return x;
    }
}
