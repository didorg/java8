package com.didorg.stream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Different ways to create Streams - Stream.of(val1, val3, val3, ...) - Stream.of(arrayOfElements)
 * - List.stream()
 **/
public class StreamCreation {

  public static void main(String[] args) {
    streamFirstWay.forEach(v -> System.out.print("| " + v + " |"));
    System.out.println();
    streamSecondWay.forEach(v -> System.out.print("[ " + v + " ]"));
    System.out.println();
    streamThirdWay.forEach(v -> System.out.print("{ " + v + " }"));
  }

  // first
  static Stream<Integer> streamFirstWay = Stream.of(1, 2, 3, 4, 5);

  // Second
  static Stream<Integer> streamSecondWay = Stream.of(new Integer[] {1, 2, 3, 4, 5});

  // third
  static List<Integer> streamThirdWay = Arrays.asList(1, 2, 3, 4, 5);

}
