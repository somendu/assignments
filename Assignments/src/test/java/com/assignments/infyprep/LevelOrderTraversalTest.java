package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LevelOrderTraversalTest {
  @Test
  void groupsNodesByLevelFromLeftToRight() {
    LevelOrderTraversal.Node root = new LevelOrderTraversal.Node(3);
    root.left = new LevelOrderTraversal.Node(9);
    root.right = new LevelOrderTraversal.Node(20);
    root.right.left = new LevelOrderTraversal.Node(15);
    root.right.right = new LevelOrderTraversal.Node(7);
    assertEquals(
        List.of(List.of(3), List.of(9, 20), List.of(15, 7)), LevelOrderTraversal.levelOrder(root));
  }

  @Test
  void returnsNoLevelsForEmptyTree() {
    assertEquals(List.of(), LevelOrderTraversal.levelOrder(null));
  }

  @Test
  void handlesSingleNode() {
    assertEquals(
        List.of(List.of(7)), LevelOrderTraversal.levelOrder(new LevelOrderTraversal.Node(7)));
  }

  @Test
  void handlesSkewedTreeWithDuplicateValues() {
    LevelOrderTraversal.Node root = new LevelOrderTraversal.Node(1);
    root.left = new LevelOrderTraversal.Node(1);
    root.left.right = new LevelOrderTraversal.Node(2);
    assertEquals(List.of(List.of(1), List.of(1), List.of(2)), LevelOrderTraversal.levelOrder(root));
  }
}
