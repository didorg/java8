package com.didorg.functionalInterface;

import com.didorg.common.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionalInterface {
    public static void main(String[] args) {
        List<Person> people =
                Arrays.asList(new Person("Didi", "Roq", 34), new Person("Lisi", "Glez", 32),
                        new Person("Tony", "Ton", 33), new Person("Mariela", "cep", 32),
                        new Person("Adam", "Le", 40), new Person("Gabriela", "Lopez", 38));

        // Predicate ---------------------------------------------------------------------
        /**
         * public interface Predicate<T>{ boolean test(T t); }
         **/// Predicate Joining - And, Or, Negate
        Predicate<Person> predicateAge = p -> p.getAge() <= 32;
        Predicate<Person> predicateLength = p -> p.getFirstName().length() <= 5;
        List<Person> usingPredicate =
                people.stream().filter(predicateAge.and(predicateLength)).collect(Collectors.toList());

        // Consumer ------------------------------------------------------------------------
        /**
         * public interface Consumer<T>{ void accept(T t); }
         **/
        Consumer<Person> consumer = System.out::println;
        usingPredicate.forEach(consumer);

        // Supplier ------------------------------------------------------------------------
        /**
         * public interface Supplier<T>{ T get(); }
         **/
        Supplier<Double> random = Math::random;
        System.out.println(random.get());

        // Function ------------------------------------------------------------------------
        /**
         * public interface Function<T, R>{ R apply(T t); }
         **/
        Function<Person, Integer> function = p -> p.getAge() + 1;
        List<Integer> ages = people.stream().map(function).collect(Collectors.toList());
        System.out.println(ages);
    }
}
