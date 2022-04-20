package org.bmanzano.libraries;

import com.google.common.collect.*;

import java.util.Comparator;
import java.util.Queue;
import java.util.stream.IntStream;

public class GuavaLib {

    public void testingMapRange() {
        System.out.println(">TreeRangeMap");
        RangeMap<Integer, String> maps = TreeRangeMap.create();
        maps.put(Range.closed(0, 2), "Associate");
        maps.put(Range.closed(3, 5), "Senior Associate");
        maps.put(Range.closed(6, 8), "Vice President");
        maps.put(Range.closed(9, 15), "Executive Director");
        System.out.println(maps.get(10));
        maps.remove(Range.closed(10, 14));
        System.out.println(maps);

        System.out.println(maps.span());
    }

    public void testingMultiSet() {
        Multiset<String> bookStore = HashMultiset.create();
        bookStore.add("Potter");
        bookStore.add("Potter");
        bookStore.add("Potter");

        bookStore.add("Harry");
        bookStore.add("Harry");

        bookStore.add("Parker");
        System.out.println(bookStore);
        System.out.println(bookStore.contains("Harry"));
        System.out.println(bookStore.count("Harry"));
        bookStore.setCount("Parker", 4);
        System.out.println(bookStore);
    }

    public void testingBiMap() {
        BiMap<String, String> capitalCountryBiMap = HashBiMap.create();
        capitalCountryBiMap.put("New Delhi", "India");
        capitalCountryBiMap.put("Washington, D.C.", "USA");
        capitalCountryBiMap.put("Moscow", "Russia");

        String keyFromBiMap = capitalCountryBiMap.inverse().get("Russia");
        String valueFromBiMap = capitalCountryBiMap.get("Washington, D.C.");

        System.out.println(keyFromBiMap);
        System.out.println(valueFromBiMap);
    }

    public void queues() {
        Queue<Integer> evictingQueue = EvictingQueue.create(10);
        IntStream.range(0, 100).forEach(evictingQueue::add);

        System.out.println("evictingQueue");
        System.out.println(evictingQueue);



        MinMaxPriorityQueue<CustomElement> queue = MinMaxPriorityQueue
                .orderedBy(Comparator.comparing(CustomElement::getValue).reversed())
                .maximumSize(3)
                .create();

        IntStream
            .iterate(0, i -> i + 1).limit(6)
            .forEach(i -> {
                System.out.println("i:" + i);
                queue.add(new CustomElement(i));
            });
        System.out.println("MinMaxPriorityQueue");
        System.out.println(queue);
        System.out.println(queue.peekFirst().getValue());
        System.out.println(queue.peekLast().getValue());
        queue.add(new CustomElement(100));
        System.out.println(queue);
        queue.add(new CustomElement(101));
        queue.add(new CustomElement(102));
        System.out.println(queue);
        queue.add(new CustomElement(-100));
        queue.add(new CustomElement(-101));
        System.out.println(queue);
        queue.poll();
        queue.poll();
        queue.add(new CustomElement(103));
        queue.add(new CustomElement(104));
        System.out.println(queue);
        System.out.println(queue.peekFirst().getValue());
        System.out.println(queue.peekLast().getValue());
    }
}
