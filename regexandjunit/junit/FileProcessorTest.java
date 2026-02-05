package regexandjunit.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Logic Class
 */
class FileProcessor {
    public void writeToFile(String filename, String content) throws IOException {
        Files.write(Paths.get(filename), content.getBytes());
    }

    public String readFromFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
}

/**
 * JUnit Test Class
 */
public class FileProcessorTest {
    FileProcessor processor = new FileProcessor();

    @TempDir
    Path tempDir;

    @Test
    void testWriteAndRead() throws IOException {
        Path tempFile = tempDir.resolve("test.txt");
        String content = "JUnit Test";
        processor.writeToFile(tempFile.toString(), content);
        assertEquals(content, processor.readFromFile(tempFile.toString()));
    }
}
