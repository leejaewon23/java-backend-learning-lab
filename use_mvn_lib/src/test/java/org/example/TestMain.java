package org.example;

import com.google.gson.Gson;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class TestMain {
    @Test
    public void testMain1 () {
        assertThat(2).isEqualTo(3-1);
        assertThat(4).isEqualTo(3+1);

    }
    @Test
    public void testGson () {
        Gson gs = new Gson();
        MyClass mc = new MyClass();
        String s = gs.toJson(mc);

        MyClass mc2 = gs.fromJson(s, MyClass.class);
        assertThat(mc2.getMyArray().length).isEqualTo(mc.getMyArray().length);
        assertThat(mc2.getMyArray()).isEqualTo(mc.getMyArray());

    }
}
