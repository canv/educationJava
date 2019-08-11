package ASClasses;

import java.util.Arrays;

import static packAlternative.AOutput.consoleOut;

public class Lesson2 {
    public static void main(String[] args) {

// 1) Разобрать "while" и "do while"

        int whileTest = 0;

        while(whileTest<5) { whileTest += 2; }
        consoleOut.println("'while' test: " + whileTest);
        /*
            Оператор 'while' просто означает 'пока'.
          Пока истинно значение в скобках - будет выполнятся блок кода
        */

        do{ whileTest *= 2; }while(whileTest<13);
        consoleOut.println("'do - while' test: " + whileTest);
        /*
            Почти тоже самое только сначало выполняется блок кода после 'do'
          А потом выполняется проверка 'while' и, если выражение истинно
          выполняется еще один цикл
        */

// 2) Параметрический полеморфизм
// 3) Метод расчитывающий факториал

        consoleOut.println("\nfactorial of 6 " + factorial(6));
        consoleOut.println("factorial of 10L " + factorial(10L));
        factorial(11.2);
        /*
            Перегрузка метода даёт возможность использовать метод
          с одним и тем же названием для разных входных параметров.
          Если бы такой функции не было прищлось бы создавать factorialInt,
          factorialLong, factorialDouble а так же ветвления if'ов.
          Но благодаря перегрузке методов компилятр, в зависимости от входных
          данных, сам определяет какой вариант метода использовать.
            Тоже самое работает и для конструкторов
        */

// 4)применить бинайрный поиск в отсортированном массиве

        int[] defaultArr = {
                 17,  97, -19,  16,  -4,
                -37, -60,  10, -75,  39,
                -38, -48, -50, -45, -72,
                -22,  87, -67,  34,  19};

        QuickSort(defaultArr);
        consoleOut.println("\n" + Arrays.toString(defaultArr));

        int wantedVal = 34;
        int foundedIndex = binarySearch(defaultArr, wantedVal);
        if (foundedIndex >= 0) consoleOut.println("The " + wantedVal +
                " found at " + foundedIndex + " index!");
        else consoleOut.println("The " + wantedVal +
                " is not found!");

// 5)написать алгоритм возвращающий один непарный элемент из массива
//      (такой элемент в массиве только один)

        int[] almostPairValues = {
                 17,  97, -19,  16,  -4,
                -37, -60,  10, -75, -39,
                 99, -39, -75,  10, -60,
                -37,  -4,  16, -19,  97,  17};

        int withoutPairIndex = withoutPairSearch(almostPairValues);
        consoleOut.println((withoutPairIndex==-1000)?
                "without pair value is not found" :
                "without Pair value is " + withoutPairIndex);
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <=n; i ++){
            result = result*i;
        }
        return result;
    }
    private static long factorial(long lg) {
        long result = 1;
        if (lg == 1 || lg == 0) {
            return result;
        }
        result = lg * factorial(lg-1);
        return result;
    }
    private static void factorial(double db) {
        consoleOut.println("The factorial of " +
                db + " is calculated " +
                "through the gamma function.");
    }

    private static void QuickSort(int[] processedArray) {
        qsAlgorithm(processedArray, 0, processedArray.length - 1);
        //Такие костыли в виде доп медода пришлось использовать
        //изза рекурсивности метода
    }
    private static void qsAlgorithm(int[] processedArray, int left, int right) {
        int leftPointer, rightPointer;
        int middle, exchange;

        leftPointer = left;
        rightPointer = right;
        middle = processedArray[(left + right) / 2];

        do {
            while ((processedArray[leftPointer] < middle) && (leftPointer < right))
                leftPointer++;
            while ((middle < processedArray[rightPointer]) && (rightPointer > left))
                rightPointer--;

            if (leftPointer <= rightPointer) {
                exchange = processedArray[leftPointer];
                processedArray[leftPointer] = processedArray[rightPointer];
                processedArray[rightPointer] = exchange;
                leftPointer++;
                rightPointer--;
            }
        } while (leftPointer <= rightPointer);

        if (left < rightPointer) qsAlgorithm(processedArray, left, rightPointer);
        if (leftPointer < right) qsAlgorithm(processedArray, leftPointer, right);
    }
    private static int binarySearch(int[] processedArray, int searchVal) {

        int firstIndex = 0;
        int lastIndex = processedArray.length - 1;

        while(firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;

            if (processedArray[middleIndex] == searchVal) {
                return middleIndex; }
            else if (processedArray[middleIndex] < searchVal)
                firstIndex = middleIndex + 1;
            else if (processedArray[middleIndex] > searchVal)
                lastIndex = middleIndex - 1;

        }
        return -1;
    }

    private static int withoutPairSearch(int[] processedArray){
        int pairFlag = 0;
        for (int i = 0; i <processedArray.length; i++) {
            for (int j = 0; j < processedArray.length; j++) {
                if (processedArray[i] == processedArray[j]) {
                    pairFlag++;
                }
            }
            if(pairFlag==1)return processedArray[i];
            pairFlag=0;
        }
        return -1000;
    }
}