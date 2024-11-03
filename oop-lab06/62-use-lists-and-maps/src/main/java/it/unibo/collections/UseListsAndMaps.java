package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int FIRST = 1000;
    private static final int END = 2000;
    private static final int ELEMENTS = 100_000;
    private static final int READING = 1000;
    private static final long AFRICA_POPULATION= 1_110_635_000L;
    private static final long AMERICA_POPULATION= 972_005_000L;
    private static final long ANTARTICA_POPULATION= 0;
    private static final long EUROPE_POPULATION= 742_452_000L;
    private static final long OCEANIA_POPULATION= 38_304_000L;
    private static final long ASIA_POPULATION= 4_298_723_000L;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        
        
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final ArrayList <Integer> arrayList = new ArrayList < >();
        for (int i = FIRST; i < END; i++) {
            arrayList.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
        log(linkedList);
        
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temporary=arrayList.getFirst();
        arrayList.set(0, arrayList.getFirst());
        arrayList.set(arrayList.size()-1, temporary);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        final var build= new StringBuilder();
        for (final int i : arrayList) {
            build.append(i).append(", ");
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 0; i < ELEMENTS ; i++) {
            arrayList.addFirst(i);
        }
        time = System.nanoTime() - time;
        log("Time required for add 100000 elements as first element in ArrayList: "+ timeAsString(time));


        time= System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            linkedList.addFirst(i);
        }
        time=System.nanoTime()-time;
        log("Time required for add 100000 elements as first element in LinkedList: "+ timeAsString(time));

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time=System.nanoTime();
        for (int i = 0; i < READING; i++) {
            arrayList.get(arrayList.size()/2);
        }
        time=System.nanoTime()-time;
        log("Time required for reading 1000 times element in middle position of ArrayList"+ timeAsString(time));

        time=System.nanoTime();
        for (int i = 0; i < READING; i++) {
            linkedList.get(linkedList.size()/2);
        }
        time= System.nanoTime()-time;
        log("Time required for reading 1000 times element in middle position of LinkedList"+ timeAsString(time));
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String, Long> populationWorld= new HashMap<>();

        populationWorld.put("Africa", AFRICA_POPULATION);
        populationWorld.put("Americas", AMERICA_POPULATION);
        populationWorld.put("Antarctica", ANTARTICA_POPULATION);
        populationWorld.put("Asia", ASIA_POPULATION);
        populationWorld.put("Europe", EUROPE_POPULATION);
        populationWorld.put("Oceania", OCEANIA_POPULATION);
        /*
         * 8) Compute the population of the world
         */
        long totalWorldPopulation=0;
        for (final long population : populationWorld.values()) {
            totalWorldPopulation += population;
        }
        log("Population of the world: "+ totalWorldPopulation);
    }

    
    private static String timeAsString(long nanoseconds) {
        return nanoseconds + "ns";
    }

    private static void log(final Object message) {
        System.out.println(message);
    }
    
}
