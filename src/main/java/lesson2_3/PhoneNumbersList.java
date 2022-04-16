package lesson2_3;

import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneNumbersList {

    private TreeMap<String, TreeSet<Long>> treeMap;

    public PhoneNumbersList() {
        treeMap = new TreeMap<>();
    }

    public void add(String name, long phoneNumber) {
        if(treeMap.containsKey(name)) {
            treeMap.get(name).add(phoneNumber);
        } else {
            TreeSet<Long> treeSet = new TreeSet<>();
            treeSet.add(phoneNumber);
            treeMap.put(name, treeSet);
        }
    }

    public String get(String name) {
        if (treeMap.containsKey(name)) {
            return treeMap.get(name).toString();
        } else {
            return "phone number is absent";
        }
    }
}
