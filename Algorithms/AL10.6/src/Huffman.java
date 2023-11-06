import java.util.ArrayList;
import java.util.PriorityQueue;

public class Huffman {
    PriorityQueue<Node> queue;
    ArrayList<Coded_letter> Cipher = new ArrayList<>();

    Huffman(PriorityQueue<Node> q){
        queue=q;
        while(queue.size()>1){
            Node n1 = queue.poll();
            Node n2 = queue.poll();
            Node Z = new Node("created", n1.quantity+n2.quantity,n1,n2);
            queue.add(Z);
        }
        read_codes("", queue.poll());
    }

    private void read_codes(String code, Node x){
        if(x.left==null && x.right==null){
            Coded_letter tmp = new Coded_letter(x.element, code);
            Cipher.add(tmp);
            return;
        }
        if(x.left!=null) read_codes(code+"0", x.left);
        if(x.right!=null) read_codes(code+"1", x.right);
    }

    public void show_codes(){
        String format = "%-7s %-10s\n";
        System.out.format(format, "Letter", "Code");
        for(int i=0; i< Cipher.size(); i++){
            System.out.format(format, Cipher.get(i).content, Cipher.get(i).code);
        }
    }

    public void coded_size(String text, int letter_size){
        String letter="";
        int size=0;
        for(int i=0; i<text.length()-1; i+=letter_size){
            letter=text.substring(i,i+letter_size);
            for(int j=0; j<Cipher.size(); j++){
                if(letter.equals(Cipher.get(j).content)){
                    size+=Cipher.get(j).code.length();
                    letter="";
                }
            }
        }
        if(text.length()%2==1 || letter_size==1){
            letter=text.substring(text.length()-1);
            for(int j=0; j<Cipher.size(); j++){
                if(letter.equals(Cipher.get(j).content)){
                    size+=Cipher.get(j).code.length();
                }
            }
        }
        System.out.println("Zakodowany tekst miałby długość "+size+" bitów.");
    }
}
