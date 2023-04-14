package binarySearchTree;

import java.util.List;

import binaryTree.BinaryTree;
import binaryTree.BinaryTreeNode;

public class BinarySearchTree <T> extends BinaryTree <T>
{
    BinaryTreeNode<T> root;

    public boolean insert(T element) {

            if (this.root == null) return false;

            return insertRecursive(element, this.root);
    }

    private boolean insertRecursive(T element, BinaryTreeNode<T> currentNode)
    {
        if ((Integer)element == (Integer)currentNode.getElement())
        {
            return false;
        }

        if ((Integer)element > (Integer) currentNode.getElement())
        {
            if (currentNode.getRightChild() == null) {
                currentNode.addRightChild(new BinaryTreeNode<T>(element));
                return true;
            }

            return insertRecursive(element, currentNode.getRightChild());
        }else {
            if (currentNode.getLeftChild() == null) {
                currentNode.addLeftChild(new BinaryTreeNode<T>(element));
                return true;
            }

            return insertRecursive(element, currentNode.getLeftChild());
        }
    }


    public boolean removeElement(T element) {
        if (this.root == null)
            return false;
        
        BinaryTreeNode<T> removingNode = findNode(element, this.root);
        BinaryTreeNode<T> replacingNode = findRightMostNode(this.root);

        if (removingNode == null || replacingNode == null)
            return false;

        removingNode.setElement(replacingNode.getElement());
        removeRightMostNode(this.root);

        return true;
    }

    private void removeRightMostNode(BinaryTreeNode<T> currentNode) {
        // TODO: 
    }

    private BinaryTreeNode<T> findRightMostNode(BinaryTreeNode<T> currentNode) {

        // TODO:
        
        if (currentNode.getRightChild() != null) {
            return findRightMostNode(currentNode.getRightChild());
        }

        return currentNode;
    }

    private BinaryTreeNode<T> findNode(T element, BinaryTreeNode<T> currentNode) {

        if (element.equals(currentNode.getElement()))
            return currentNode;
    
        // Checks if any of the children are null and returns null if true.
        if ((Integer)element < (Integer)currentNode.getElement() && currentNode.getLeftChild() == null)
            return null;
        else if ((Integer)element > (Integer)currentNode.getElement() && currentNode.getLeftChild() == null)
            return null;

        // Checks wether the node is higher or lower than current element and returns that.
        if ((Integer)element < (Integer)currentNode.getElement()) {
            return findNode(element, currentNode.getLeftChild());
        } 
        else {
            return findNode(element, currentNode.getRightChild());
        }
    }


    public T findMin() {
        List<T> list = inOrder();

        return list.get(size()-1);
    }

    public T findMax() {
        return inOrder().get(0);
    }

    public void rebalance() {
        // TODO:
    }

}
