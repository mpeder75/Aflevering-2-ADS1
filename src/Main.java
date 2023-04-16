import binaryTree.BinaryTree;
import binaryTree.BinaryTreeNode;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        BinaryTree<Integer> tree = new BinaryTree<>();

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> l = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> r = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> ll = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> lr = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> rr = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> rl = new BinaryTreeNode<>();

        root.setElement(10);
        l.setElement(8);
        r.setElement(12);
        ll.setElement(6);
        lr.setElement(9);
        rr.setElement(13);
        rl.setElement(11);

        root.addLeftChild(l);
        root.addRightChild(r);
        l.addLeftChild(ll);
        l.addRightChild(lr);
        r.addLeftChild(rl);
        r.addRightChild(rr);

        tree.setRoot(root);

        System.out.println("preorder: " + tree.preOrder());
        System.out.println("inorder: " + tree.inOrder());
        System.out.println("postorder: " + tree.postOrder());
    }
}