import java.io.*;
import java.util.*;

public class transactions {

    //opretter et object array med transaktioner
    ArrayList<transaction> shoppingCart = new ArrayList<transaction>();
    ArrayList<Double> cashArray = new ArrayList<>();
    ArrayList<String> dateArray = new ArrayList<>();
    ArrayList<Double> idArray = new ArrayList<>();


    //funktion som tiljøjer en transaktion
    public void addTrans(double cashflow,int id){
      transaction trans = new transaction(cashflow,id);
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

        //System.out.println(shoppingCart);
        shoppingCart.removeAll(shoppingCart);
        //System.out.println(shoppingCart);
    }


    //funktion som printer filen logfile
    public void readLog() throws IOException {
        FileReader file = new FileReader("logfile.txt");
        BufferedReader in = new BufferedReader(file);

        String currentLine = in.readLine();
        while (currentLine != null) {
            System.out.println("Læst: " + currentLine);
            currentLine = in.readLine();
        }
    }



    //funktion som læser filen logfile og tager datoerne og balance ændring og putter dem i hvert sit array

    //hvis vi vil sortere efter type log, (udprint af billet, indsætning af penge og tilbagebetaling) kan vi
    //bare tilføje et ekstra array som læser værdien af id
    public void logToArray() throws IOException{
        FileReader file = new FileReader("logfile.txt");
        BufferedReader in = new BufferedReader(file);
        String currentLine = in.readLine();

        cashArray.removeAll(cashArray);
        dateArray.removeAll(dateArray);
        idArray.removeAll(idArray);

        while (currentLine !=null) {
            String[] data = currentLine.split(",");
            double inum = Double.valueOf(data[1]);
            cashArray.add(inum);
            dateArray.add(data[0]);
            double iid = Integer.valueOf(data[2]);
            idArray.add(iid);
            currentLine = in.readLine();
        }
    }


    public void findPayback() throws IOException{
        logToArray();
        for(int i = 0;  i < cashArray.size(); i++){
            if(cashArray.get(i) < 0 && idArray.get(i)==-2){
                System.out.println(dateArray.get(i) + " " + cashArray.get(i)+" " + idArray.get(i));
            }
        }
    }


    public void findPurchase(double x) throws IOException{
        logToArray();
        for(int i = 0;  i < cashArray.size(); i++){
            if(cashArray.get(i) >= x){
                System.out.println(dateArray.get(i) + " " + cashArray.get(i)+" " + idArray.get(i));
            }
        }
    }


    public void findByID(int newID) throws  IOException{
        logToArray();
        int i = 0;
        for (Double currentItem: idArray) {
            if(newID==currentItem){
                System.out.println(dateArray.get(i) + " " + cashArray.get(i)+" " + idArray.get(i));
            }
            i++;
        }
    }
}
