import java.io.*;
import java.util.*;

public class transactions {

    //opretter et object array med transaktioner
    ArrayList<transaction> transList = new ArrayList<transaction>();
    int numberOfRecords = 0;

    //funktion som tiljøjer en transaktion
    public void addTrans(int amount,int id){
      transaction trans = new transaction(amount,id);
      transList.add(trans);
      numberOfRecords++;
    }

    //en funktion som printer alle logge fra arrayet af objekter
    public void printLog(){
        for (transaction trans :transList){
            System.out.println(trans.toString());
        }
    }


    //metode som skriver en fil med en test streng
    public void writeLog() throws IOException
    {
        FileWriter fil = new FileWriter("logfile.txt");
        PrintWriter ud = new PrintWriter(fil);
        for(int i = 0; i < numberOfRecords; i++){
            ud.println(transList.get(i));
        }

        ud.close(); // luk så alle data skrives til disken
    }

    //funktion som printer filen logfile
    //den skal opdateres så den tilføjer det den læser i transList Arrayet
    public void readLog() throws IOException {
        FileReader fil = new FileReader("logfile.txt");
        BufferedReader ind = new BufferedReader(fil);

        String linje = ind.readLine();
        while (linje != null) {
            System.out.println("Læst: " + linje);
            linje = ind.readLine();
        }
    }
}
