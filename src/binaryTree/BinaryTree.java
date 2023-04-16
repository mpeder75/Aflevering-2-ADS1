package binaryTree;

import java.util.ArrayList;

public class BinaryTree<T> {

    private BinaryTreeNode<T> root;
    private int size;


    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size;
    }

    public boolean contains(T element) {
        if (root == null) return false;

        BinaryTreeNode<T> localRoot = this.root;

        while (localRoot != null) {
            if (localRoot.getElement() == element) {
                return true;
            }

            if ((Integer) localRoot.getElement() > (Integer) element) {
                localRoot = localRoot.getRightChild();
            } else {
                localRoot = localRoot.getLeftChild();
            }
        }
        return false;
    }

    public ArrayList<T> inOrder() {
        if (this.root == null) return null;

        return inOrderTraversal(new ArrayList<T>(), this.root);
    }

    private ArrayList<T> inOrderTraversal(ArrayList<T> traverSalList, BinaryTreeNode<T> currentNode) {

        if (currentNode.getLeftChild() != null) {
            traverSalList = inOrderTraversal(traverSalList, currentNode.getLeftChild());
        }

        traverSalList.add(currentNode.getElement());

        if (currentNode.getRightChild() != null) {
            traverSalList = inOrderTraversal(traverSalList, currentNode.getRightChild());
        }
        return traverSalList;
    }

    public ArrayList<T> preOrder() {

     if (this.root == null) return null;

     return preOrderTraversal(new ArrayList<T>(), this.root);

    }
    private ArrayList<T> preOrderTraversal(ArrayList<T> traversalList, BinaryTreeNode<T> currentNode)
    {
        traversalList.add(currentNode.getElement());

        if (currentNode.getLeftChild() != null) {
            traversalList = preOrderTraversal(traversalList, currentNode.getLeftChild());

        }

        if (currentNode.getRightChild() != null ) {
            traversalList = preOrderTraversal(traversalList, currentNode.getRightChild());
        }

        return traversalList;
    }

    public ArrayList<T> postOrder() {
       if (this.root == null) return null;

       return postOrderTraversal(new ArrayList<T>(), this.root);

    }

    private ArrayList<T> postOrderTraversal(ArrayList<T> traversalList, BinaryTreeNode<T> currentNode)
    {
        if (currentNode.getLeftChild() != null)
        {
            traversalList = postOrderTraversal(traversalList, currentNode.getLeftChild());

        }

        if (currentNode.getRightChild() != null)
        {
            traversalList = postOrderTraversal(traversalList, currentNode.getRightChild());
        }

        traversalList.add(currentNode.getElement());

        return traversalList;

    }


    public ArrayList<T> levelOrder() {
        if (this.root == null) return null;

        return levelOrderTraversal(new ArrayList<T>(), this.root);
    }

    private ArrayList<T> levelOrderTraversal(ArrayList<T> traversalList, BinaryTreeNode<T> currentNode)
    {
        ArrayList<T> list1 = new ArrayList<>();
        ArrayList<T> list2 = new ArrayList<>();

        traversalList.add(currentNode.getElement());

        if (currentNode.getLeftChild() != null)
            list1 = levelOrderTraversal(traversalList, currentNode.getLeftChild());

        if (currentNode.getRightChild() != null)
            list2 = levelOrderTraversal(traversalList, currentNode.getRightChild());

        traversalList.addAll(list1);
        traversalList.addAll(list2);

        return  traversalList;

    }

    public int height() {
        if (this.root == null) return 0;

        return heightTraversal(-1, this.root);
    }

    public int height(BinaryTreeNode<T> currentNode) {
        if (currentNode == null) return 0;

        return heightTraversal(-1, currentNode);
    }

    public int heightTraversal(int height, BinaryTreeNode<T> currentNode) {

        height += 1;

        int rightHeight = height;
        int leftHeight = height;


        if (currentNode.getLeftChild() != null)
            leftHeight += heightTraversal(height, currentNode.getLeftChild());

        if (currentNode.getRightChild() != null)
            rightHeight += heightTraversal(height, currentNode.getRightChild());

        return Math.max(rightHeight, leftHeight);
    }
}
