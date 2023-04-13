public class BinaryTreeNode<T> implements Comparable<T>{

    private T element;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public void setElement(T element)
    {
        this.element = element;
    }

    public T getElement()
    {
        return element;
    }

    public void addLeftChild(BinaryTreeNode<T> leftChild)
    {
        this.leftChild = leftChild;
    }

    public void addRightChild(BinaryTreeNode<T> rightChild)
    {
        this.rightChild = rightChild;
    }

    public BinaryTreeNode<T> getLeftChild()
    {
        return leftChild;
    }

    public BinaryTreeNode<T> getRightChild(){
        return rightChild;
    }

    @Override
    public int compareTo(T o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
