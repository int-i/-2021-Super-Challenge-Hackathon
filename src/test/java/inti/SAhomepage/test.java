package inti.SAhomepage;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Time;

import static org.assertj.core.api.Assertions.assertThat;

public class test {

    @Test
    void testT() {
        Long ms = System.currentTimeMillis();
        ms -= ms % 86400000;
        ms += (15+18)*3600000;
        ms += 30 * 60000;
        Date date = new Date(ms);
        System.out.println(date);

        assertThat(date).isEqualTo(new Date(System.currentTimeMillis()));



    }
}
