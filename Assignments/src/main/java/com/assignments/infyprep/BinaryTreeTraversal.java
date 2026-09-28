package com.assignments.infyprep;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversal {
  public static class Node {
    public final int value;
    public Node left;
    public Node right;

    public Node(int value) {
      this.value = value;
    }
  }

  // Each traversal: O(n) time, O(h) call stack plus O(n) output for tree height h.
  // Assumes an acyclic tree; recursive examples suit trees with moderate depth.
  public static List<Integer> inorder(Node root) {
    List<Integer> result = new ArrayList<>();
    inorder(root, result);
    return result;
  }

  private static void inorder(Node node, List<Integer> result) {
    if (node == null) {
      return;
    }
    inorder(node.left, result);
    result.add(node.value);
    inorder(node.right, result);
  }

  public static List<Integer> preorder(Node root) {
    List<Integer> result = new ArrayList<>();
    preorder(root, result);
    return result;
  }

  private static void preorder(Node node, List<Integer> result) {
    if (node == null) {
      return;
    }
    result.add(node.value);
    preorder(node.left, result);
    preorder(node.right, result);
  }

  public static List<Integer> postorder(Node root) {
    List<Integer> result = new ArrayList<>();
    postorder(root, result);
    return result;
  }

  private static void postorder(Node node, List<Integer> result) {
    if (node == null) {
      return;
    }
    postorder(node.left, result);
    postorder(node.right, result);
    result.add(node.value);
  }

  public static void main(String[] args) {
    //       1
    //      / \
    //     2   3
    //    / \
    //   4   5
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    System.out.println("Inorder -> " + inorder(root) + " (expected: [4, 2, 5, 1, 3])");
    System.out.println("Preorder -> " + preorder(root) + " (expected: [1, 2, 4, 5, 3])");
    System.out.println("Postorder -> " + postorder(root) + " (expected: [4, 5, 2, 3, 1])");
    System.out.println("Empty tree -> " + inorder(null) + " (expected: [])");
  }
}
