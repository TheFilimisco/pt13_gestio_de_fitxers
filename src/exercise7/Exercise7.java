package exercise7;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Exercise7 {
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

            File folder = new File("src/exercise7/" + nameDirectory);

            // If folder exist, but without file
            if (folder.exists()){

                File[] folderFiles = folder.listFiles();
                assert folderFiles != null;

                var runningMenu = true;
                while (runningMenu) {
                    System.out.println("""
                ================ Menu ========================
                1. Show all the files in the directory
                2. Show all the files in the folder by Name
                3. Show all the files in the folder by Date
                4. Show all the files in the folder by Size(High->Small)
                5. Leave
                """);

                    var inputOption = input.nextInt();

                    switch (inputOption) {
                        case 1:
                            System.out.println("=========File on Directory=========");
                            Arrays.stream(folderFiles).forEach(
                                    file -> {
                                        System.out.println(file.getName());
                                        System.out.println(file.length());
                                        System.out.println(convertedTime(file));
                                    }
                            );
                            break;
                        case 2:
                            System.out.println("========File on Folder By Name=========");
                            Arrays.stream(folderFiles).forEach(file -> System.out.println(file.getName()));
                            break;
                        case 3:
                            System.out.println("========File on Folder By Date=========");
                            Arrays.stream(folderFiles).sorted(Comparator.comparing(File::lastModified)).forEach(file -> System.out.println(file.getName()));
                            break;
                        case 4:
                            System.out.println("========File on Folder By Size=========");
                            Arrays.stream(folderFiles).sorted(Comparator.comparing(File::length).reversed()).forEach(file -> System.out.println(file.getName()));
                            break;
                        case 5:
                            System.out.println("Closing...");
                            runningMenu = false;
                            break;
                        default:
                            System.out.println("Put a option valid");
                    }

                }

            } else {
                // When files and folder doesn't exist! it created all
                System.out.println("Folder does not exist");
            }

            input.nextLine();

            System.out.print("Stop running... (yes)?");
            var stop = input.nextLine();
            if (stop.equals("yes") || stop.equals("y")){
                running = false;
            }
        }
    }

    public static String convertedTime(File file) {
        Date date = new Date(file.lastModified());
        return date.toString();
    }

}

