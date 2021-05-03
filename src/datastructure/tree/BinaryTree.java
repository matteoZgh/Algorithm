package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.BiConsumer;

public class BinaryTree<T> {
    private BinaryTreeNode<T> root;

    public BinaryTree() {
    }

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public static <T> BinaryTree<T> buildTree(T[] array) {
        BinaryTreeNode<T> root = buildTree0(array, 1);
        return new BinaryTree<>(root);
    }

    private static <T> BinaryTreeNode<T> buildTree0(T[] array, int i) {
        if (array.length < i || array[i - 1] == null) {
            return null;
        }
        BinaryTreeNode<T> root = new BinaryTreeNode<>(array[i - 1]);
        BinaryTreeNode<T> left = buildTree0(array, i * 2);
        BinaryTreeNode<T> right = buildTree0(array, i * 2 + 1);
        root.setLeft(left);
        root.setRight(right);
        return root;
    }

    public void printTree() {
        BinaryTreeNode<T> root = this.root;
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0, size = 0;
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> node = queue.poll();
            if (node.getLeft() != null) queue.offer(node.getLeft());
            if (node.getRight() != null) queue.offer(node.getRight());
            System.out.print(node.getVal());
            size++;
            if (Math.pow(2, level) == size) {
                System.out.println();
                size = 0;
                level++;
            } else {
                System.out.print(" ");
            }
        }
    }

    public void preOrder() {
        order(root, OrderStrategy::preOrderStrategy);
    }

    public void inOrder() {
        order(root, OrderStrategy::inOrderStrategy);
    }

    public void postOrder() {
        order(root, OrderStrategy::postOrderStrategy);
    }

    public void order(BinaryTreeNode<T> root, BiConsumer<BinaryTreeNode<T>, BinaryTree<T>> strategy) {
        if (root == null) {
            return;
        }
        strategy.accept(root, this);
    }
}
