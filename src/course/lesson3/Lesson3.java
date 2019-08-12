package course.lesson3;

import static packAlternative.AOutput.consoleOut;

class Human{
    private String nickname;
    private int health;
    private int manna;

    Human withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }
    Human withHealth(int health) {
        this.health = health;
        return this;
    }
    Human withManna(int manna) {
        this.manna = manna;
        return this;
    }

    @Override
    public String toString() {
        return "Human{" +
                "nickname='" + nickname + '\'' +
                ", health=" + health +
                ", manna=" + manna +
                '}';
    }
    public boolean equals(Human obj) {
        return (this.nickname == obj.nickname
                && this.health == obj.health
                && this.manna == obj.manna );
    }
}

public class Lesson3 {
    public static void main(String[] args) {
        Human warrior = new Human()
                .withNickname("TAN41K")
                .withHealth(15)
                .withManna(0);

        Human warriorCopy = new Human()
                .withNickname("TAN41K")
                .withHealth(15)
                .withManna(0);

        Human mage1 = new Human()
                .withNickname("YOLO")
                .withHealth(6)
                .withManna(22);



// 1) Отобразить информацию о классе через консольный вывод
        consoleOut.println(warrior);
        consoleOut.println(mage1);
        /*
            Отображение возможно благодаря переопределению метода toString
        */

// 2) Почему (warrior == warriorCopy) false? Хотя на вид они одинаковые.
        consoleOut.println(warrior == warriorCopy);
        consoleOut.println(warrior.equals(warriorCopy));
        /*
            Потому что оператор '==' сравнивает только ссылки на объекты
          Для корректного сравнения разроботчик сам должен решить какие
          данные в объекте должны сравниватся между собой, а какие нет.
            В нашем случае для нас достаточно сравнение полей 'nickname',
          'health' и 'manna' для общего вывода об эквивалентности объектов
          и поэтому мы можем переопределить метод equals() и воспользоватся
          им при сравнении.
        */

// 3) Сделать структуру односвязного списка LinkedList
//      сделать метод add() и get(по индексу)

        MyLinkedList<Human> army = new MyLinkedList<>();

        army.addElement(warrior);
        army.addElement(warriorCopy);
        army.addElement(mage1);

        consoleOut.println(army.getElement(2));
        consoleOut.println(army.getElement(1));
        consoleOut.println(army.getElement(0));
    }
}