package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Random;
import org.junit.jupiter.api.Test;

class LRUCacheTest {
  @Test
  void getRefreshesRecencyBeforeEviction() {
    LRUCache cache = new LRUCache(2);
    cache.put(1, 10);
    cache.put(2, 20);
    assertEquals(10, cache.get(1));
    cache.put(3, 30);
    assertEquals(-1, cache.get(2));
    assertEquals(10, cache.get(1));
    assertEquals(30, cache.get(3));
  }

  @Test
  void updatingExistingKeyRefreshesRecencyWithoutEvictingAnotherKey() {
    LRUCache cache = new LRUCache(2);
    cache.put(1, 10);
    cache.put(2, 20);
    cache.put(1, 15);
    cache.put(3, 30);
    assertEquals(-1, cache.get(2));
    assertEquals(15, cache.get(1));
    assertEquals(30, cache.get(3));
  }

  @Test
  void missingLookupDoesNotChangeRecency() {
    LRUCache cache = new LRUCache(2);
    cache.put(1, 10);
    cache.put(2, 20);
    assertEquals(-1, cache.get(99));
    cache.put(3, 30);
    assertEquals(-1, cache.get(1));
    assertEquals(20, cache.get(2));
  }

  @Test
  void supportsZeroAndSingleEntryCapacities() {
    LRUCache empty = new LRUCache(0);
    empty.put(1, 10);
    assertEquals(-1, empty.get(1));
    LRUCache single = new LRUCache(1);
    single.put(-1, 0);
    assertEquals(0, single.get(-1));
    single.put(2, 20);
    assertEquals(-1, single.get(-1));
    assertEquals(20, single.get(2));
  }

  @Test
  void rejectsNegativeCapacity() {
    assertThrows(IllegalArgumentException.class, () -> new LRUCache(-1));
  }

  @Test
  void matchesAccessOrderedMapForMixedOperations() {
    Random random = new Random(45);
    for (int capacity = 0; capacity <= 5; capacity++) {
      LRUCache cache = new LRUCache(capacity);
      LinkedHashMap<Integer, Integer> reference = new LinkedHashMap<>(16, 0.75f, true);
      for (int step = 0; step < 300; step++) {
        int key = random.nextInt(10);
        if (random.nextBoolean()) {
          int value = random.nextInt(100);
          cache.put(key, value);
          reference.put(key, value);
          if (reference.size() > capacity) reference.remove(reference.keySet().iterator().next());
        } else {
          assertEquals(
              reference.getOrDefault(key, -1).intValue(),
              cache.get(key),
              "Capacity " + capacity + ", step " + step);
        }
      }
    }
  }
}
