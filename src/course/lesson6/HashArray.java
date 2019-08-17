package course.lesson6;

import static packAlternative.AOutput.consoleOut;

class MyHashMap {
    private static final int SIZE = 1000000;

    private Entry[] table = new Entry[SIZE];


    public void put(String key, String val) {
        int hash = key.hashCode() % SIZE;
        Entry e = table[hash];

        if (e != null) {
            if (e.key.equals(key)) {
                e.value = val;
            } else {
                while (e.next != null) {
                    e = e.next;
                }
                e.next = new Entry(key, val);
            }
        } else {
            Entry entryInNewBucket = new Entry(key, val);
            table[hash] = entryInNewBucket;
        }
    }


    public Entry get(String key) {
        int hash = key.hashCode() % SIZE;
        Entry e = table[hash];

        while (e != null) {
            if (e.key.equals(key)) {
                return e;
            }
            e = e.next;
        }
        return null;
    }
}

class Entry {
    final String key;
    String value;
    Entry next;

    Entry(String key, String val) {
        this.key = key;
        value = val;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

//    public String getKey() {
//        return key;
//    }

//        @Override
//        public String toString() {
//            return "Entry{" +
//                    "key='" + key + '\'' +
//                    ", value='" + value + '\'' +
//                    '}';
//        }
}

    public class HashArray {
        public static void main(String[] args) {

            MyHashMap test = new MyHashMap();


            test.put("test1","testOne");
            test.put("test2","testTwo");
            test.put("test3","testThree");

            Entry e = test.get("test2");

            consoleOut.println(e.getValue());


        }
    }
