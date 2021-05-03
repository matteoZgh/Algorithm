package datastructure.tree;

public class OrderStrategy {
    public static <T> void preOrderStrategy(BinaryTreeNode<T> root, BinaryTree<T> binaryTree) {
        System.out.print(root.getVal());
        binaryTree.order(root.getLeft(), OrderStrategy::preOrderStrategy);
        binaryTree.order(root.getRight(), OrderStrategy::preOrderStrategy);
    }

    public static <T> void inOrderStrategy(BinaryTreeNode<T> root, BinaryTree<T> binaryTree) {
        binaryTree.order(root.getLeft(), OrderStrategy::inOrderStrategy);
        System.out.print(root.getVal());
        binaryTree.order(root.getRight(), OrderStrategy::inOrderStrategy);
    }

    public static <T> void postOrderStrategy(BinaryTreeNode<T> root, BinaryTree<T> binaryTree) {
        binaryTree.order(root.getLeft(), OrderStrategy::postOrderStrategy);
        binaryTree.order(root.getRight(), OrderStrategy::postOrderStrategy);
        System.out.print(root.getVal());
    }
}
