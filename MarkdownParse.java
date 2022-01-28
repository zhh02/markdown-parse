// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
	int lastCloseParen = markdown.lastIndexOf(")");
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
	    int nextOpenCarrot = markdown.indexOf("<", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
	    int nextCloseCarrot = markdown.indexOf(">", nextOpenCarrot);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);
	    toReturn.add(markdown.substring(nextOpenCarrot + 1, nextCloseCarrot));
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            System.out.println(currentIndex);
	    if (closeParen == lastCloseParen){
                break;
            }
            currentIndex = closeParen + 1;
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}
