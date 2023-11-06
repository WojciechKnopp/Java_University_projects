import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graf {

    public static void DFS(ArrayList<Integer>[] Adj, Wierzcholek[] V, Wierzcholek u){
        System.out.println("V: "+u.nr);
        u.visited = true;
        for(int i=0; i<Adj[u.nr].size(); i++){
            Wierzcholek v = V[Adj[u.nr].get(i)];
            if(!V[Adj[u.nr].get(i)].visited){
                System.out.println("Krawędź: " + u.nr + " " + v.nr);
                DFS(Adj, V, v);
            }
        }
    }
    public static void BFS(ArrayList<Integer>[] Adj, Wierzcholek[] V, Wierzcholek s){
        s.visited = true;
        Queue<Wierzcholek> Q = new LinkedList<>();
        Q.add(s);
        while(Q.size() != 0){
            Wierzcholek u = Q.remove();
            System.out.println("V: "+u.nr);
            for(int i=0; i<Adj[u.nr].size(); i++){
                Wierzcholek v = V[Adj[u.nr].get(i)];
                if(!v.visited){
                    v.visited = true;
                    System.out.println("Krawędź: " + u.nr + " " + v.nr);
                    Q.add(v);
                }
            }
        }
    }
}
