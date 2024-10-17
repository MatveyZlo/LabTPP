package org.example;

public class MyArrayDataException extends RuntimeException {
    private int j;
    private int i;
    private String s;
    public MyArrayDataException(int i, int j, String s) {
        super("Ячейка в  " + (i + 1) + " строчке и " + (j + 1) + " столбце содержится не соответствующий тип данных");
        this.i = i;
        this.j = j;
        this.s = s;
    }
}
