import java.util.Comparator;

public class EComparator implements Comparator<Krawedz>{
    public int compare(Krawedz k1, Krawedz k2){
        if(k1.waga < k2.waga) return -1;
        else if(k1.waga > k2.waga) return 1;
        return 0;
    }
}
