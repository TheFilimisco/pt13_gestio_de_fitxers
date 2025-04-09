package exercise3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Exercise3 {
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

            File folder = new File("src/exercise3/" + nameDirectory);
            var keyWord = "exercici";

            if (folder.exists()){
                File[] folderFiles = folder.listFiles();
                assert folderFiles != null;
                for (File fi: folderFiles){
                    if (fi.getName().contains(keyWord)){
                        System.out.println("This file contains: " + fi.getName() +" : " + keyWord);
                    }
                }
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
