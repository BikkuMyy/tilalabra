package ui;

import java.util.Scanner;

public class ConsoleIO implements IO {

    private Scanner scanner;

    public ConsoleIO() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public void println(String s) {
        System.out.println(s);
    }

    @Override
    public void print(String s) {
        System.out.print(s);
    }
}
