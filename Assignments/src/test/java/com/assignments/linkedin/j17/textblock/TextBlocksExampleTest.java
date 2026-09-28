package com.assignments.linkedin.j17.textblock;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class TextBlocksExampleTest {
  @Test
  void testMainPrintsTextBlock() {
    // Capture System.out
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));
    try {
      TextBlocksExample.main(new String[] {});
    } finally {
      System.setOut(originalOut);
    }
    String output = outContent.toString();
    assertTrue(output.contains("This is a text block in Java 17."));
    assertTrue(output.contains("Indented text is also preserved."));
  }
}
