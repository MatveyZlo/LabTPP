package org.example;
public class MyFibonacciException extends RuntimeException {
    private int j;
    private int i;
    private String s;
    public MyFibonacciException(int i, int j, String s) {
        super("Ячейка в  " + (i + 1) + " строчке и " + (j + 1) + " столбце содержится число Фибоначи до 1000");
        this.i = i;
        this.j = j;
        this.s = s;
    }

}
