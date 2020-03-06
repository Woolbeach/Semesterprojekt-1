import java.util.Date;

public class transaction {
    public String date;
    public double amount;
    public int id;

    public transaction(double x, int y){
        Date rightNow = new Date();
        date = rightNow.toString();
        amount = x;
        id = y;
    }

    public String toString(){
        return date+","+amount+","+id;
    }
}
