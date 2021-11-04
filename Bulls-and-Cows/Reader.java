import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Reader {
    static String url = "https://gist.githubusercontent.com/valeriesum/99c5cc34b4c350557884b857431532b3/raw/65f230a253be6fe642e986d87def1d758b3cbcd3/4%2520letter%2520isogram";
    public static void readInto(ArrayList<String> list) throws Exception {
        URL wordsURL = new URL(url);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(wordsURL.openStream()));
        String word;
        while ((word = in.readLine()) != null){
            list.add(word);
        }
        in.close();
    }
}