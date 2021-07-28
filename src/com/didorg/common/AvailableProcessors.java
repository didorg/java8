package com.didorg.common;

public class AvailableProcessors {
  public static void main(String[] args) {
    int coreCount = Runtime.getRuntime().availableProcessors();

    System.out.println("coreCount = " + coreCount);
  }
}
