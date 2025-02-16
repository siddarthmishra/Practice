package com.java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class RandomWords {
  private final List<String> sourceWords;

  /**
   * Constructor
   * 
   * @throws IOException If the source words file cannot be read
   */
  public RandomWords() throws IOException {
	try(BufferedReader reader = Files.newBufferedReader(Paths.get("words"))) {
		sourceWords = reader.lines().collect(Collectors.toList());
		System.out.println(sourceWords.size());
	}
  }

  /**
   * Create a list of a given size containing random words
   *
   * @param newListSize The size of the list to create
   * @return The created list
   */
  public List<String> createList(int newListSize) {
	  Random random = new Random();
	  return random.ints(newListSize, 0, sourceWords.size()).mapToObj(sourceWords::get).collect(Collectors.toList());
  }

  /**
   * Return the list of all source words, which cannot be modified
   *
   * @return The unmodifiable list of all source words
   */
  public List<String> allWords() {
    return Collections.unmodifiableList(sourceWords);
  }
  
  public static void main(String[] args) throws IOException {
	  RandomWords randomWords = new RandomWords();
	  // System.out.println(randomWords.allWords());
	  System.out.println(randomWords.createList(10));
  }
}
