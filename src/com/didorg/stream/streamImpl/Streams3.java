package com.didorg.stream.streamImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Streams3 {

    public static final int MAX = 1000000;

    public static void main(String[] args) {
        List<String> values = new ArrayList<>(MAX);
        for (int i = 0; i < MAX; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        countSequential(values);
        countParallel(values);
    }

    public static void countSequential(List<String> values) {
        long t0 = System.currentTimeMillis();
        //long count = values.size();
        long count = values.stream().count();
        System.out.println(count);
        long t1 = System.currentTimeMillis();

        System.out.printf("sequential took: %d ms%n", t1-t0);
    }

    public static void countParallel(List<String> values) {
        long t0 = System.currentTimeMillis();
        long count = values.parallelStream().count();
        System.out.println(count);
        long t1 = System.currentTimeMillis();

        System.out.printf("parallel took: %d ms%n", t1-t0);
    }
}
