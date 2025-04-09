package exercise1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        var running = true;

        while (running) {
            System.out.print("Put name of the directory: ");
            var nameDirectory = input.nextLine();

            if (nameDirectory.isEmpty()) {
                running = false;
            }

            File folder = new File("src/exercise1/" + nameDirectory);
            var maxWord = "";
            var maxLength = Integer.MIN_VALUE;

            if (folder.exists()){
                File[] folderFiles = folder.listFiles();
                assert folderFiles != null;
                for (File fi: folderFiles){
                    if (fi.getName().length() > maxLength){
                        maxLength = fi.getName().length();
                        maxWord = fi.getName();
                    }
                }
                System.out.println("Max word: " + maxWord);
                System.out.println("Folder exists!");
            } else {
                System.out.println("Folder not exists!");
            }
        }
    }
}
