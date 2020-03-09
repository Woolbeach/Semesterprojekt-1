public class basketItem {

    int id;
    int amount;

    public basketItem(int id1, int amount1){
        id=id1;
        amount=amount1;
    }

    public String toString(){
        return "Id: " + id + " Amount: " + amount;
    }
}
