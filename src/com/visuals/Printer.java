package com.visualeffects;

public class Printer {

    private static final String ANSI_RESET = "\u001B[0m";

    public enum PrinterColor {

        COLOR_RED("\u001B[31m"),
        COLOR_GREEN("\u001B[32m"),
        COLOR_YELLOW("\u001B[33m"),
        COLOR_BLUE("\u001B[34m"),
        COLOR_PURPLE("\u001B[35m"),
        COLOR_CYAN("\u001B[36m");

        private String value;

        PrinterColor(String value) {
            this.value = value;
        }
    }

    public static void println(String text, PrinterColor printerColor) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(printerColor.value + text.charAt(i) + ANSI_RESET);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
