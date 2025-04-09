package exercise2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        var running = true;

        while (running) {
            System.out.print("Put name of the directory: ");
            var nameDirectory = input.nextLine();

            if (nameDirectory.isEmpty()) {
                while (nameDirectory.isEmpty()) {
                    System.out.print("Please enter a folder name: ");
                    nameDirectory = input.nextLine();
                }
            }

            File folder = new File("src/exercise2/" + nameDirectory);
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

            System.out.print("Stop running... (yes)?");
            var stop = input.nextLine();
            if (stop.equals("yes")){
                running = false;
            }
        }
    }
}
