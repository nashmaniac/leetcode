package trees;

public class Node<T extends Comparable<T>> {
    private T value;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getHeight(Node<T> root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.getLeftChild()), getHeight(root.getRightChild()));
    }

    public int getHeight() {
        return getHeight(this);
    }

}
