package lesson2_3;

import java.util.Random;
import java.util.TreeMap;

public class HomeWork3 {

    public static void main(String[] args) {

        String[] words = new String[10];

        words[0] = "abc";
        words[1] = "123";
        words[2] = "qwerty";
        words[3] = "abcde";
        words[4] = "abcde";
        words[5] = "124";
        words[6] = "123";
        words[7] = "qwerty";
        words[8] = "zyxw";
        words[9] = "sfdfas";

        findDuplicates(words);

        PhoneNumbersList phoneList = new PhoneNumbersList();

        phoneList.add("Ivan", getPhoneNumber());
        phoneList.add("Ivan", getPhoneNumber());
        phoneList.add("Ivan", getPhoneNumber());
        phoneList.add("Petr", getPhoneNumber());
        phoneList.add("Vasiliy", getPhoneNumber());
        phoneList.add("Pavel", getPhoneNumber());
        phoneList.add("Semen", getPhoneNumber());

        System.out.println(phoneList.get("Ivan"));
        System.out.println(phoneList.get("Boris"));
        System.out.println(phoneList.get("Petr"));
        System.out.println(phoneList.get("Vasiliy"));
        System.out.println(phoneList.get("Pavel"));

    }

    public static void findDuplicates(String[] array){

        TreeMap<String, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i< array.length; i++) {
            if (treeMap.containsKey(array[i])) {
                treeMap.put(array[i], treeMap.get(array[i])+1);
            } else {
                treeMap.put(array[i], 1);
            }
        }
        System.out.println(treeMap);
    }

    public static long getPhoneNumber () {
        Random random = new Random();
        String phone = "8916" + Integer.toString(random.nextInt(9999999));
        long phoneNumber = Long.parseLong(phone);
        return phoneNumber;
    }
}