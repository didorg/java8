package com.didorg.stream.streamsInAction;

public class Transaction{

  public static final String GROCERY = "Grocery";

  private Integer id;
  private Trader trader;
  private String type;
  private int year;
  private int value;

  public Transaction(Integer id, Trader trader, String type, int year, int value) {
    this.id = id;
    this.trader = trader;
    this.type = type;
    this.year = year;
    this.value = value;
  }

  public Integer getId() {
    return id;
  }

  public Transaction(Integer id) {
    this.id = id;
  }

  public Trader getTrader() {
    return trader;
  }

  public void setTrader(Trader trader) {
    this.trader = trader;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "Transaction{" +
        "trader=" + trader +
        ", type='" + type + '\'' +
        ", year=" + year +
        ", value=" + value +
        '}';
  }
}
