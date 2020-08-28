package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
    private Random r;

    @BeforeEach
    void setUp() {
        r = new Random();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void itFluctuates() {
        int i = r.nextInt(3) - 1;
        System.out.println(i);
    }

    @Test
    void setCritChancePercentage() {
        double v = r.nextDouble();
        System.out.println(v);
        double critChances = 0.01;
        if (v > 1.0 - critChances) {
            System.out.println("Crit hit");
        }
    }
}