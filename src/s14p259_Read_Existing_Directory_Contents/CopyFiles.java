package s14p259_Read_Existing_Directory_Contents;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyFiles extends SimpleFileVisitor<Path> {

    private Path sourceRoot;
    private Path targetRoot;


    public CopyFiles(Path sourceRoot, Path targetRoot) {
        this.sourceRoot = sourceRoot;
        this.targetRoot = targetRoot;
    }


    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error accessing file:  " + file.toAbsolutePath() + " " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }


    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        // relativize():  Constructs a relative path between this path (sourceRoot) and a given path (dir).
        Path relativizedPath = sourceRoot.relativize(dir);
        System.out.println("Relativezed Path = " + relativizedPath);
        // resolve():  Resolve the given path (relativizedPath) against this path (targetRoot).
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println("Resolved path for copy = " + copyDir);
        try {
            Files.copy(dir, copyDir);
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
            // Continue without visiting the entries in this directory.
            return FileVisitResult.SKIP_SUBTREE;
        }
        return FileVisitResult.CONTINUE;
    }


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path relativizedPath = sourceRoot.relativize(file);
        System.out.println("Relativezed Path = " + relativizedPath);
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println("Resolved path for copy = " + copyDir);
        try {
            Files.copy(file, copyDir);
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
            // No skipping directory because I visit a file not a directory.
        }
        return FileVisitResult.CONTINUE;
    }

}
