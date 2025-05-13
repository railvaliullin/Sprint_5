package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTest {

    private final String inputGender;
    private final boolean expectedHasMane;
    private final int kittensCount;

    public ParameterizedTest(String inputGender, boolean expectedHasMane, int kittensCount) {
        this.inputGender = inputGender;
        this.expectedHasMane = expectedHasMane;
        this.kittensCount = kittensCount;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {"Самец", true, 3},
                {"Самка", false, 2}
        });
    }

    @Test
    public void testLionDoesHaveManeAndGetKittens() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Mockito.when(mockFeline.getKittens()).thenReturn(kittensCount);

        Lion lion = new Lion(inputGender, mockFeline);

        assertEquals(expectedHasMane, lion.doesHaveMane());
        assertEquals(kittensCount, lion.getKittens());
    }

    @Test
    public void testCatGetFood() throws Exception {
        Predator mockPredator = Mockito.mock(Predator.class);
        List<String> expectedFood = Arrays.asList("Мясо", "Птицы");
        Mockito.when(mockPredator.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(mockPredator);
        assertEquals(expectedFood, cat.getFood());
    }

    @Test
    public void testFelineGetKittens() {
        Feline feline = new Feline();
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }

    @Test
    public void testFelineFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }
}
