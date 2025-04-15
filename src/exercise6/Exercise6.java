package exercise6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Exercise6 {
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

            File folder = new File("src/exercise6/" + nameDirectory);

            // If folder exist, but without file
            if (folder.exists()){
                File[] folderFiles = folder.listFiles();
                assert folderFiles != null;
                if (folderFiles.length == 0){
                    File file = new File(folder, nameDirectory+".txt");
                    System.out.println(file.createNewFile());
                }
            } else {
                // When files and folder doesn't exist! it created all
                File directory = new File(String.valueOf(folder));
                System.out.println(directory.mkdir());
                File file = new File(directory, nameDirectory+".txt");
                System.out.println(file.createNewFile());
            }

            System.out.print("Stop running... (yes)?");
            var stop = input.nextLine();
            if (stop.equals("yes") || stop.equals("y")){
                running = false;
            }
        }
    }
}
