import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Krawedz> E = new ArrayList<>();
        E.add(new Krawedz(0,1,4));
        E.add(new Krawedz(0,3,2));
        E.add(new Krawedz(0,5,1));
        E.add(new Krawedz(1,2,1));
        E.add(new Krawedz(1,3,2));
        E.add(new Krawedz(2,3,2));
        E.add(new Krawedz(2,4,1));
        E.add(new Krawedz(3,5,3));
        E.add(new Krawedz(4,5,5));
        Kruskal K1 = new Kruskal(E, E.size());
        System.out.println("Drzewo spinające składa się z krawędzi:");
        System.out.println("u v waga");
        K1.wyznacz();
    }
}
