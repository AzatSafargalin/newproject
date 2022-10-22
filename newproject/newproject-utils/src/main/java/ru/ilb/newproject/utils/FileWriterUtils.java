package ru.ilb.newproject.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 *
 * @author AndrewSych
 */
public class FileWriterUtils {

    public static void writeToFile(Path path, String... messages) throws IOException {
        if (path == null || messages == null) {
            return;
        }
        FileWriterUtils.writeToFile(path, Arrays.asList(messages));
    }

    public static void writeToFile(Path path, Iterable<String> messages) throws IOException {
        if (path == null || messages == null) {
            return;
        }
        for (String message : messages) {
            if (message == null) {
                continue;
            }
            Files.write(path, message.concat("\n").getBytes(), StandardOpenOption.APPEND);
        }
    }
}
