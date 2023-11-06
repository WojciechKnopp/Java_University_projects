public class Node {
    String element;
    int quantity;
    Node left, right;
    Node(String element, int quantity, Node left, Node right){
        this.element=element;
        this.quantity=quantity;
        this.left=left;
        this.right=right;
    }
}
