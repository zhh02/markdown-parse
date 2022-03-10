import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./Snippet1.md"));
        List<String> expect = List.of("`google.com", "google.com","ucsd.edu");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
    @Test
    public void testFile1Reviewed() throws IOException {
        String contents= Files.readString(Path.of("./Snippet1.md"));
        List<String> expect = List.of("`google.com", "google.com","ucsd.edu");
        assertEquals(expect, MarkdownParseReviewed.getLinks(contents));
    }
    



    @Test
    public void testFile2() throws IOException {
        String contents= Files.readString(Path.of("./Snippet2.md"));
        List<String> expect = List.of("a.com", "a.com(())", "example.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
    @Test
    public void testFile2Reviewed() throws IOException {
        String contents= Files.readString(Path.of("./Snippet2.md"));
        List<String> expect = List.of("a.com", "a.com(())", "example.com");
        assertEquals(expect, MarkdownParseReviewed.getLinks(contents));
    }
    


    @Test
    public void testFile3() throws IOException {
        String contents= Files.readString(Path.of("./Snippet3.md"));
        List<String> expect = List.of("https://www.twitter.com", "https://ucsd-cse15l-w22.github.io/", "https://cse.ucsd.edu/");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
    @Test
    public void testFile3Reviewed() throws IOException {
        String contents= Files.readString(Path.of("./Snippet3.md"));
        List<String> expect = List.of("https://www.twitter.com", "https://ucsd-cse15l-w22.github.io/", "https://cse.ucsd.edu/");
        assertEquals(expect, MarkdownParseReviewed.getLinks(contents));
    }
}