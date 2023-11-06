import java.util.ArrayList;

public class Kruskal{
    int ilW;
    int ilK;
    ArrayList<Krawedz> E;
    ArrayList<Wezel> V;

    Kruskal(ArrayList<Krawedz> E, int ilW){
        this.E = E;
        this.ilW = ilW;
        ilK = E.size();
        V = new ArrayList<>();
    }

    public void wyznacz(){
        for(int i=0; i<ilW; i++){
            V.add(Wezel.MakeSet(i));
        }
        E.sort(new EComparator());
        for(int i=0; i<ilK; i++){
            Wezel ru = Wezel.FindSet(V.get(E.get(i).u));
            Wezel rv = Wezel.FindSet(V.get(E.get(i).v));
            if(ru != rv){
                E.get(i).wypisz();
                Wezel.Union(ru, rv);
            }
        }
    }

}
