import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*  ilość powtórzeń:
x   quantity
0   5
1   10
2   2
3   3
4   1
5   7
6   2
7   9
*/
        try {
            File file = new File("huffman_short.txt");
            Scanner sc = new Scanner(file);

            // ZLICZ WYSTĄPIENIA LITER //
            Node e0 = new Node("0", 0, null, null);
            Node e1 = new Node("1", 0, null, null);
            Node e2 = new Node("2", 0, null, null);
            Node e3 = new Node("3", 0, null, null);
            Node e4 = new Node("4", 0, null, null);
            Node e5 = new Node("5", 0, null, null);
            Node e6 = new Node("6", 0, null, null);
            Node e7 = new Node("7", 0, null, null);
            Node[] quantity = {e0, e1, e2, e3, e4, e5, e6, e7};
            String data = sc.nextLine();
            for(int i=0; i<data.length(); i++){
                char tmp = data.charAt(i);
                quantity[tmp-48].quantity++;
            }
            PriorityQueue<Node> queue = new PriorityQueue<>(8,new PriorityComparator());
            queue.addAll(Arrays.asList(quantity));

            // ZLICZ WYSTĄPIENIA DWUZNAKÓW //
            ArrayList<Node> quantity2 = new ArrayList<>();
            for(int i=0; i<data.length()-1; i+=2){
                String letter = data.substring(i,i+2);
                boolean found = false;
                for(int j=0; j<quantity2.size() && !found; j++){
                    if(letter.equals(quantity2.get(j).element)){
                        quantity2.get(j).quantity++;
                        found=true;
                    }
                }
                if(!found){
                    Node created = new Node(letter,1,null,null);
                    quantity2.add(created);
                }
            }
            if(data.length()%2==1){
                String letter = data.substring(data.length()-1);
                Node created = new Node(letter,1,null,null);
                quantity2.add(created);
            }
            PriorityQueue<Node> queue2 = new PriorityQueue<>(1, new PriorityComparator());
            queue2.addAll(quantity2);

            // HUFFMAN //
            Huffman H1 = new Huffman(queue);
            H1.show_codes();
            H1.coded_size(data,1);
            System.out.println();
    /*
    4       0000
    2       0001
    0       001
    7       01
    1       10
    6       1100
    3       1101
    5       111
    */
            Huffman H2 = new Huffman(queue2);
            H2.show_codes();
            H2.coded_size(data,2);

        }catch(FileNotFoundException e){
            System.out.println("Nie znaleziono pliku wejściowego.");
        }
    }
}
