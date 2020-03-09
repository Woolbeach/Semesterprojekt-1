import java.io.*;
import java.util.*;

public class transactions {

    //opretter et object array med transaktioner
    ArrayList<transaction> shoppingCart = new ArrayList<transaction>();

    //funktion som tiljøjer en transaktion
    public void addTrans(int amount,int id){
      transaction trans = new transaction(amount,id);
      shoppingCart.add(trans);
    }

    //en funktion som printer alle logge fra arrayet af objekter
    public void printLog(){
        for (transaction trans : shoppingCart){
            System.out.println(trans.toString());
        }
    }


    //metode som skriver en fil med en test streng
    public void writeLog() throws IOException
    {
        FileWriter fil = new FileWriter("logfile.txt", true);
        PrintWriter ud = new PrintWriter(fil);


        //skriver transactions i en fil med følgende format: Dato,mængde,id
        for(int i = 0; i < shoppingCart.size(); i++){
            ud.println(shoppingCart.get(i));
        }
        ud.close(); // luk så alle data skrives til disken

        System.out.println(shoppingCart);
        shoppingCart.removeAll(shoppingCart);
        System.out.println(shoppingCart);
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
