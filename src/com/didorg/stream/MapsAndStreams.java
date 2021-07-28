package com.didorg.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// Working With Maps Using Streams
public class MapsAndStreams {

  public static void main(String[] args) {

    Map<String, String> books = new HashMap<>();
    books.put("978-0201633610", "Design patterns : elements of reusable object-oriented software");
    books.put("978-1617291999",
        "Java 8 in Action: Lambdas, Streams, and functional-style programming");
    books.put("978-0134685991", "Effective Java");
    books.put("978-0321356680", "Effective Java: Second Edition");

    Optional<String> optionalIsbn = isbnBook(books);
    System.out.println("optionalIsbn = " + optionalIsbn.get());
    System.out.println("allBooksWithCondition(books) = " + allBooksWithCondition(books));
    System.out.println("getMapValues(books) = " + getMapValues(books));

  }

  // Retrieving a Match
  /**
   * We are interested in finding the ISBN for the book with the title “Effective Java”. Used an
   * Optional to express that the book title could not exist in our Map.
   **/
  private static Optional<String> isbnBook(Map<String, String> books) {

    Optional<String> optionalIsbn = books.entrySet().stream()
        .filter(e -> "Effective Java".equals(e.getValue())).map(Map.Entry::getKey).findFirst();

    return optionalIsbn;
  }

  // Retrieving Multiple Results
  /**
   * Now if we look for all books that start with “Effective Java”, we’ll get more than one result
   * back:
   */
  private static List<String> allBooksWithCondition(Map<String, String> books) {

    List<String> isbnCodes =
        books.entrySet().stream().filter(e -> e.getValue().startsWith("Effective Java"))
            .map(Map.Entry::getKey).collect(Collectors.toList());

    return isbnCodes;
  }

  // Getting a Map‘s Values
  /** We want to find titles for which their ISBN start with “978-0”. */
  private static List<String> getMapValues(Map<String, String> books) {

    List<String> titles = books.entrySet().stream().filter(e -> e.getKey().startsWith("978-0"))
        .map(Map.Entry::getValue).collect(Collectors.toList());

    return titles;
  }
}
