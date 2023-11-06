import java.util.Comparator;

public class PriorityComparator implements Comparator<Node>{
    public int compare(Node x, Node y){
        if(x.quantity < y.quantity) return -1;
        else if(x.quantity > y.quantity) return 1;
        return 0;
    }
}
