package org.example;

public class Main {
    static String[][] array = {
            {"345", "3898", "998", "8"},
            {"6767", "7887", "57", "1234"},
            {"76859", "78", "55", "67"},
            {"673", "249", "764830", "4545"}
    };

    public static void main(String[] args) {

        check_ARR(array);

    }
    static String message;
    public static void check_ARR(String[][] input_array) throws MyArraySizeException, MyArrayDataException {
        if (input_array.length != 4)
            throw new MyArraySizeException(message);
        for (String[] strings : input_array) {
            if (strings.length != 4)
                throw new MyArraySizeException(message);        }

        int sum = 0, s;
        for (int i = 0; i < input_array.length; i++) {
            for (int j = 0; j < input_array[i].length; j++) {
                try {

                    s = Integer.valueOf(input_array[i][j]);
                    sum += s;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
            }
        }

        for (int i = 0; i < input_array.length; i++) {
            for (int j = 0; j < input_array[i].length; j++) {
                s = Integer.valueOf(input_array[i][j]);
                try {
                    if (s < 1000 && isFibonacci(s)) {
                        throw new MyFibonacciException(i, j, array[i][j]);
                    }
                } catch (MyFibonacciException x) {
                    x.printStackTrace();
                }
            }
        }
        System.out.printf("Сумма элементов матрицы: "+ sum);
    }

    public static boolean isFibonacci(int num) {
        if (num < 0) {
            return false;
        }

        int a = 0;
        int b = 1;

        // Генерируем числа Фибоначчи до тех пор, пока не достигнем или не превысим num
        while (a < num) {
            int temp = a;
            a = b;
            b = temp + b;
        }

        return a == num; // Проверяем, равно ли текущее число num
    }
}