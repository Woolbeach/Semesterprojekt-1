import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class transactions {

    public class SkrivTekstfil
    {
        public void writeLog() throws IOException
        {
            FileWriter fil = new FileWriter("logfile.txt");
            PrintWriter ud = new PrintWriter(fil);
            ud.print("date ticket id amount");
            ud.close(); // luk så alle data skrives til disken
        }



        public void readLog() throws IOException {
            FileReader fil = new FileReader("skrevet fil.txt");
            BufferedReader ind = new BufferedReader(fil);

            String linje = ind.readLine();
            while (linje != null) {
                System.out.println("Læst: " + linje);
                linje = ind.readLine();
            }
        }
    }
}
