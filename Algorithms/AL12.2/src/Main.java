public class Main {
    public static void main(String[] args){
        Wezel[] Z = new Wezel[10];
        for(int i=0; i<10; i++)
            Z[i] = Wezel.MakeSet(i);

        Wezel.Union(Wezel.FindSet(Z[0]),Wezel.FindSet(Z[1]));
        Wezel.Union(Wezel.FindSet(Z[2]),Wezel.FindSet(Z[3]));
        Wezel.Union(Wezel.FindSet(Z[1]),Wezel.FindSet(Z[2]));
        Wezel.Union(Wezel.FindSet(Z[5]),Wezel.FindSet(Z[6]));
        Wezel.Union(Wezel.FindSet(Z[7]),Wezel.FindSet(Z[8]));
        Wezel.Union(Wezel.FindSet(Z[3]),Wezel.FindSet(Z[5]));
        Wezel.Union(Wezel.FindSet(Z[0]),Wezel.FindSet(Z[7]));

        for(int i=0; i<10; i++)
            Wezel.pokaz(Z[i]);
    }
}
