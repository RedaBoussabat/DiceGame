package model;

public class Dobbelsteen {

    private static final int MAX_OGEN = 6;
    private static final int MIN_OGEN = 1;

    public static int dobbel(){
        return (int) Math.ceil(Math.random() * MAX_OGEN);
    }
}
