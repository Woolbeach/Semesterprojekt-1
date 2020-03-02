public class ticketType {
    public String name;
    public double price;
    public int id;

    ticketType(String name, double price, int id){
        name = name;
        price = price;
        id = id;
    }

    // Returns the price of a tickets current price
    public double getPrice() {
        return price;
    }


}




