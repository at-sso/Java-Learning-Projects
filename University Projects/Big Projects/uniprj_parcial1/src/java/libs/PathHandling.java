// Maybe we don't need this or maybe we won't use it, it doesn't matter.
// Quizás no necesitamos esto o quizas no lo usaremos, da igual.

package libs;

import java.io.File;
import java.nio.file.Paths;

public class PathHandling {

    private String relativePath;

    public PathHandling(String relativePath) {
        this.relativePath = relativePath;
    }

    public String findFilePath() {
        File file = Paths.get("").resolve(relativePath).toFile();
        if (file.exists()) {
            return file.getAbsolutePath();
        } else {
            return null;
        }
    }

}
