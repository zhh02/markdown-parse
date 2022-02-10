import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class MarkDownParseTest {
    @Test
    public void checkContent(){
        boolean test = false;
        try {
            Path filePath = Path.of("empty-test.md");
            String content = Files.readString(filePath);
            assertEquals("", content);
        } catch (Exception e) {
            test = true;
        }
    }
/*static Path	of​(String first, String... more)	
Returns a Path by converting a path string, or a sequence of strings that when joined form a path string.
static Path	of​(URI uri)	
Returns a Path by converting a URI.
**/
}
