/**
 * 
 */
package com.learnvertx;

/**
 *<Description>
 * 
 * @author Somendu Maiti
 *
 * @since 12-Mar-2024
 */
public class ReverseSentence {

	  public static String reverseSentence(String sentence) {
	    String[] words = sentence.split(" "); // Split the sentence into words
	    StringBuilder reversedSentence = new StringBuilder();

	    for (int i = words.length - 1; i >= 0; i--) {
	      reversedSentence.append(words[i]).append(" ");
	    }

	    return reversedSentence.toString().trim(); // Remove trailing space
	  }

	  public static void main(String[] args) {
	    String sentence = "Hello world, how are you?";
	    String reversedSentence = reverseSentence(sentence);
	    System.out.println("Original sentence: " + sentence);
	    System.out.println("Reversed sentence: " + reversedSentence);
	  }
	}
