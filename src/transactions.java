import java.io.*;
import java.util.*;

public class transactions {

    //create a object array with transactions
    ArrayList<transaction> shoppingCart = new ArrayList<transaction>();
    ArrayList<Double> cashArray = new ArrayList<>();
    ArrayList<String> dateArray = new ArrayList<>();
    ArrayList<Double> idArray = new ArrayList<>();


    //adds transaction
    public void addTrans(double cashflow,int id){
      transaction trans = new transaction(cashflow,id);
      shoppingCart.add(trans);
    }


    //write a file with each purchase logged
    public void writeLog() throws IOException
    {
        FileWriter fil = new FileWriter("logfile.txt", true);
        PrintWriter ud = new PrintWriter(fil);


        //writes transaction date,amount,id
        for (transaction transaction : shoppingCart) {
            ud.println(transaction);
        }
        ud.close(); // close file

        //System.out.println(shoppingCart);
        shoppingCart.clear();
        //System.out.println(shoppingCart);
    }


    //print logfile to admin
    public void readLog() throws IOException {
        FileReader file = new FileReader("logfile.txt");
        BufferedReader in = new BufferedReader(file);

        String currentLine = in.readLine();
        while (currentLine != null) {
            System.out.println("Læst: " + currentLine);
            currentLine = in.readLine();
        }
    }




    //reads logfile and puts it into an array
    public void logToArray() throws IOException{
        FileReader file = new FileReader("logfile.txt");
        BufferedReader in = new BufferedReader(file);
        String currentLine = in.readLine();

        cashArray.clear();
        dateArray.clear();
        idArray.clear();

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

    //find purchase by id from array
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

    //find money in range from array
    public void findMoneyIn_InRange(double min, double max) throws IOException{
        logToArray();
        int i = 0;
        for (Double currentItem: idArray) {
            double money = cashArray.get(i);
            if(-1==currentItem && money>=min && money <= max){
                System.out.println(dateArray.get(i) + " " + cashArray.get(i)+" " + idArray.get(i));
            }
            i++;
        }
    }

    //Find payout in range from array
    public void findPayout_InRange(double min, double max) throws IOException{
        logToArray();
        int i = 0;
        for (Double currentItem: idArray) {
            double money = cashArray.get(i);
            if(-2==currentItem && money>=min && money <= max){
                System.out.println(dateArray.get(i) + " " + cashArray.get(i)+" " + idArray.get(i));
            }
            i++;
        }
    }
}
