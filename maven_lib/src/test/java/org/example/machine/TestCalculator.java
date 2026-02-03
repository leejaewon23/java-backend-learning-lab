package org.example.machine;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class TestCalculator {
    @Test
    public void testAdd() {
        // assertEqual(왼쪽값, 오른쪽값); 옛날 Junit 방식
        Calculator c1 = new Calculator();
        assertThat(c1.add(10, 20, 30)).isEqualTo(60L);
        assertThat(c1.add(10, 40, 50)).isEqualTo(100L);
        assertThat(c1.add(-10, -20, -100)).isEqualTo(-130L);

    }
}
