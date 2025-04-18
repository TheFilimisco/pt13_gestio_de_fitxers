package exercise4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Exercise4 {
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


            File folder = new File("src/exercise4/inventory/" + nameDirectory);
            if (folder.exists()){
                File[] folderFiles = folder.listFiles();
                assert folderFiles != null;
                for (File fi: folderFiles){
                    System.out.println("========================================");
                    System.out.println("Name: " + fi.getName());
                    System.out.println("Absolut routh: " + fi.getAbsolutePath());
                    System.out.println("Can Write: " + fi.canWrite());
                    System.out.println("Can Read: " + fi.canRead());
                    System.out.println("Size: " + fi.length() + " bytes");
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
