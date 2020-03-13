public class ticketType {
    public String name;
    public double price;
    public int id;
    public int ticketsSold;

    //konstruktøren
    ticketType(String name1, double price1, int id1){
        name = name1;
        price = price1;
        id = id1;
    }

    // Prints out a ticket and the price of the ticket
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

    public String basketString(){
        return name;
    }

    //printer information om billeten
    public String toString(){
        return "#"+id +"\tType: " + name + "\n#\tPrice: " + price+" DKK\n";
    }

}




