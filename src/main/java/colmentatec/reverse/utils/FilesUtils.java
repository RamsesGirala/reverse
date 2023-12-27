package colmentatec.reverse.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilesUtils {

    @Value("${java.extension}")
    private String java_extension;

    //Lista todos los archivos dentro de un directorio recursivamente
    public List<File> getFilesFromPath(String path)
    {
        File directory = new File(path);
        List<File> files = new ArrayList<>();
        for (File file : directory.listFiles()) {
            if (file.isFile() && file.getName().endsWith(java_extension)) {
                files.add(file);
            } else if (file.isDirectory()) {
                files.addAll(getFilesFromPath(file.getPath()));
            }
        }
        return files;
    }
}
