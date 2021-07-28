package com.didorg.stream.streamsInAction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class StreamsClient {

  public static void main(String[] args) {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
        new Transaction(123, brian, "Grocery", 2011, 300),
        new Transaction(543, raoul, "Payment", 2012, 1000),
        new Transaction(87, raoul, "Grocery", 2011, 400),
        new Transaction(76, mario, "Dining", 2012, 710),
        new Transaction(5, mario, "Grocery", 2012, 700),
        new Transaction(9, alan, "Payment", 2012, 950)
    );

    // Find all transactions of type grocery and return a list of transaction IDs sorted in decreasing order of transaction value
    List<Integer> transactionsIds =
        transactions.parallelStream()
            .filter(t -> t.getType() == Transaction.GROCERY)
            .sorted(Comparator.comparing(Transaction::getValue).reversed())
            .map(Transaction::getId)
            .collect(Collectors.toList());
    System.out.println(transactionsIds);

    // Find all transaction of type Grocery, value higher than 300 and return a list of name
    List<String> names = transactions.stream()
        .filter(t -> Transaction.GROCERY.equalsIgnoreCase(t.getType()) && t.getValue() > 300)
        .map(t -> t.getTrader().getName())
        .collect(Collectors.toList());

    System.out.println(names);

  }
}
