package hu.nive.ujratervezes.kepesitovizsga.sumofdigits;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SumOfDigitsTest {

    @Test
    void getSumOfDigits() {
        assertEquals(9, new SumOfDigits().getSumOfDigits(new Random(1)));
    }
}