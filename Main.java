package ru.geekbrains.level_2.lesson_2;

/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого размера
необходимо бросить исключение MyArraySizeException.

2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе
массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено
исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и
вывести результат расчета (сумму элементов, при условии что подали на вход корректный массив).

Заметка: Для преобразования строки к числу используйте статический метод класса Integer:
Integer.parseInt(сюда_подать_строку);
Заметка: Если Java не сможет преобразовать входную строку (в строке число криво написано), то будет сгенерировано
исключение NumberFormatException.
 */

public class Main {

    public static void main(String[] args) {

        String[][] array = new String[][]{{"1", "2", "3X", "4"}, {"2", "2", "2", "3"},
                                          {"1", "2", "2", "2"}, {"2", "2", "2", "2"}};
        try {
            try {
                ArrException(array);
            } catch (MyArraySizeException e) {e.printStackTrace();}
        } catch (MyArrayDataException e) {e.printStackTrace(); System.out.println("Error in cell "+ e.i + "x" + e.j);}
    }

    public static void ArrException(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if (array.length != 4 && array[0].length == 4) {
            throw new MyArraySizeException("Invalid number of rows");
        }
        if (array.length == 4 && array[0].length != 4) {
            throw new MyArraySizeException("Invalid number of columns");
        }
        if (array[0].length != 4 && array.length != 4) {
            throw new MyArraySizeException("Invalid number of columns and rows");
        }
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println("Sum of array elements: " + sum);
    }
}