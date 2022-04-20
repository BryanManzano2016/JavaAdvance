package org.bmanzano;

import org.bmanzano.javaLibraries.Collections;
import org.bmanzano.libraries.GuavaLib;

public class Main {
    public static void main(String[] args) {
        testingLambdas();
        testingGuava();
    }

    private static void testingLambdas() {
        Collections collections = new Collections();
        collections.list();
        collections.maps();
    }

    private static void testingGuava() {
        GuavaLib guavaLib = new GuavaLib();
        guavaLib.testingMapRange();
        guavaLib.testingMultiSet();
        guavaLib.testingBiMap();
        guavaLib.queues();
    }
}