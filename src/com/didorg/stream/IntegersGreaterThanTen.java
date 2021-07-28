package com.didorg.stream;

import java.util.Arrays;
import java.util.List;

// Find out sum of all the integers greater than 10
public class IntegersGreaterThanTen {

  private static List<Integer> ints = Arrays.asList(1, 34, 6, 16, 5);

  public static int sum(List<Integer> intsParam) {
    return intsParam.stream().filter(i -> i > 10).mapToInt(i -> i).sum();
  }


  public static void main(String[] args) {
    System.out.println("The sum of all the integers greater than 10 is = " + sum(ints));
  }

}
