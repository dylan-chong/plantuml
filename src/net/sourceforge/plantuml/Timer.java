package net.sourceforge.plantuml;

import java.util.HashMap;
import java.util.Map;

class Timer {
    private Map<String, Long> times = new HashMap<String, Long>();
    private long startTime;
    private String name;

    public void start(String name) {
        this.name = name;
        this.startTime = System.currentTimeMillis();
    }

    public void end() {
        long time = System.currentTimeMillis() - startTime;
        times.put(name, time);
        System.out.printf("%s: %d\n", name, time);
        name = null;
    }
}
