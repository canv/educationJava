package course.lesson6;

import static packAlternative.AOutput.consoleOut;

public class Lesson6 {
    public static void main(String[] args) {

// 2) Сделать свой HashMap
        HashArray<String,String> test = new HashArray<>();

        test.put("1", "testOne");
        test.put("test2", "testTwo");
        test.put("123", "testThree");
        consoleOut.println(test.get("1"));
        consoleOut.println(test.get("test2"));
        consoleOut.println(test.get("123"));
        /*
            Данная HashTable реализована на основе массива LinkedDist'ов
          На вход подаётся пара ключ-значение где уникальный hashCode()
          ключа является индексом массива
        */

        test.put("AaAaBB", "testCollision1");
        test.put("AaAaAa", "testCollision2");
        consoleOut.println(test.get("AaAaBB"));
        consoleOut.println(test.get("AaAaAa"));
        /*
            Так же рассмотрены и обработаны коллизии.
          При совпадении hashCode() в список добавляется еще одна нода
          и в дальнейшем значение ищется по эквивалентности значения ключейключей
        */

// 1) сделать двусвязный список где у каждой ноды свой HashKey
// 3) сделать Бинарное дерево поиска так же с HashKey
    }
}