package hu.nive.ujratervezes.kepesitovizsga.sumofdigits;

import java.util.Random;

public class SumOfDigits {

    public int getSumOfDigits(Random random) {

        int number = Math.abs(random.nextInt());

        String num = String.valueOf(number);

        while (num.length() > 1) {
            int temp = 0;
            for (char c : num.toCharArray()) {
                temp += Integer.parseInt(String.valueOf(c));
            }
            num = String.valueOf(temp);
        }
        return Integer.parseInt(num);
    }
}
