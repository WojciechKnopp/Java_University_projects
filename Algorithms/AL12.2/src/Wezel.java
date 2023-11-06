public class Wezel {
    int klucz;
    Wezel ojciec;
    int ranga;

    public static Wezel MakeSet(int k){
        Wezel x = new Wezel();
        x.klucz = k;
        x.ojciec = x;
        x.ranga = 0;
        return x;
    }

    public static Wezel FindSet(Wezel x){
        if(x != x.ojciec)
            x.ojciec = FindSet(x.ojciec);
        return x.ojciec;
    }

    public static void Union(Wezel x, Wezel y){
        if(x.ranga < y.ranga)
            x.ojciec = y;
        else{
            y.ojciec = x;
            if(x.ranga == y.ranga)
                x.ranga++;
        }
    }

    public static void pokaz(Wezel x){
        if(x != x.ojciec){
            System.out.print(x.klucz+" -> ");
            pokaz(x.ojciec);
        }
        else
            System.out.println(x.klucz+" ("+x.ranga+")");
    }
}
