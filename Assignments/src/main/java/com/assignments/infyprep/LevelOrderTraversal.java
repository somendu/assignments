package com.assignments.infyprep;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LevelOrderTraversal {
  public static class Node {
    public final int value;
    public Node left;
    public Node right;

    public Node(int value) {
      this.value = value;
    }
  }

  // BFS for an acyclic tree: O(n) time, O(width) queue plus O(n) output.
  public static List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> levels = new ArrayList<>();
    if (root == null) {
      return levels;
    }
    Deque<Node> queue = new ArrayDeque<>();
    queue.addLast(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size(); // Freeze the size before adding the next level.
      List<Integer> level = new ArrayList<>();
      for (int i = 0; i < levelSize; i++) {
        Node node = queue.removeFirst();
        level.add(node.value);
        if (node.left != null) {
          queue.addLast(node.left);
        }
        if (node.right != null) {
          queue.addLast(node.right);
        }
      }
      levels.add(level);
    }
    return levels;
  }

  public static void main(String[] args) {
    Node root = new Node(3);
    root.left = new Node(9);
    root.right = new Node(20);
    root.right.left = new Node(15);
    root.right.right = new Node(7);
    System.out.println(
        "Tree [3,9,20,null,null,15,7] -> "
            + levelOrder(root)
            + " (expected: [[3], [9, 20], [15, 7]])");
    System.out.println("Empty tree -> " + levelOrder(null) + " (expected: [])");
  }
}
