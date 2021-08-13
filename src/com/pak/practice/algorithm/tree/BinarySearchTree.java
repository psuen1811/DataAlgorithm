package com.pak.practice.algorithm.tree;

public class BinarySearchTree {

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    static class Node {
        final int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }

    void inOrder() {
        inOrderRec(root);
    }

    void inOrderRec(Node root) {
        if( root != null) {
            inOrderRec(root.left);
            System.out.println(root.key);
            inOrderRec(root.right);
        }
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if(root == null) {
            root = new Node(key);
            return root;
        }

        if( key < root.key)
            root.left = insertRec(root.left, key);
        else
            root.right = insertRec(root.right, key);

        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.inOrder();
    }
}
