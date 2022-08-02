package com.nixsolutions.task5.collections;

import java.time.LocalDate;
import java.util.*;

public class CollectionTasks {

    public static void main(String[] args) {
        task17();
    }

    public static void task1() {
        Set<String> plants = new HashSet<>();
        plants.add("арбуз");
        plants.add("банан");
        plants.add("вишня");
        plants.add("груша");
        plants.add("дыня");
        plants.add("ежевика");
        plants.add("жень-шень");
        plants.add("земляника");
        plants.add("ирис");
        plants.add("картофель");

        for (String plant : plants) {
            System.out.println(plant);
        }
    }

    public static void task2() {
        Map<String, String> plantsMap = new HashMap<>();
        plantsMap.put("арбуз", "ягода");
        plantsMap.put("банан", "трава");
        plantsMap.put("вишя", "ягода");
        plantsMap.put("груша", "фрукт");
        plantsMap.put("дыня", "овощ");
        plantsMap.put("ежевика", "куст");
        plantsMap.put("жень-шень", "корень");
        plantsMap.put("земляника", "ягода");
        plantsMap.put("ирис", "цветок");
        plantsMap.put("картофель", "клубень");

        printMap(plantsMap);
    }

    public static void task3() {
        Map<String, Cat> catsMap = new HashMap<>();
        catsMap.put("Барсик", new Cat("Барсик"));
        catsMap.put("Барсик2", new Cat("Барсик2"));
        catsMap.put("Барсик3", new Cat("Барсик3"));
        catsMap.put("Барсик4", new Cat("Барсик4"));
        catsMap.put("Барсик5", new Cat("Барсик5"));
        catsMap.put("Барсик6", new Cat("Барсик6"));
        catsMap.put("Барсик7", new Cat("Барсик7"));
        catsMap.put("Барсик8", new Cat("Барсик8"));
        catsMap.put("Барсик9", new Cat("Барсик9"));
        catsMap.put("Барсик10", new Cat("Барсик10"));

        printMap(catsMap);
    }

    public static void task4() {
        Map<String, String> plantsMap = new HashMap<>();
        plantsMap.put("арбуз", "ягода");
        plantsMap.put("банан", "трава");
        plantsMap.put("вишя", "ягода");
        plantsMap.put("груша", "фрукт");
        plantsMap.put("дыня", "овощ");
        plantsMap.put("ежевика", "куст");
        plantsMap.put("жень-шень", "корень");
        plantsMap.put("земляника", "ягода");
        plantsMap.put("ирис", "цветок");
        plantsMap.put("картофель", "клубень");

        for (String entry : plantsMap.keySet()) {
            System.out.println(entry);
        }
    }

    public static void task5() {
        Map<String, String> plantsMap = new HashMap<>();
        plantsMap.put("арбуз", "ягода");
        plantsMap.put("банан", "трава");
        plantsMap.put("вишя", "ягода");
        plantsMap.put("груша", "фрукт");
        plantsMap.put("дыня", "овощ");
        plantsMap.put("ежевика", "куст");
        plantsMap.put("жень-шень", "корень");
        plantsMap.put("земляника", "ягода");
        plantsMap.put("ирис", "цветок");
        plantsMap.put("картофель", "клубень");

        for (String entry : plantsMap.values()) {
            System.out.println(entry);
        }
    }

    public static void task6() {
        Map<String, Object> catsMap = new HashMap<>();
        catsMap.put("Барсик", new Cat("Барсик"));
        catsMap.put("Барсик2", "gyugygy");
        catsMap.put("Барсик3", 5);
        catsMap.put("Барсик4", 1.5);
        catsMap.put("Барсик5", true);
        catsMap.put("Барсик6", 'a');
        catsMap.put("Барсик7", new LinkedList<>());
        catsMap.put("Барсик8", new ArrayList<>());
        catsMap.put("Барсик9", new HashMap<>());
        catsMap.put("Барсик10", new HashSet<>());

        printMap(catsMap);
    }

    public static void task7() {
        List<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("a1");
        stringArrayList.add("a2");
        stringArrayList.add("a3");
        stringArrayList.add("a4");
        stringArrayList.add("a5");

        System.out.println(stringArrayList.size());
        for (String element : stringArrayList) {
            System.out.println(element);
        }
    }

    public static void task8() {
        List<String> stringArrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи строку 5 раз: ");
        for (int i = 0; i < 5; i++) {
            stringArrayList.add(scanner.nextLine());
        }

        int maxStrLength = stringArrayList.get(0).length();

        for (String element : stringArrayList) {
            if (element.length() > maxStrLength) {
                maxStrLength = element.length();
            }
        }
        for (String element : stringArrayList) {
            if (element.length() == maxStrLength) {
                System.out.println(element);
            }
        }
    }

    public static void task9() {
        List<String> stringArrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи строку 5 раз: ");
        for (int i = 0; i < 5; i++) {
            stringArrayList.add(scanner.nextLine());
        }

        int minStrLength = stringArrayList.get(0).length();

        for (String element : stringArrayList) {
            if (element.length() < minStrLength) {
                minStrLength = element.length();
            }
        }
        for (String element : stringArrayList) {
            if (element.length() == minStrLength) {
                System.out.println(element);
            }
        }
    }

    public static void task10() {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи строку 10 раз: ");
        for (int i = 0; i < 10; i++) {
            list.add(0, scanner.nextLine());
        }

        for (String element : list) {
            System.out.println(element);
        }
    }

    public static void task11() {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи строку 5 раз: ");
        for (int i = 0; i < 5; i++) {
            list.add(scanner.nextLine());
        }

        for (int i = 0; i < 13; i++) {
            String x1 = list.get(list.size() - 1);
            list.add(0, x1);
            list.remove(list.size() - 1);
        }

        for (String element : list) {
            System.out.println(element);
        }
    }

    public static void task12() {
        Set<String> set = new HashSet<>();
        set.add("лаваш");
        set.add("лабиринт");
        set.add("лол");
        set.add("лел");
        set.add("лаборатория");
        set.add("лилия");
        set.add("лайк");
        set.add("лъл");
        set.add("ла");
        set.add("лу");
        set.add("лв");
        set.add("лев");
        set.add("лето");
        set.add("левша");
        set.add("лук");
        set.add("лид");
        set.add("лампа");
        set.add("лошадь");
        set.add("ликер");
        set.add("лолкек");
        //в чем смысл задания...
    }

    public static void task13() {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set.add(11);
        set.add(4);
        set.add(45);
        set.add(32);
        set.add(2);
        set.add(3);
        set.add(7);
        set.add(75);
        set.add(55);
        set.add(66);
        set.add(77);
        set.add(1);
        set.add(22);
        set.add(-17);
        set.add(9);
        set.add(5);
        set.add(53);
        set.add(-5);
        set.add(41);
        set.add(12);

        for (int element : set) {
            if (element > 10) {
                set2.add(element);
            }
        }

        set.removeAll(set2);

        for (int element : set) {
            System.out.println(element);
        }
    }

    public static void task14() {
        Map<String, String> map = new HashMap<>();

        map.put("Алексей", "Егоров");
        map.put("Владимир", "Павлов");
        map.put("Женя", "Иванов");
        map.put("Егор", "Смирнов");
        map.put("Кирилл", "Кузнецов");
        map.put("Саша", "Попов");
        map.put("Артём", "Васильев");
        map.put("Валера", "Петров");
        map.put("Максим", "Соколов");
        map.put("Макс", "Петров");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи имя : ");
        String firstName = scanner.nextLine();
        System.out.println("Введи фамилию: ");
        String lastName = scanner.nextLine();
        int countFirstName = 0;
        int countLastName = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(firstName)) {
                countFirstName++;
            }

            if (entry.getValue().equals(lastName)) {
                countLastName++;
            }
        }
        System.out.println("Совпадений имен: " + countFirstName);
        System.out.println("Совпадений фамилий: " + countLastName);
    }

    public static void task15() {
        Map<String, LocalDate> map = new HashMap<>();
        List<String> removeKeys = new ArrayList<>();

        map.put("Егоров", LocalDate.of(2001, 7, 19));
        map.put("Павлов", LocalDate.of(2002, 1, 1));
        map.put("Иванов", LocalDate.of(2003, 3, 2));
        map.put("Смирнов", LocalDate.of(2001, 8, 13));
        map.put("Кузнецов", LocalDate.of(2006, 6, 14));
        map.put("Попов", LocalDate.of(1982, 12, 29));
        map.put("Васильев", LocalDate.of(1987, 11, 23));
        map.put("Семенов", LocalDate.of(1945, 9, 21));
        map.put("Соколов", LocalDate.of(1973, 5, 16));
        map.put("Петров", LocalDate.of(1999, 7, 3));

        for (Map.Entry<String, LocalDate> entry : map.entrySet()) {
            LocalDate value = entry.getValue();
            int monthValue = value.getMonthValue();
            if (monthValue == 6 || monthValue == 7 || monthValue == 8) {
                removeKeys.add(entry.getKey());
            }
        }
        for (String removeKey : removeKeys) {
            map.remove(removeKey);
        }
        printMap(map);
    }

    public static void task16() {
        Map<String, String> map = new HashMap<>();

        map.put("Егоров", "Алексей");
        map.put("Павлов", "Владимир");
        map.put("Иванов", "Женя");
        map.put("Смирнов", "Егор");
        map.put("Кузнецов", "Саша");
        map.put("Попов", "Саша");
        map.put("Васильев", "Артём");
        map.put("Петрова", "Валерия");
        map.put("Соколов", "Макс");
        map.put("Петров", "Макс");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        Set<String> removeKeys = new HashSet<>();
        for (Map.Entry<String, String> entry1 : entries) {
            String key1 = entry1.getKey();
            String value1 = entry1.getValue();
            for (Map.Entry<String, String> entry2 : entries) {
                String key2 = entry2.getKey();
                String value2 = entry2.getValue();
                if (value1.equals(value2) && !key1.equals(key2)) {
                    removeKeys.add(key1);
                    removeKeys.add(key2);
                }
            }
        }
        for (String removeKey : removeKeys) {
            map.remove(removeKey);
        }
        printMap(map);
    }

    public static void task17() {
        Map<String, String> map = new HashMap<>();

        map.put("Егоров", "Алексей");
        map.put("Павлов", "Владимир");
        map.put("Иванов", "Женя");
        map.put("Соколов", "Егор");
        map.put("Кузнецов", "Саша");
        map.put("Петров", "Саша");
        map.put("Васильев", "Артём");
        map.put("Петрова", "Валерия");
        map.put("Соколов", "Макс");
        map.put("Петров", "Макс");

        printMap(map);

    }


    private static void printMap(Map<?, ?> map) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
