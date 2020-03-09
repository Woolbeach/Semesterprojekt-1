import java.io.*;
import java.util.*;

public class transactions {

    //opretter et object array med transaktioner
    ArrayList<transaction> shoppingCart = new ArrayList<transaction>();
    ArrayList<Double> cashArray = new ArrayList<>();
    ArrayList<String> dateArray = new ArrayList<>();


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

    //patchwork function (might change the name later)
    public int what_the_fuck_is_the_shopping_cart_doing_in_transactions_class(int ticketID){
        int ticketsofthattype=0;
        for (transaction trans : shoppingCart){
            if(ticketID == trans.id){
                ticketsofthattype++;
            }
        }
        return ticketsofthattype;
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
        FileReader file = new FileReader("logfile.txt");
        BufferedReader in = new BufferedReader(file);

        String currentLine = in.readLine();
        while (currentLine != null) {
            System.out.println("Læst: " + currentLine);
            currentLine = in.readLine();
        }
    }

    public void logToArray() throws IOException{
        FileReader file = new FileReader("logfile.txt");
        BufferedReader in = new BufferedReader(file);
        String currentLine = in.readLine();

        cashArray.removeAll(cashArray);
        dateArray.removeAll(dateArray);

        while (currentLine !=null) {
            String[] data = currentLine.split(",");
            double inum = Double.valueOf(data[1]);
            cashArray.add(inum);

            dateArray.add(data[0]);
            currentLine = in.readLine();
        }
    }

    public void findPayback() throws IOException{
        logToArray();
        for(int i = 0;  i < cashArray.size(); i++){
            if(cashArray.get(i) < 0){
                System.out.println(dateArray.get(i) + " " + cashArray.get(i));
            }
        }
    }

    public void findPurchase(double x) throws IOException{
        logToArray();
        for(int i = 0;  i < cashArray.size(); i++){
            if(cashArray.get(i) >= x){
                System.out.println(dateArray.get(i) + " " + cashArray.get(i));
            }
        }
    }
}
