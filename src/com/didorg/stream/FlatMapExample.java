package com.didorg.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * API Note: -> docs.oracle.com The flatMap() operation has the effect of applying a one-to-many
 * transformation to the elements of the stream, and then flattening the resulting elements into a
 * new stream
 **/
public class FlatMapExample {
  public static void main(String[] args) {
    Student adam = new Student("Adam");
    adam.addBook("Java 8 in Action");
    adam.addBook("Spring Boot in Action");
    adam.addBook("Effective Java (2nd Edition)");

    Student jen = new Student("Jennifer");
    jen.addBook("Java Concurrency in practice ");
    jen.addBook("Effective Java (2nd Edition)");

    List<Student> students = Arrays.asList(adam, jen);

    // String books List from Students applying .distinct
    List<String> studentBooks = students.stream().map(e -> e.getBooks())// Stream<Set<String>>
        .flatMap(e -> e.stream())// Stream<String>
        .distinct()// Stream<String>
        .collect(Collectors.toList());
    // Lambda expresion
    // studentBooks.forEach(sBook -> System.out.println(sBook));
    // Method Reference
    studentBooks.forEach(System.out::println);
  }
}


class Student {
  private String name;
  private Set<String> books;

  public Student(String name) {
    this.name = name;
  }

  public void addBook(String book) {
    if (this.books == null) {
      this.books = new HashSet<>();
    }
    this.books.add(book);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<String> getBooks() {
    return books;
  }

  public void setBooks(Set<String> books) {
    this.books = books;
  }
}
