package course.lesson4;

import static packAlternative.AOutput.consoleOut;

class VitoChildren {
    private String firstName;
    private String secondName;
    private String yearsOfLife;

    VitoChildren withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    VitoChildren witSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }
    VitoChildren withYearsOfLife(String yearsOfLife) {
        this.yearsOfLife = yearsOfLife;
        return this;
    }

    @Override
    public String toString() {
        return "\nVitoChildren" +
                "\n\t{firstName='" + firstName + '\''+ "," +
                "\n\tsecondName='" + secondName + '\'' + "," +
                "\n\tyearsOfLife='" + yearsOfLife +'\'' + '}';
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == null
                || obj.getClass()
                != this.getClass()) return false;

        VitoChildren guest = (VitoChildren) obj;
        return (this.firstName.equals(guest.firstName)
                && this.secondName.equals(guest.secondName)
                && this.yearsOfLife.equals(guest.yearsOfLife));
    }
}

public class Lesson4 {
    public static void main(String[] args) {
        VitoChildren fosterSon = new VitoChildren()
                .withFirstName("Tom Hagen")
                .witSecondName(null)
                .withYearsOfLife("1910-?");

        VitoChildren eldestSon = new VitoChildren()
                .withFirstName("Santino Corleone")
                .witSecondName("Sonny")
                .withYearsOfLife("1916-1948");

        VitoChildren middleSon = new VitoChildren()
                .withFirstName("Frederico Corleone")
                .witSecondName("Fredo")
                .withYearsOfLife("1919-1959");

        VitoChildren youngerSon = new VitoChildren()
                .withFirstName("Michael Corleone")
                .witSecondName(null)
                .withYearsOfLife("1920-1997");

        VitoChildren onlyDaughter = new VitoChildren()
                .withFirstName("Constance Corleone")
                .witSecondName("Connie")
                .withYearsOfLife("1927-?");

// 1) Сделать двусвязный список

        MyLinkedList<VitoChildren> family = new MyLinkedList<>();

        family.addToEnd(fosterSon);
        family.addToEnd(eldestSon);
        family.addToEnd(middleSon);
        family.addToEnd(youngerSon);
        family.addToFirst(onlyDaughter);

        /*
            После реализации двусвязности списка появилась возможность
          добавлять данные в начало списка
        */

// 2) Провести family через цикл for-each
        for(VitoChildren person: family) {
            consoleOut.println(person);
        }
        /*
            Благодаря имплементации интерфейса Iterable и переопределению
          метода iterator() появляется возможность итерирования циклом for-each
        */

// 2) Сделать динамическую очередь
        DynamicQueue<VitoChildren> siblings = new DynamicQueue<>(new VitoChildren[2]);

        consoleOut.println();
        siblings.put(eldestSon);
        siblings.put(middleSon);
        siblings.put(youngerSon);

        try {
            for (int i = 0; i < 4; i++) {
                consoleOut.println(siblings.get());
            }
        }catch (QueueEmptyException exc) {
            consoleOut.println(exc);
        }
        /*
            В моём варианте размер массива очереди увеличевается в 2 раза
        */
    }
}