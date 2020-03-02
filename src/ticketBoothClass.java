import java.util.ArrayList;

public class ticketBoothClass {
    private double price;
    private double balance;
    private double testBalance;
    private int ticketsSold;
    private double moneyMade;

    public ArrayList<transactions>transactionsArrayList = new ArrayList<transactions>();

    ticketType adult = new ticketType("Adult", 24, 1);
    ticketType child = new ticketType("Child", 12, 2);
    ticketType bicycle = new ticketType("Bike", 18, 3);
    ticketType elderly = new ticketType("Elderly", 12, 4);

    //Constructor
    java.util.Scanner scanObj = new java.util.Scanner(System.in);

    public ticketBoothClass(double ticketPrice, double startBalance) {
        price = ticketPrice;
        balance = startBalance;
        while (price < 0 || balance < 0) {            //Checks for valid price before implementing
            System.err.println("Invalid price and/or startBalance");
            price = scanObj.nextDouble();
            balance = scanObj.nextDouble();
        }
    }

    //Prints out a test ticket
    public void printTestTicket() {
        if(testBalance >= price){
            testBalance+=-price;
            System.out.println("##########B##T#########");
            System.out.println("# Borgen Trafikselskab #");
            System.out.println("#                     #");
            System.out.println("#        Billet       #");
            System.out.println("#        " + price + " kr   .       #");
            System.out.println("#                     #");
            System.out.println("# Du har "+ testBalance + " kr. tilbage.   #");
            System.out.println("##########B##T#########");
            System.out.println("##########B##T#########");
            System.out.println();
        }else{
            System.out.println("Not enough balance");
        }
    }

    //Returns current balance value
    public double getBalance() {
        return balance;
    }

    //Returns a test balance
    public double setTestBalance(int newBalance){
        return testBalance += newBalance;
    }


    public double getMoneymade(){
        return moneyMade;
    }

    //Returns true if accessCode is correct
    public boolean accessCode(String code) {
        if (code.equals("1234")) {
            return true;
        }
        return false;
    }
}

