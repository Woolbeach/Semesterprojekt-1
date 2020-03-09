import java.util.Date;

public class transaction {
    public String date;
    public double cashFlow;
    public int id;

    public transaction(double x, int y){
        Date rightNow = new Date();
        date = rightNow.toString();
        cashFlow = x;
        id = y;
    }

    public String toString(){
        return date+","+ cashFlow +","+id;
    }
}
