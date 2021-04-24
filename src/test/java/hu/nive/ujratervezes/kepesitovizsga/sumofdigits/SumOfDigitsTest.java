package hu.nive.ujratervezes.kepesitovizsga.sumofdigits;

import static org.junit.jupiter.api.Assertions.*;

class SumOfDigitsTest {
    @Test
    public void getSumOfDigits() {
        Assertions.assertEquals(9, new SumOfDigits().getSumOfDigits(new Random(1)));
    }

}