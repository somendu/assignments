package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class BinaryTreeTraversalTest {
  @Test
  void producesAllThreeTraversalOrders() {
    BinaryTreeTraversal.Node root = new BinaryTreeTraversal.Node(1);
    root.left = new BinaryTreeTraversal.Node(2);
    root.right = new BinaryTreeTraversal.Node(3);
    root.left.left = new BinaryTreeTraversal.Node(4);
    root.left.right = new BinaryTreeTraversal.Node(5);
    assertEquals(List.of(4, 2, 5, 1, 3), BinaryTreeTraversal.inorder(root));
    assertEquals(List.of(1, 2, 4, 5, 3), BinaryTreeTraversal.preorder(root));
    assertEquals(List.of(4, 5, 2, 3, 1), BinaryTreeTraversal.postorder(root));
    assertEquals(4, root.left.left.value);
    assertEquals(3, root.right.value);
  }

  @Test
  void acceptsEmptyTrees() {
    assertEquals(List.of(), BinaryTreeTraversal.inorder(null));
    assertEquals(List.of(), BinaryTreeTraversal.preorder(null));
    assertEquals(List.of(), BinaryTreeTraversal.postorder(null));
  }

  @Test
  void visitsSingleNodeInEveryOrder() {
    BinaryTreeTraversal.Node root = new BinaryTreeTraversal.Node(7);
    assertEquals(List.of(7), BinaryTreeTraversal.inorder(root));
    assertEquals(List.of(7), BinaryTreeTraversal.preorder(root));
    assertEquals(List.of(7), BinaryTreeTraversal.postorder(root));
  }

  @Test
  void handlesSkewedTreesAndRepeatedValues() {
    BinaryTreeTraversal.Node root = new BinaryTreeTraversal.Node(1);
    root.right = new BinaryTreeTraversal.Node(2);
    root.right.right = new BinaryTreeTraversal.Node(2);
    assertEquals(List.of(1, 2, 2), BinaryTreeTraversal.inorder(root));
    assertEquals(List.of(1, 2, 2), BinaryTreeTraversal.preorder(root));
    assertEquals(List.of(2, 2, 1), BinaryTreeTraversal.postorder(root));
  }
}
