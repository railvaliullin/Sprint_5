import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline felineMock;

    @Test
    public void testGetSound() {
        Cat cat = new Cat(felineMock);
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Птицы", "Мясо");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(felineMock);
        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
        verify(felineMock, times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testThrowsException() throws Exception {
        when(felineMock.eatMeat()).thenThrow(new Exception("Ошибка"));

        Cat cat = new Cat(felineMock);
        cat.getFood();
    }
}
