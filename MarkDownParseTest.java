import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;

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

    @Test
    public void Snippet1() throws IOException{
        String contents = Files.readString(Path.of("./break-file.md"));
        List<String> expected = List.of("`google.com");
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
}
