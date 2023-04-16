import binarySearchTree.BinarySearchTree;
import binaryTree.BinaryTree;
import binaryTree.BinaryTreeNode;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        System.out.println("preorder: " + tree.preOrder());
        System.out.println("inorder: " + tree.inOrder());
        System.out.println("postorder: " + tree.postOrder());

        BinaryTreePrint print = new BinaryTreePrint();

        print.printTree(tree.getRoot());

        tree.rebalance();

        print.printTree(tree.getRoot());
    }
}