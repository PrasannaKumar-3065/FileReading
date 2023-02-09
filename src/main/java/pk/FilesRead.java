package pk;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.logging.Logger;

public class FilesRead {
    private static final Logger LOGGER =  Logger.getLogger("InfoLogging");

    static StringBuilder data = new StringBuilder("");
    static void write(File f, String s) throws IOException{
        read(f);
        data.append(" "+s);
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write(" "+data);
        bw.close();
        data.setLength(0);
    }
    static void read(File f) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(f));
        int i;
        while((i=br.read())!=-1){
            data.append((char)i);
        }
        br.close();
    }
    public static void main(String[] args) throws IOException{
        String path = "C:\\Users\\Tringapps-User5\\Desktop\\Maven projects\\ds\\src\\main\\java\\pk\\1.txt";
        File f = new File(path);
        read(f);
        String str = ""+data;
        String[] words = str.split(" ");

        Map<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            Integer integer = hashMap.get(word);
 
            if (integer == null)
                hashMap.put(word, 1);
 
            else {
                hashMap.put(word, integer + 1);
            }
        }

        ArrayList<Entry<String, Integer>> nlist  = new ArrayList<>(hashMap.entrySet());
        nlist.sort(Entry.comparingByValue(Comparator.reverseOrder()));
        String s = ""+nlist;
        LOGGER.info(s);
            

    }
}
