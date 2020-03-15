
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ticketBoothTests
{
    // Test for changing price on ticket
    @Test
    public void testChangeOfPrice() {
        ticketBoothClass booth = new ticketBoothClass("1234");    //create Booth object with code 1234
        //default ticket types
        ticketType adult = new ticketType("Adult", 24, 1);
        ticketType child = new ticketType("Child", 12, 2);
        ticketType bicycle = new ticketType("Bike", 18, 3);
        ticketType elderly = new ticketType("Elderly", 12, 4);
        //added in an array list for expandability
        ArrayList<ticketType> ticketList = new ArrayList<ticketType>();
        booth.addDefaultTickets();
        booth.changeTicketPrice(2, 50);
        System.out.println(child.price);
    }
    // Test for buying one ticket
    @Test
    public void testNormalBuyingTicket()
    {
        ticketBoothClass booth = new ticketBoothClass("1234");    //create Booth object with code 1234
        booth.addBalance(50);
        booth.addTicketToBasket(1,2);
        booth.payingForTickets();
    }
    // test for buying 10000 times tickets in which the amount is {2,2,2,2} which is 80000 tickets in total
    @Test
    public void testBuyingTicketsExtreme()
    {
        ticketBoothClass booth = new ticketBoothClass("1234");    //create Booth object with code 1234
        booth.addBalance(10000000);
        for(int i=0;i<10000;i++){
            booth.addTicketToBasket(1,2);
            booth.addTicketToBasket(2,2);
            booth.addTicketToBasket(3,2);
            booth.addTicketToBasket(4,2);
            booth.payingForTickets();
        }
        assertEquals(1320000,booth.moneyMade,0);

    }
    // tests what happends when you buy negative tickets
    @Test
    public void testNegativeAmountBuyingTicket()
    {
        ticketBoothClass booth = new ticketBoothClass("1234");    //create Booth object with code 1234
        booth.addBalance(50);
        booth.addTicketToBasket(1,-2);
        booth.payingForTickets();
    }
    // test for what happends when you buy ticket and request for the moneymade from the ticketbooth
    @Test
    public void testNormalGetMoneyMade()
    {
        ticketBoothClass booth = new ticketBoothClass("1234");    //create Booth object with code 1234
        booth.addBalance(100);
        booth.addTicketToBasket(2,4);
        booth.payingForTickets();
        booth.seeMoneyMade();
    }
    // Test to see if you can add and buy 400 of each tickets in one go
    @Test
    public void testGetMoneyMadeExtreme()
    {
        ticketBoothClass booth = new ticketBoothClass("1234");    //create Booth object with code 1234
        booth.addBalance(1000000);
        booth.addTicketToBasket(1,400);
        booth.addTicketToBasket(2,400);
        booth.addTicketToBasket(3,400);
        booth.addTicketToBasket(4,400);
        booth.payingForTickets();
        booth.seeMoneyMade();
        assertEquals(26400,booth.moneyMade,0);
    }
    // test for what happends when you have negative balance and wants to buy a ticket
    @Test
    public void testNegativeGetMoneyMade()
    {
        ticketBoothClass booth = new ticketBoothClass("1234");    //create Booth object with code 1234
        booth.addBalance(-100);
        booth.addTicketToBasket(1,1);
        booth.addTicketToBasket(2,1);
        booth.addTicketToBasket(3,1);
        booth.addTicketToBasket(4,1);
        booth.payingForTickets();
        booth.seeMoneyMade();
    }
}