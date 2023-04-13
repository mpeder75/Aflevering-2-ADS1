import java.util.ArrayList;

public class BinaryTree <T> implements Comparable <T>
{

    private BinaryTreeNode root;
    private int size;



    public BinaryTreeNode getRoot(){
        return root;
    }

    public void setRoot(BinaryTreeNode root){
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
        while()
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

    }

    public ArrayList<T> preOrder()
    {

    }

    public ArrayList<T> postOrder()
    {

    }

    public ArrayList<T> levelOrder()
    {

    }

    public int height()
    {
        return size -1;
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }
}
