package trees;

public interface Tree<T extends Comparable<T>> {

    Tree<T> insert(T value);
    void delete(T value);
    void traverse();
    T getMax();
    T getMin();
    Node<T> getMaxChild(Node<T> root);
    Node<T> getMinChild(Node<T> root);
    boolean isEmpty();
    
}
