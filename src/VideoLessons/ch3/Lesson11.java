//Урок 11. Обобщённые классы и методы
//          Создайте класс Shop с обобщённым типом данных (один параметр).
//          Добавьте поле с массивом с обобщённым типом (то есть, это может быть, как
//        массив целых чисел, так и массив из строк).
//          Создайте конструктор, принимающий этот массив и записывающий его в поле.
//        Разумеется, метод принимать должен так же обобщённый тип данных.
//          Создайте метод printObject(), который выведет в консоль всё поле.
//          Создайте объект и запишите в него массив целых чисел (для примера, пусть
//        это будут id товаров в магазине).
//          Создайте ещё один объект и запишите в него массив строк (для примера,
//        пусть это будут названия товаров в магазине).
//          Вызовите у обоих объектов метод printObject().

package VideoLessons.ch3;

class Shop<SimpleArr> {
    private SimpleArr[] testArr;

    Shop(int size) {
        testArr = (SimpleArr[]) new Object[size];

    }

    void fillNum(SimpleArr x, SimpleArr y, SimpleArr z) {
        testArr[0] = x;
        testArr[1] = y;
        testArr[2] = z;
    }

    void printObject() {
        for (SimpleArr show : testArr) {
            System.out.println(show);
        }
    }
}

public class Lesson11 {
    public static void main(String[] args) {

        Shop<Integer> sh1 = new Shop<>(3);
        Shop<String> sh2 = new Shop<>(3);

        sh1.fillNum(2243, 5584, 8897);
        sh2.fillNum("Blender", "Plates", "Shores");


        sh1.printObject();
        sh2.printObject();


    }
}
