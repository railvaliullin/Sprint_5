package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline felineSpy;

    @Test
    public void testEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        doReturn(expectedFood).when(felineSpy).getFood("Хищник");

        List<String> actualFood = felineSpy.eatMeat();

        assertEquals(expectedFood, actualFood);
        verify(felineSpy, times(1)).getFood("Хищник");
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", felineSpy.getFamily());
    }

    @Test
    public void testGetKittens() {
        assertEquals(1, felineSpy.getKittens());
    }
}


