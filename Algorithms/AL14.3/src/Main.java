import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("niespojny.txt");
        try{
            Scanner input = new Scanner(file);
            int size = input.nextInt();
            String line = "";
            ArrayList<Integer>[] Adj = new ArrayList[size];
            line = input.nextLine();
            for(int j=0; input.hasNextLine(); j++){
                Adj[j] = new ArrayList<Integer>();
                line = input.nextLine();
                for(int i=0; i<size; i++)
                    if(line.charAt(i) == '1')
                        Adj[j].add(i);
            }

            Wierzcholek[] V = new Wierzcholek[size];
            for(int i=0; i<size; i++)
                V[i] = new Wierzcholek(i);

            System.out.println();
            System.out.println("PRZESZUKIWANIE W GŁĄB\nOdwiedzone wierzchołki w kolejności [V] i krawędzie lasu spinającego:");
            for(int i=0; i<size; i++)
                if(!V[i].visited)
                    Graf.DFS(Adj, V, V[i]);

            for(int i=0; i<size; i++)
                V[i].visited = false;
            System.out.println();

            System.out.println("PRZESZUKIWANIE WSZERZ\nOdwiedzone wierzchołki w kolejności [V] i krawędzie lasu spinającego:");
            for(int i=0; i<size; i++)
                if(!V[i].visited)
                    Graf.BFS(Adj, V, V[i]);

        }catch(FileNotFoundException e){
            System.out.print(e.getMessage());
        }
    }
}
