package com.example.mathtrainer;


import java.util.Random;

public class Problem {
    private int result;
    private final Random random = new Random();

    public int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    public int getResult() {
        return result;
    }

    public String getProblem() {
        int a = getRandom(-50, 50);
        int b = getRandom(-50, 50);
        String b1 = "";
        String sign = getRandomSign();

        if (sign == "+") result =  a + b;
        else if (sign == "-") result =  a - b;
        else if (sign == "*") result =  a * b;
        else result = a/b;

        if (b<0)  b1 = "(" + b + ")";
        else b1 = b + "";

        return a + " " + sign + " " + b1;
    }

    public int getNoiseResult() {
        return result + getRandom(-10, 10);
    }

    private String getRandomSign() {
        int sign = getRandom(1, 5);
        String stringSign = "";
        switch (sign) {
            case 1:
                stringSign = "+";
                break;
            case 2:
                stringSign = "-";
                break;
            case 3:
                stringSign = "*";
                break;
            case 4:
                stringSign = "/";
                break;
        }
        return stringSign;
    }

}
