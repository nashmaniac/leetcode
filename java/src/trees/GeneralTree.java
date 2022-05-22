package trees;

import java.util.LinkedList;
import java.util.Queue;

public class GeneralTree<T extends Comparable<T>> {

    private int spaces = 2;

    public StringBuilder getBuilderString(StringBuilder s, int start, int end, char c) {
        for (int j = start; j < end; j++) {
            s = s.append(c);
        }
        return s;
    }

    public String getSingleLine(Node<T> node, int spacesLine) {
        StringBuilder s = new StringBuilder();
        if ((int) node.getValue() == Integer.MIN_VALUE) {
            s = getBuilderString(s, 0, 2 * spacesLine, ' ');
        } else {
            int i = 0;
            int to = spacesLine/2;
            char c = ' ';
            s = getBuilderString(s, i, to, c);
            if(node.getLeftChild() != null) {
                c = '_';
            }
            s = getBuilderString(s, i, to, c);

            String value = String.valueOf((int) node.getValue());
            s = s.append(value);
            c = ' ';
            if(node.getRightChild() != null) {
                c = '_';
            }
            s = getBuilderString(s, value.length(), to, c);
            c = ' ';
            s = getBuilderString(s, i, to, c);
        }
        return s.toString();
    }

    public void printTree(Node<T> root, Node<T> dummy) {
        int level = 0;
        int height = root.getHeight();

        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();

            if (node == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                System.out.println();
                level++;
            } else {
                int s = ((int) Math.pow(2, height - level) * this.spaces);
                String lineString = getSingleLine(node, s);
                System.out.print(lineString);
                if (node.getLeftChild() == null) {
                    queue.add(dummy);
                } else {
                    queue.add(node.getLeftChild());
                }
                if (node.getRightChild() == null) {
                    queue.add(dummy);
                } else {
                    queue.add(node.getRightChild());
                }
            }
        }
    }
}
