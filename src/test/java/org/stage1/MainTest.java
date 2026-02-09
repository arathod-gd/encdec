package org.stage1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void encOutput() {
        String check = "dv ulfmw z givzhfiv!";
        String presentMain = Main.encOutput();

        assertEquals(check, presentMain);
    }
}