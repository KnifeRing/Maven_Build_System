import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BonusMilesServiceTest {
    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusMilesService service = new BonusMilesService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusMilesService service = new BonusMilesService();

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
    void shouldCalculateForNoRegisteredAndUnderLimit_01() {
        BonusMilesService service = new BonusMilesService();

        // подготавливаем данные:
        long amount = 1_000;
        boolean registered = false;
        long expected = 10;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForNoRegisteredAndBorderLimit_02() {
        BonusMilesService service = new BonusMilesService();

        // подготавливаем данные:
        long amount = 50_000;
        boolean registered = false;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForNoRegisteredAndBorderToLimit_03() {
        BonusMilesService service = new BonusMilesService();

        // подготавливаем данные:
        long amount = 49_999;
        boolean registered = false;
        long expected = 499;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForNoRegisteredAndBorderAfterLimit_04() {
        BonusMilesService service = new BonusMilesService();

        // подготавливаем данные:
        long amount = 50_001;
        boolean registered = false;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический)
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnRegisteredAndNullAmount() {
        BonusMilesService service = new BonusMilesService();

        // подготавливаем данные:
        long amount = 0;
        boolean registered = false;
        long expected = 0;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForRegisteredAndAmountBoundaryValueOne() {
        BonusMilesService service = new BonusMilesService();

        // подготавливаем данные:
        long amount = 33_33;
        boolean registered = true;
        long expected = 99;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForRegisteredAndAmountBoundaryValueTwo() {
        BonusMilesService service = new BonusMilesService();

        // подготавливаем данные:
        long amount = 33_34;
        boolean registered = true;
        long expected = 100;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForRegisteredAndLimitBoundaryValueThree() {
        BonusMilesService service = new BonusMilesService();

        // подготавливаем данные:
        long amount = 16_666_68;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForRegisteredAndBorderToLimit_05() {
        BonusMilesService service = new BonusMilesService();
        long amount = 16_666;
        boolean registered = true;
        long expected = 499;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForRegisteredAndBorderAfterLimit_06() {
        BonusMilesService service = new BonusMilesService();
        long amount = 16_667;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }



}