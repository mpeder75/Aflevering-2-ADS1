package binarySearchTree;

import java.util.List;

import binaryTree.BinaryTree;
import binaryTree.BinaryTreeNode;

public class BinarySearchTree <T> extends BinaryTree <T>
{

    public boolean insert(T element) {

            if (super.getRoot() == null) {
                super.setRoot(new BinaryTreeNode<T>());
                super.getRoot().setElement(element);
                return true;
            }

            return insertRecursive(element, super.getRoot());
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
        if (super.getRoot() == null) {
            return false;
        }

        return  removeElementRecursive(findNode(element, super.getRoot()), super.getRoot());
    }

    private boolean removeElementRecursive(BinaryTreeNode<T> nodeToDelete, BinaryTreeNode<T> currentNode) {

        if (nodeToDelete.equals(currentNode))
            return false;
        
        if ((Integer) currentNode.getElement() < (Integer) nodeToDelete.getElement() && 
                removeElementRecursive(nodeToDelete, currentNode.getLeftChild()) == false) {
                
            return swapNodesAndDelete(nodeToDelete);
        }

        if ((Integer) currentNode.getElement() > (Integer) nodeToDelete.getElement() && 
                removeElementRecursive(nodeToDelete, currentNode.getRightChild()) == false) {
                
            return swapNodesAndDelete(nodeToDelete);
        }

        throw new IllegalArgumentException("No such element in tree");
    }

    private boolean swapNodesAndDelete(BinaryTreeNode<T> nodeToDelete) {
        BinaryTreeNode<T> swapNode = null, currentNode;

        currentNode = nodeToDelete.getRightChild();

        while (swapNode == null) {
            if (currentNode.getLeftChild() != null) {
                currentNode = currentNode.getLeftChild();
            }
            else swapNode = currentNode;
        }

        nodeToDelete.addLeftChild(swapNode.getLeftChild());

        nodeToDelete.setElement(swapNode.getElement());

        return true;
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
        
        int balance_factor = height(super.getRoot().getLeftChild()) - height(super.getRoot().getRightChild());

        if (!(balance_factor > 1 || balance_factor < -1)) {
            System.out.println("Tree is balanced");
            return;
        }

        rebalanceRecursive(super.getRoot());

    }

    private boolean rebalanceRecursive(BinaryTreeNode<T> currentNode) {

        boolean isLeft = false;

        if (height(currentNode.getLeftChild()) > height(currentNode.getRightChild())) {
            isLeft = true;

            if (height(currentNode.getLeftChild()) > 2) {
                rebalanceRecursive(currentNode.getLeftChild());
            }
        } else {
            if (height(currentNode.getRightChild()) > 2) {
                rebalanceRecursive(currentNode.getRightChild());
            }
        }

        if (isLeft)
        {
            leftLeftRotation(currentNode, currentNode.getLeftChild());
        } else {
            rightRightRotation(currentNode, currentNode.getRightChild());
        }
        return true;
    }




    private void leftLeftRotation(BinaryTreeNode<T> parentNode, BinaryTreeNode<T> childNode) {
        BinaryTreeNode<T> grandChildNode = childNode.getRightChild();
        childNode.addLeftChild(grandChildNode.getRightChild());
        grandChildNode.addRightChild(childNode);
        parentNode.addLeftChild(grandChildNode);
    }

    private void rightRightRotation(BinaryTreeNode<T> parentNode, BinaryTreeNode<T> childNode) {
        BinaryTreeNode<T> grandChildNode = childNode.getRightChild();
        childNode.addRightChild(grandChildNode.getLeftChild());
        grandChildNode.addLeftChild(childNode);
        parentNode.addRightChild(grandChildNode);
    }

    private void leftRightRotation(BinaryTreeNode<T> parentNode, BinaryTreeNode<T> childNode) {
        BinaryTreeNode<T> grandChildNode = childNode.getRightChild();

        // Making initial right rotation
        rightRightRotation(childNode, grandChildNode);

        // Making left rotation
        leftLeftRotation(parentNode, grandChildNode);

    }

    private void rightLeftRotation(BinaryTreeNode<T> parentNode, BinaryTreeNode<T> childNode) {
        BinaryTreeNode<T> grandChildNode = childNode.getLeftChild();

        // Making left rotation
        leftLeftRotation(parentNode, grandChildNode);

        // Making initial right rotation
        rightRightRotation(childNode, grandChildNode);

        
    }

}
