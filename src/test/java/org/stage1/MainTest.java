package org.stage1;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main = new Main();


    @org.junit.jupiter.api.Test
    void encOutput() {
        String check = "dv ulfmw z givzhfiv!";
        String presentMain = main.encOutput();

        assertEquals(check, presentMain);
    }
}