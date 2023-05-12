import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @Test
    public void testUnregisteredUnderLimit(){
        BonusService service = new BonusService();

        int expected = 50;
        long actual = service.calculate(5_000, false);
        //System.out.println("2, " + expected + " == ? == " + actual);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test(){
        BonusService service = new BonusService();

        int expected = 100;
        long actual = service.calculate(10_000, false);
        //System.out.println("2, " + expected + " == ? == " + actual);

        Assertions.assertEquals(expected, actual);
    }
}
