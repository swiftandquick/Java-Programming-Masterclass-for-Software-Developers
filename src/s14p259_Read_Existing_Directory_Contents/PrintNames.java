package s14p259_Read_Existing_Directory_Contents;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

// A simple visitor of files with default behavior to visit all files and to re-throw I/O errors.
public class PrintNames extends SimpleFileVisitor<Path> {

    // FileVisitResult:  The result type of a FileVisitor.
    // visitFile():  This method accepts a reference to the file and a BasicFileAttributes instance.  This is where
    // I run the code that will operate on the file.  It’s only called for files.
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.toAbsolutePath());
        // Continue.
        return FileVisitResult.CONTINUE;
    }


    // preVisitDirectory():  This method accepts a reference to the directory, and the BasicFileAttributes instance for
    // the directory.  It’s called before entries in the directory are visited.
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println(dir.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }


    // visitFileFailed():  This method is called when a file can’t be accessed.  The exception that’s thrown is passed
    // to the method.  I can then decide what to do with it, throw it, print it, or anything else that make sense for
    // the application and operation being performed.  Can be called for files and directories.
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error accessing file:  " + file.toAbsolutePath() + " " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }

}
