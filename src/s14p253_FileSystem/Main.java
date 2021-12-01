package s14p253_FileSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {
        // Get the path of WorkingDirectoryFile.txt using relative path.
        Path path = FileSystems.getDefault().getPath("src/s14p253_FileSystem/WorkingDirectoryFile.txt");
        printFile(path);

        // The file is named OutThere.txt, the path minus the last node is src/s14p253_FileSystem/files.
        // Path filePath = FileSystems.getDefault().getPath("src/s14p253_FileSystem/files", "SubdirectoryFile.txt");

        // "." stands for current directory.
        Path filePath = FileSystems.getDefault().getPath(".", "src/s14p253_FileSystem/files", "SubdirectoryFile.txt");
        printFile(filePath);

        // Using absolute path to get the path for OutThere.txt.
        /*
        filePath = Paths.get("C:\\Users\\Yong Chen\\Desktop\\IntelliJ Work Space" +
                "\\Java Programming Masterclass for Software Developers\\src\\s14p253_FileSystem\\OutThere.txt");
         */
        filePath = Paths.get("C:\\Users\\Yong Chen\\Desktop\\IntelliJ Work Space" +
                "\\Java Programming Masterclass for Software Developers\\src\\s14p253_FileSystem", "OutThere.txt");
        printFile(filePath);

        filePath = Paths.get(".");
        // Returns a Path object representing the absolute path of OutThere.txt.
        System.out.println(filePath.toAbsolutePath());

        // "." is the current directory.  Then go to "files".  Then move back to s14p253_FileSystem with "..", then
        // move to "files" again, then move to SubdirectoryFile.txt.
        Path path2 = FileSystems.getDefault().getPath("src/s14p253_FileSystem", ".", "files", "..",
                "files", "SubdirectoryFile.txt");
        // normalize():  Return a path from current path in which all redundant name elements are eliminated.
        System.out.println(path2.normalize().toAbsolutePath());
        printFile(path2.normalize());

        Path path3 = FileSystems.getDefault().getPath("src/s14253_FileSystem/thisfiledoesntexist.txt");
        System.out.println((path3.toAbsolutePath()));

        Path path4 = Paths.get("C:\\Users\\Yong Chen\\Desktop\\IntelliJ Work Space" +
                "\\Java Programming Masterclass for Software Developers\\src\\s14p253_FileSystem", "ancdef", "whatever.txt");
        System.out.println(path4.toAbsolutePath());

        filePath = FileSystems.getDefault().getPath("src/s14p253_FileSystem/files");
        // File.exists():  Checks if the file path exists. files folder is in s14p253_FileSystem package, which is in
        // src folder, so that path exists.
        System.out.println("Exists = " + Files.exists(filePath));

        // path4 doesn't exist, Files.exists() return false.
        System.out.println("Exists = " + Files.exists(path4));

        try {
            /*
            Path sourceFile = FileSystems.getDefault().getPath("src/s14p253_FileSystem/Examples", "file1.txt");
            Path copyFile = FileSystems.getDefault().getPath("src/s14p253_FileSystem/Examples", "file1copy.txt");
            // Copy file1.txt from Examples, and create a new copy at the same folder, named filecopy.txt.
            // If the file in destination already exist, replace the existing file with new copied file.
            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

            // Copy Dir1 as Dir4, when using copy() to copy directory, the files inside the directory are not copied.
            sourceFile = FileSystems.getDefault().getPath("src/s14p253_FileSystem/Examples", "Dir1");
            copyFile = FileSystems.getDefault().getPath("src/s14p253_FileSystem/Examples", "Dir4");
            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

            Path fileToMove = FileSystems.getDefault().getPath("src/s14p253_FileSystem/Examples", "file1copy.txt");
            Path destination = FileSystems.getDefault().getPath("src/s14p253_FileSystem/Examples", "Dir1", "file1copy.txt");
            // Move file1copy.txt to from Examples (fileToMove) folder Dir1 (destination) folder.
            // IMPORTANT:  Delete file1copy.txt in Dir1 to see the effect, otherwise an exception will be thrown.
            Files.move(fileToMove, destination);

            fileToMove = FileSystems.getDefault().getPath("src/s14p253_FileSystem/Examples", "file1.txt");
            destination = FileSystems.getDefault().getPath("src/s14p253_FileSystem/Examples", "file1.txt");
            // If the path of both fileToMove and destination are the same, the file is renamed to the file name of
            // destination, in this case, file1.txt (fileToMove) is renamed to file1.txt (fileToMove).
            // IMPORTANT:  Rename file2.txt in Examples folder to file1.txt to see the effect, otherwise exception will be thrown.
            Files.move(fileToMove, destination);

            Path fileToDelete = FileSystems.getDefault().getPath("src/s14p253_FileSystem/Examples", "Dir1", "file1copy.txt");
            // Delete the file of the path, in this case, it's file1copy.txt from Dir1 folder.
            // IMPORTANT:  Have file1copy.txt in Dir1 folder to see the effect.
            Files.delete(fileToDelete);

            Path fileToCreate = FileSystems.getDefault().getPath("src/s14p253_FileSystem/Examples", "file2.txt");
            // Create a file, in this case, file2.txt is created in the Examples folder.
            // IMPORTANT:  Delete file2.txt in Examples folder, otherwise exception will be thrown.
            Files.createFile(fileToCreate);

            Path dirToCreate = FileSystems.getDefault().getPath("src/s14p253_FileSystem/Examples", "Dir4");
            // Create a directory, in this case, Dir4 is created in the Examples folder.
            // IMPORTANT:  Delete Dir4 in Examples folder, otherwise exception will be thrown.
            Files.createDirectory(dirToCreate);

            Path dirToCreate2 = FileSystems.getDefault().getPath("src/s14p253_FileSystem/Examples", "Dir2/Dir3/Dir4/Dir5/Dir6/Dir7");
            // Create multiple directories.  In this case, I create Dir4 in Dir3, Dir5 in Dir4, Dir6 in Dir5, and Dir7 in Dir6.
            // Important:  Delete Dir4.Dir5.Dir6.Dir7 in Dir3.
            Files.createDirectories(dirToCreate2);
            */

            Path filePath2 = FileSystems.getDefault().getPath("src/s14p253_FileSystem/Examples", "Dir1/file1.txt");
            // Gets the size of the file, in thise case, gets the size file1.txt in Dir1.
            long size = Files.size(filePath2);
            System.out.println("Size = " + size);
            // Get the time the when the file is last modified.  In this case, get the time of when file1.txt from Dir1
            // is last modified.
            System.out.println("Last modified = " + Files.getLastModifiedTime(filePath2));

            // BasicFileAttributes contains methods that return attributes for the file.  In this case, attrs
            // represents attributes that associated with filePath2 (file1.txt in Dir1).
            BasicFileAttributes attrs = Files.readAttributes(filePath2, BasicFileAttributes.class);
            System.out.println("Size = " + attrs.size());
            System.out.println("Last modified = " + attrs.lastModifiedTime());
            // Get the time that file1.txt in Dir1 is created.
            System.out.println("Created = " + attrs.creationTime());
            // Checks if file1.txt in Dir1 is a directory.
            System.out.println("Is directory = " + attrs.isDirectory());
            // Checks if file1.txt in Dir1 is a regular file with opaque content.
            System.out.println("Is regular file = " + attrs.isRegularFile());
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }


    private static void printFile(Path path) {
        try(BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
