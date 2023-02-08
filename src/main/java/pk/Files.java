package pk;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;
class Words {
    String word;
    int count;
    Words(String word,int count){
        this.word = word;
        this.count = count;
    }
}

public class files {
    private static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    static ArrayList<Words> w = new ArrayList<>();
    static StringBuilder data = new StringBuilder("");
    static void write(File f, String s) throws IOException{
        read(f);
        data.append(" "+s);
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write(" "+data);
        bw.close();
        data.setLength(0);
    }
    static void countWords(){
        String s = data.toString();
        String[] k = s.split(" ");
        for(int i=0; i<k.length; i++){
            String word = "";
            int count = 1;
            if(!k[i].equals(".....")){
                word = k[i];
                for(int j=i+1; j<k.length; j++){
                    if(k[i].equals(k[j])){
                        count++;
                        k[j] = ".....";
                    }
                }
            }
            assign(word,count);
            word = "";
            count = 1;
        }
    }
    static void read(File f) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(f));
        int i;
        while((i=br.read())!=-1){
            data.append((char)i);
        }
        br.close();
    }
    static void sort(){
        for(int i=0; i<w.size(); i++){
            for(int j=i+1; j<w.size(); j++){
                if(w.get(i).count < w.get(j).count){
                    int temp = w.get(i).count;
                    String t = w.get(i).word;
                    w.get(i).count = w.get(j).count;
                    w.get(i).word = w.get(j).word;
                    w.get(j).count = temp;
                    w.get(j).word = t;
                }
            }
        }
    }
    static void assign(String word, int count){
        Words w1 =new Words(word, count);
        w.add(w1);
    }
    public static void main(String[] args) throws IOException{
        File f = new File("C:\\Users\\Tringapps-User5\\Desktop\\Maven projects\\ds\\src\\main\\java\\pk\\1.txt");
        read(f);
        countWords();
        sort();
        StringBuilder result = new StringBuilder("");
        for(int i=0; i<w.size(); i++){
            result.append("\n"+w.get(i).word+"("+w.get(i).count+")\n");
        }
        String s = ""+result;
        LOGGER.info(s);
    }
}
