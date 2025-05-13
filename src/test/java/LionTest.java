import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline felineMock;

    @Test
    public void testMale() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testFemale() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testThrowsException() throws Exception {
        new Lion("Используйте допустимые значения пола животного - самец или самка", felineMock);
    }

    @Test
    public void testGetKittens() throws Exception {
        when(felineMock.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(3, lion.getKittens());
        verify(felineMock, times(1)).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Птицы");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", felineMock);
        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
        verify(felineMock, times(1)).getFood("Хищник");
    }
}
