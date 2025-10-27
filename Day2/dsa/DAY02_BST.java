import java.util.*;

class BSTNode {
    int key;
    BSTNode left, right;
    BSTNode(int k) { key = k; left = right = null; }
}

public class DAY02_BST {
    private BSTNode root;

    public DAY02_BST() { root = null; }

    public void add(int key) { root = insert(root, key); }

    private BSTNode insert(BSTNode node, int key) {
        if (node == null) return new BSTNode(key);
        if (key < node.key) node.left = insert(node.left, key);
        else if (key > node.key) node.right = insert(node.right, key);
        return node;
    }

    public void remove(int key) { root = deleteNode(root, key); }

    private BSTNode deleteNode(BSTNode node, int key) {
        if (node == null) return null;
        if (key < node.key) node.left = deleteNode(node.left, key);
        else if (key > node.key) node.right = deleteNode(node.right, key);
        else {
            // node found
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;
            // two children: replace with inorder successor
            node.key = minValue(node.right);
            node.right = deleteNode(node.right, node.key);
        }
        return node;
    }

    private int minValue(BSTNode node) {
        int minv = node.key;
        while (node.left != null) { node = node.left; minv = node.key; }
        return minv;
    }

    public void inorder() { inorder(root); System.out.println(); }
    private void inorder(BSTNode node) {
        if (node == null) return;
        inorder(node.left); System.out.print(node.key + " "); inorder(node.right);
    }

    public void preorder() { preorder(root); System.out.println(); }
    private void preorder(BSTNode node) {
        if (node == null) return;
        System.out.print(node.key + " "); preorder(node.left); preorder(node.right);
    }

    public void postorder() { postorder(root); System.out.println(); }
    private void postorder(BSTNode node) {
        if (node == null) return;
        postorder(node.left); postorder(node.right); System.out.print(node.key + " ");
    }

    // Demo main
    public static void main(String[] args) {
        DAY02_BST tree = new DAY02_BST();
        int[] vals = {50,30,20,40,70,60,80};
        for (int v : vals) tree.add(v);
        System.out.print("Inorder: "); tree.inorder();
        System.out.print("Preorder: "); tree.preorder();
        System.out.print("Postorder: "); tree.postorder();
        tree.remove(50);
        System.out.print("After removing 50, Inorder: "); tree.inorder();
    }
}