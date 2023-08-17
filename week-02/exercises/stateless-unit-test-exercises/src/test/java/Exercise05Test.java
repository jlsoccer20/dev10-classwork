import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Exercise05Test {
    Exercise05 instance = new Exercise05();

    @Test
    void shouldBeTrue(){
        assertTrue(instance.isWithinFiveOfAHundred(4));
        assertTrue(instance.isWithinFiveOfAHundred(-4));
        assertTrue(instance.isWithinFiveOfAHundred(98));
        assertTrue(instance.isWithinFiveOfAHundred(-98));
        assertTrue(instance.isWithinFiveOfAHundred(100));
        assertTrue(instance.isWithinFiveOfAHundred(101));
        assertTrue(instance.isWithinFiveOfAHundred(497));
        assertTrue(instance.isWithinFiveOfAHundred(-497));


    }
    @Test
    void shouldBeFalse(){
        assertFalse(instance.isWithinFiveOfAHundred(27));
        assertFalse(instance.isWithinFiveOfAHundred(-27));
        assertFalse(instance.isWithinFiveOfAHundred(127));
        assertFalse(instance.isWithinFiveOfAHundred(227));
        assertFalse(instance.isWithinFiveOfAHundred(86));
        assertFalse(instance.isWithinFiveOfAHundred(-86));
    }
}