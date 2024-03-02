package org.padulano.fabrizio.algorithms.binarysearch;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    https://leetcode.com/problems/time-based-key-value-store/
 */
public class TimeBasedKeyValueStore {
    Map<String, List<Pair<Integer, String>>> map;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new ImmutablePair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        var list = map.get(key);
        int l = 0, r = list.size() - 1;

        String val = "";
        while(l <= r) {
            if(timestamp < list.get(l).getKey()) return val;
            int m = (l+r)/2;
            var el = list.get(m);

            if(el.getKey() == timestamp) return el.getValue();

            if(el.getKey() < timestamp) {
                val = el.getValue();
                l = m + 1;
            } else r = m - 1;
        }

        return val;
    }
}
