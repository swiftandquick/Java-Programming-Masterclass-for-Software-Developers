package s14p259_Read_Existing_Directory_Contents;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;

public class Main {

    public static void main(String[] args) {

        // DirectoryStream.Filter:  An interface that is implemented by objects that decide if a directory entry should
        // be accepted or filtered.
        /*
        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            // Decides if the given directory entry should be accepted or filtered.
            public boolean accept(Path path) throws IOException {
                // Accepts regular files, that means the likes of directories are filtered.
                return Files.isRegularFile(path);
            }
        };
         */

        // Shorten version with lambda expression.
        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);

        Path directory = FileSystems.getDefault().getPath("src/s14p259_Read_Existing_Directory_Contents/FileTree"
                + File.separator + "Dir2");
        // DirectoryStream is an object to iterate over the entries in a directory. A directory stream allows for the
        // convenient use of the for-each construct to iterate over a directory.  In this case, I use DirectoryStream
        // to iterate over the entries that are regular files in Dir2.
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
            // Get each file and directory in Dir2.
            for(Path file : contents) {
                // Get the file name.
                System.out.println(file.getFileName());
            }
        }
        // DirectoryIteratorException:  Runtime exception thrown if an I/O error is encountered when iterating over the
        // entries in a directory.
        catch(IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }

        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        try {
            // Creates an empty file in the default temporary-file directory, using the given prefix (myapp) and
            // suffix (.appext) to generate its name.
            Path tempFile = Files.createTempFile("myapp", ".appext");
            System.out.println("Temporary file name = " + tempFile.toAbsolutePath());
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }

        // Create a FileStore object, acts as a storage for files.
        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for(FileStore store : stores) {
            // Return the FileStore object, which is C drive.
            System.out.println("Volume Name / Drive Letter = " + store);
            // Returns the name of the FileStore object.  My C drive has no name, so return an empty String.
            System.out.println("File Store = " + store.name());
        }

        // Get the Path of the Root Directories.  For me, it's the C Drive.
        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for(Path path : rootPaths) {
            System.out.println(path);
        }

        System.out.println("---Walking Tree for Dir2---");

        Path dir2Path = FileSystems.getDefault().getPath("src/s14p259_Read_Existing_Directory_Contents/FileTree" +
                File.separator + "Dir2");
        try {
            // walkFileTree method accepts 2 parameters, the Path dir2Path and FileVisitor, which is the anonymous new
            // PrintNames object, as PrintNames is the subclass of FileVisitor.  walkFileTree can be used to initiate a
            // file walk.  Print out the full paths of files and directories within Dir2.
            Files.walkFileTree(dir2Path, new PrintNames());
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---Copy Dir2 to Dir4/Dir2Copy---");
        Path copyPath = FileSystems.getDefault().getPath("src/s14p259_Read_Existing_Directory_Contents/FileTree" +
                File.separator + "Dir4" + File.separator + "Dir2Copy");
        try {
            // Copy items from Dir2 in to newly created folder Dir4/Dir2.
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, copyPath));
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }

        File file = new File("/Examples/file.txt"); // C:\\Examples\file.txt;
        // toPath():  Returns a java.nio.file.Path object constructed from the this abstract path.
        Path convertedPath = file.toPath();
        System.out.println("convertedPath = " + convertedPath);

        File parent = new File("/Examples"); // C:\\Examples
        File resolvedFile = new File(parent, "dir/file.txt"); // dir\\file.txt
        System.out.println(resolvedFile.toPath());

        resolvedFile = new File("/Examples", "dir/file.txt"); // C;\\Examples  dir\\file.txt
        System.out.println(resolvedFile.toPath());

        Path parentPath = Paths.get("/Examples"); // C;\\Examples
        Path childRelativePath = Paths.get("dir/file.txt"); // dir\\file.txt
        System.out.println(parentPath.resolve(childRelativePath));

        // getAbsoluteFile():  Returns the absolute form of this abstract pathname.
        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println("Working directory = " + workingDirectory.getAbsolutePath());

        System.out.println("--- print Dir2 contents using list() ---");
        File dir2File = new File(workingDirectory, "src/s14p259_Read_Existing_Directory_Contents/FileTree/Dir2");
        // list():  Returns an array of strings naming the files and directories in the directory (Dir2) denoted by this
        // abstract pathname.
        String[] dir2Contents = dir2File.list();
        for(int i = 0; i < dir2Contents.length; i++) {
            System.out.println("i = " + i + ":  " + dir2Contents[i]);
        }

        System.out.println("--- print Dir2 contents using listFiles() ---");
        // listFiles():  Returns an array of abstract pathnames denoting the files in the directory (Dir2) denoted by
        // this abstract pathname.
        File[] dir2Files = dir2File.listFiles();
        for(int i = 0; i < dir2Files.length; i++) {
            // getName():  dir2Files[i] is a path name, get the name of the file in the path.
            System.out.println("i = " + i + ":  " + dir2Files[i].getName());
        }
    }

}
