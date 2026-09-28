package com.assignments.infyprep;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  private static final class Node {
    final int key;
    int value;
    Node previous;
    Node next;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private final int capacity;
  private final Map<Integer, Node> entries = new HashMap<>();
  private final Node head = new Node(0, 0); // Most recently used end.
  private final Node tail = new Node(0, 0); // Least recently used end.

  // HashMap + doubly linked list: expected O(1) get/put, O(capacity) space.
  // Single-threaded cache. Zero capacity is allowed and stores nothing.
  public LRUCache(int capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("Capacity must be nonnegative");
    }
    this.capacity = capacity;
    head.next = tail;
    tail.previous = head;
  }

  public int get(int key) {
    Node node = entries.get(key);
    if (node == null) {
      return -1; // Conventional missing-value sentinel.
    }
    remove(node);
    addFirst(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }
    Node node = entries.get(key);
    if (node != null) {
      node.value = value;
      remove(node);
      addFirst(node);
      return;
    }
    if (entries.size() == capacity) {
      Node oldest = tail.previous;
      remove(oldest);
      entries.remove(oldest.key);
    }
    node = new Node(key, value);
    entries.put(key, node);
    addFirst(node);
  }

  private void remove(Node node) {
    node.previous.next = node.next;
    node.next.previous = node.previous;
  }

  private void addFirst(Node node) {
    node.previous = head;
    node.next = head.next;
    head.next.previous = node;
    head.next = node;
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
    cache.put(1, 10);
    cache.put(2, 20);
    System.out.println("get(1) -> " + cache.get(1) + " (expected: 10)");
    cache.put(3, 30); // Key 2 was least recently used.
    System.out.println("get(2) after put(3,30) -> " + cache.get(2) + " (expected: -1)");
    cache.put(1, 15);
    cache.put(4, 40); // Updating key 1 refreshed its recency; evict key 3.
    System.out.println("get(3) after put(4,40) -> " + cache.get(3) + " (expected: -1)");
    System.out.println("get(1) after update -> " + cache.get(1) + " (expected: 15)");
    System.out.println("get(4) -> " + cache.get(4) + " (expected: 40)");
  }
}
