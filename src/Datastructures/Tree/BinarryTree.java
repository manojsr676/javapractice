package Datastructures.Tree;




class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
        this.right=null;
        this.left=null;
    }
}
public class BinarryTree {
    static  Node createnode(int val){
        Node n=new Node(val);
        return n;
    }
    static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    static void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }
    static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root=createnode(1);
        root.left=createnode(2);
        root.right=createnode(3);
        root.left.left=createnode(4);

        System.out.print("Preorder (preorder): ");
        preorder(root);
        System.out.println();

        System.out.print("Inorder (DFS): ");
        inorder(root);
        System.out.println();

        System.out.print("Postorder (DFS): ");
        postorder(root);
        System.out.println();


    }
}
