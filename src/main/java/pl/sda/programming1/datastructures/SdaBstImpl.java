package pl.sda.programming1.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class SdaBstImpl<T extends Comparable<T>> implements SdaBst<T> {

    private Node root;

    public SdaBstImpl(T[] elements) {
        for (T element : elements) {
            insert(element);
        }
    }

    @Override
    public void insert(T element) {
        if (element == null) {
            throw new NullPointerException("Element cannot be null!");
        }
        if (root == null) {
            root = new Node(element);
        } else {
            insert(root, element);
        }
    }

    private void insert(Node node, T element) {
        if (node.value.compareTo(element) < 0) {
            if (Objects.isNull(node.right)) {
                node.right = new Node(element);
            } else {
                insert(node.right, element);
            }
        } else if (node.value.compareTo(element) > 0) {
            if (Objects.isNull(node.left)) {
                node.left = new Node(element);
            } else {
                insert(node.left, element);
            }
        } else {
            node.value = element;
        }
    }

    @Override
    public boolean contains(T element) {
        return contains(root, element);
    }

    private boolean contains(Node node, T element) {
        if (node == null) {
            return false;
        } else {
            return node.value.equals(element) || contains(node.left, element) || contains(node.right, element);
        }
    }

    @Override
    public void delete(T element) {
        root = delete(root, element);
    }

    private Node delete(Node node, T element) {
        if (node == null) {
            return null;
        } else if (node.value.compareTo(element) < 0) { // węzeł do usunięcia znajduje się w prawym poddrzewie
            node.right = delete(node.right, element);
            return node;
        } else if (node.value.compareTo(element) > 0) { // wezeł do usunięcia znajduje się w lewym poddrzewie
            node.left = delete(node.left, element);
            return node;
        } else if (node.left == null) { // wezeł do usunięcia ma co najwyżej prawe dziecko
            return node.right;
        } else if (node.right == null) { // wezeł do usunięcia ma co najwyżej lewe dziecko
            return node.left;
        } else { // wezel do usuniecia ma dwoje dzieci
            Node successor = node.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            delete(node, successor.value);
            node.value = successor.value;
            return node;
        }
    }

    @Override
    public List<T> toList() {
        List<T> result = new ArrayList<>();
        inOrder(root, result::add);
        return result;
    }

    private void inOrder(Node node, Consumer<T> visitor) {
        if (node == null) {
            return;
        }
        inOrder(node.left, visitor);
        visitor.accept(node.value);
        inOrder(node.right, visitor);
    }

    private class Node {
        private T value;
        private Node left;
        private Node right;

        public Node(T value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
