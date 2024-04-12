package source;

import java.io.File;
import java.io.FileFilter;

public class DirectoryExplorer {

    private FileHandler fileHandler;

    public DirectoryExplorer(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    FileFilter fileFilter = new JavaFileFilter();

    public void explore(File root) {
        explore(0, root);
    }

    public void explore(int level, File file) {
        if (file.isDirectory()) {
            exploreJavaFiles(level, file);
            exploreDirectories(level, file);
        } else {
            fileHandler.handle(file);
        }
    }

    private void exploreDirectories(int level, File file) {
        for (File child : file.listFiles()) {
            if (child.isDirectory()) {
                explore(level + 1, child);
            }
        }
    }

    private void exploreJavaFiles(int level, File file) {
        for (File child : file.listFiles(fileFilter)) {
            explore(level + 1, child);
        }
    }
}
