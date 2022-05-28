package com.mygames.manager.tests;

import com.mygames.manager.entities.Console;

public class Factory {

    public static Console createConsole() {
        return new Console(1L, "PolyStation");
    }
}
