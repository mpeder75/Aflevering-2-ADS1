package binarySearchTree;
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
        // TODO:
        return false;
    }

    public T findMin() {
        // TODO:
        return null;
    }

    public T findMax() {
        // TODO:
        return null;
    }

    public boolean contains(T element) {
        // TODO:
        return false;
    }

    public void rebalance() {
        // TODO:
    }

}
