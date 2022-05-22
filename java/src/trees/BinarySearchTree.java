package trees;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    private void traverseInOrder(Node<T> root) {
        if (root == null) {
            return;
        }
        traverseInOrder(root.getLeftChild());
        System.out.println(root.getValue());
        traverseInOrder(root.getRightChild());
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    public Node<T> insertRecursive(T value, Node<T> node) {
        if (node == null) {
            return new Node<T>(value);
        } else if (value.compareTo(node.getValue()) < 0) {
            node.setLeftChild(insertRecursive(value, node.getLeftChild()));
        } else {
            node.setRightChild(insertRecursive(value, node.getRightChild()));
        }
        return node;
    }

    public void insert(T value, Node<T> node) {
        if (value.compareTo(node.getValue()) < 0) {
            if (node.getLeftChild() == null) {
                Node<T> newNode = new Node<T>(value);
                node.setLeftChild(newNode);
            } else {
                insert(value, node.getLeftChild());
            }
        } else if (value.compareTo(node.getValue()) > 0) {
            if (node.getRightChild() == null) {
                Node<T> newNode = new Node<T>(value);
                node.setRightChild(newNode);
            } else {
                insert(value, node.getRightChild());
            }
        }
    }

    @Override
    public Tree<T> insert(T value) {
        if (this.isEmpty()) {
            root = new Node<T>(value);
        } else {
            insert(value, root);
        }

        return this;
    }

    public Node<T> delete(T value, Node<T> node) {
        if (node == null) {
            return null;
        }

        if (value.compareTo(node.getValue()) < 0) {
            node.setLeftChild(delete(value, node.getLeftChild()));
        } else if (value.compareTo(node.getValue()) > 0) {
            node.setRightChild(delete(value, node.getRightChild()));
        } else {
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            } else {
                Node<T> maxNode = getMaxChild(node.getLeftChild());
                node.setValue(maxNode.getValue());
                node.setLeftChild(delete(maxNode.getValue(), node.getLeftChild()));
            }
        }
        return node;
    }

    @Override
    public void delete(T value) {
        root = delete(value, root);
    }

    @Override
    public void traverse() {
        traverseInOrder(root);
    }

    @Override
    public T getMax() {
        Node<T> maxNode = getMaxChild(root);
        if (maxNode == null) {
            return null;
        }
        return maxNode.getValue();
    }

    @Override
    public T getMin() {
        Node<T> minNode = getMinChild(root);
        if (minNode == null) {
            return null;
        }
        return minNode.getValue();
    }

    @Override
    public Node<T> getMaxChild(Node<T> root) {
        if (root == null) {
            return null;
        }
        while (root.getRightChild() != null) {
            root = root.getRightChild();
        }
        return root;
    }

    @Override
    public Node<T> getMinChild(Node<T> root) {
        if (root == null) {
            return null;
        }
        while (root.getLeftChild() != null) {
            root = root.getLeftChild();
        }

        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        int[] numbers = new int[] {
            57, 67, 26, 15, 37, 38, 10, 12, 88, 100
        };
        for(int i: numbers) {
            bst.insert(i);
        }

        GeneralTree<Integer> g = new GeneralTree<Integer>();
        Node<Integer> dummy = new Node<Integer>(Integer.MIN_VALUE);

        g.printTree(bst.root, dummy);

    }
}
