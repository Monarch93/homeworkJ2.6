package org.example;

import java.io.PrintWriter;
import java.util.Scanner;

public class Chat {
    private  Scanner in;
    private Scanner input;
    private  PrintWriter out;

    public Chat(Scanner in, Scanner input, PrintWriter out) {
        this.in = in;
        this.input = input;
        this.out = out;
    }

    public void run() {
        sender();
        receiver();
    }

    private void sender() {
        new Thread(() -> {
            while (input.hasNext()) {
                final String str = input.nextLine();
                out.println(str);
            }
        }).start();
    }

    private void receiver() {
        while (in.hasNext()){
            final String str = in.nextLine();
            System.out.println(str);
        }
    }

}