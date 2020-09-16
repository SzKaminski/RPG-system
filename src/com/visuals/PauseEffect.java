package com.visualeffects;

public class PauseEffect {

    public static void pause() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.print(".");
                Thread.sleep(500);
            }
            System.out.print("\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
