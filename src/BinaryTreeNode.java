public class BinaryTreeNode {

    private T element ;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public void setElement(T element)
    {
        this.element = element;
    }

    public T getElement()
    {
        return element;
    }

    public void addLeftChild(BinaryTreeNode leftChild)
    {
        this.leftChild = leftChild;
    }

    public void addRightChild(BinaryTreeNode rightChild)
    {
        this.rightChild = rightChild;
    }

    public BinaryTreeNode getLeftChild()
    {
        return leftChild;
    }

    public BinaryTreeNode getRightChild(){
        return rightChild;
    }
}
