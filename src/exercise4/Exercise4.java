package exercise4;

import java.io.IOException;
import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        var running = true;

        while (running) {

            System.out.println("Select your choice:");
            var choice = input.nextInt();
            System.out.println(choice);
        }
    }
}
