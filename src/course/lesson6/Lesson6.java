package course.lesson6;

import static packAlternative.AOutput.consoleOut;

public class Lesson6 {
    public static void main(String[] args) {

// 1) Сделать свой HashMap
        HashArray<String, String> test = new HashArray<>();

        test.put("hashKeyOne", "HashMapOne");
        test.put("التجزئةمفتاحاثنين", "HashMapTwo");
        test.put("מפתחשני", "HashMapThree");
        consoleOut.println(test.get("hashKeyOne"));
        consoleOut.println(test.get("التجزئةمفتاحاثنين"));
        consoleOut.println(test.get("מפתחשני"));
        /*
            Данная HashTable реализована на основе массива LinkedList'ов
          На вход подаётся пара ключ-значение где уникальный hashCode()
          ключа является индексом массива
        */

        test.put("AaAaAa", "hashKeyCollision(2/2)");
        test.put("AaAaBB", "hashKeyCollision(1/2)");
        consoleOut.println(test.get("AaAaBB"));
        consoleOut.println(test.get("AaAaAa"));
        /*
            Так же рассмотрены и обработаны коллизии.
          При совпадении hashCode() в список добавляется еще одна нода
          и в дальнейшем значение ищется по эквивалентности значения ключейключей
        */

        consoleOut.println(" ");

// 2) сделать Бинарное дерево поиска, так же с HashKey

        MyTreeMap<String, String> treeTest = new MyTreeMap<>();

        treeTest.add("treeKeyOne", "TreeMapOne");
        treeTest.add("treeKeyTwo", "TreeMapTwo");
        treeTest.add("treeKeyThree", "TreeMapThree");
        consoleOut.println(treeTest.get("treeKeyOne"));
        consoleOut.println(treeTest.get("treeKeyTwo"));
        consoleOut.println(treeTest.get("treeKeyThree"));

        treeTest.add("AaAaBB", "treeMapCollision(1/2)");
        treeTest.add("AaAaAa", "treeMapCollision(2/2)");
        consoleOut.println(treeTest.get("AaAaBB"));
        consoleOut.println(treeTest.get("AaAaAa"));
    }
}