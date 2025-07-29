package app;

import java.nio.file.Path;
import java.io.File;

public class Main {

    private static final String BASE_PATH = "files/";

    public static void main(String[] args) {

        // Перевірка наявності базового шляху
        if (!isBasePathExists()) {
            createBasePath();
        }

        FileHandler handler = new FileHandler();
        String newFileName = "myfile";
        String content = "Super information.";
        String path = BASE_PATH + newFileName + ".txt";
        // Виклики методів маніпуляції з файлом
        getOutput(handler.createFile(path));
        getOutput(handler.writeToFile(Path.of(path), content));
        getOutput("CONTENT: " + handler.readFromFile(path));
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }

    private static boolean isBasePathExists() {
        File basePath = new File(BASE_PATH);
        return basePath.exists() && basePath.isDirectory();
    }

    private static void createBasePath() {
        try {
            File basePath = new File(BASE_PATH);
            if (!basePath.exists()) {
                boolean success = basePath.mkdir();
                if (!success) {
                    throw new RuntimeException("Unable to create directory");
                }
            }
        } catch (Exception e) {
            getOutput("Error creating base path: " + e.getMessage());
        }
    }
}

