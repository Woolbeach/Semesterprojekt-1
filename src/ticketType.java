public class ticketType {
    public String name;
    public double price;
    public int id;

    //constructor
    ticketType(String name1, double price1, int id1){
        name = name1;
        price = price1;
        id = id1;
    }

    // prints out a ticket and the price of the ticket
    public void printTicket() {
        System.out.println("############B##T###########");
        System.out.println("#   Borgen Trafikselskab  #");
        System.out.println("#                         #");
        System.out.println("# Tickettype: "+name+"      #");
        System.out.println("# Ticket price: " + price + " kr.  #");
        System.out.println("#                         #");
        System.out.println("############B##T###########");
        System.out.println("############B##T###########");
        System.out.println();
    }
    public double getPrice(){
        return price;
    }
    public String basketString(){
        return name;
    }

    //prints ticket info
    public String toString(){
        return "#"+id +"\tType: " + name + "\n#\tPrice: " + price+" DKK\n";
    }

}




