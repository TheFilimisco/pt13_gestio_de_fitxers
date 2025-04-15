package exercise5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Exercise5 {
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

            var numbers = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

            File folder = new File("src/exercise5/" + nameDirectory);
            if (folder.exists()){
                File[] folderFiles = folder.listFiles();
                assert folderFiles != null;
                for (File fi: folderFiles){
                    for (String number: numbers) {
                        if (fi.getName().contains(number)){
                            System.out.println("File deleted: " + fi.getName() + fi.delete());
                        }
                    }
                }
                System.out.println("Folder exists!");
            } else {
                System.out.println("Folder not exists!");
            }

            System.out.print("Stop running... (yes)?");
            var stop = input.nextLine();
            if (stop.equals("yes") || stop.equals("y")){
                running = false;
            }
        }
    }
}
