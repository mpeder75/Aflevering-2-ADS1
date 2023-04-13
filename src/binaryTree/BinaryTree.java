package binaryTree;
import java.util.ArrayList;

public class BinaryTree <T>
{

    private BinaryTreeNode<T> root;
    private int size;



    public BinaryTreeNode<T> getRoot(){
        return root;
    }

    public void setRoot(BinaryTreeNode<T> root){
        this.root = root;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int size()
    {
        return size;
    }

    public boolean contains (T element)
    {
        // TODO:
        while(true)
        {
            if (root == null) return false;

            if ((Integer)root.getLeftChild().getElement() > (Integer)element)
            {

            } else {

            }
        }
    }

    public ArrayList<T> inOrder()
    {
        // TODO:
        throw new UnsupportedOperationException("Unimplemented method");
    }

    public ArrayList<T> preOrder()
    {
        // TODO:
        throw new UnsupportedOperationException("Unimplemented method");
    }

    public ArrayList<T> postOrder()
    {
        // TODO:
        throw new UnsupportedOperationException("Unimplemented method");
    }

    public ArrayList<T> levelOrder()
    {
        // TODO:
        throw new UnsupportedOperationException("Unimplemented method");
    }

    public int height()
    {
        // TODO:
        return size -1;
    }
}
