package org.bmanzano.javaLibraries;

import java.util.*;
import java.util.stream.Stream;

public class Collections {

    public void list() {
        List<String> list1 = Arrays.asList("this", "is", "test", "is", null, "");
        System.out.println(">lista " + list1);

        List<String> list2 = list1.stream().distinct().toList();
        System.out.println(">distinct (equals)");
        System.out.println(list2.toString());

        List<List<String>> list3 = new ArrayList<>();
        list3.add(Arrays.asList("a1", "b1", "c1", "d1"));
        list3.add(Arrays.asList("b2", "a2", "d2", "c2"));
        list3.add(Arrays.asList("d3", "c3", "b3", "a3"));
        System.out.println(">flatMap");
        System.out.println(list3);
        List<String> list4 = list3.stream().map(Collection::stream).flatMap(Stream::sorted).
                toList();
        System.out.println(list4);

        List<String> list5 = list1.stream().skip(3).toList();
        System.out.println(">skip");
        System.out.println(list1);
        System.out.println(list5);

        List<String> list6 = list1.stream().takeWhile(Objects::nonNull).toList();
        System.out.println(">takeWhile");
        System.out.println(list1);
        System.out.println(list6);
    }

    public void maps() {
        Map<String, String> map1 = new HashMap<>();
        map1.computeIfAbsent("k1", s -> "v1");
        map1.computeIfAbsent("k2", s -> "v2");
        map1.computeIfAbsent("k2", s -> "v2_1");
        map1.computeIfPresent("k1", (s, s2) -> "v1_1");
        System.out.println(">computeIfAbsent | computeIfPresent");
        System.out.println(map1);

        System.out.println(">computeIfAbsent case 2");
        map1.computeIfPresent("k1", (key, val) -> val.concat("_@"));
        System.out.println(map1);

        System.out.println(">getOrDefault case 2");
        System.out.println(map1.getOrDefault("k2", "500"));
        System.out.println(map1.getOrDefault("k3", "600"));

        System.out.println(">merge");
        Map<String, String> map2 = new HashMap<>();
        map2.computeIfAbsent("k1", s -> "v1_");
        map2.computeIfAbsent("k2", s -> "v2");

        Map<String, String> map3 = new HashMap<>();
        map3.computeIfAbsent("k1", s -> "v1");
        map3.computeIfAbsent("k3", s -> "v3");

        map2.forEach((key, value) ->
                map3.merge(key, value, (v1, v2) -> v1));
        System.out.println(map3);
    }
}
