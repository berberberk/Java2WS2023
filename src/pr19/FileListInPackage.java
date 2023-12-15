package pr19;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

public class FileListInPackage {
    public static void main(String[] args) {
        File file = new File("src/pr19");
        File[] array = file.listFiles();
        List<File> list = Arrays.asList(array);
        for (int i = 0; i < Math.min(5, list.size()); i++) {
            System.out.println(list.get(i));
        }
    }
}