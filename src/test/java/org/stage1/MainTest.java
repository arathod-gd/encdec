package org.stage1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void encOutput() {
        assertEquals("dv ulfmw z givzhfiv!", Main.encOutput());
    }
    @Test
    void testMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.main(new String[]{});

        assertEquals("dv ulfmw z givzhfiv!", out.toString().trim());
    }

}
