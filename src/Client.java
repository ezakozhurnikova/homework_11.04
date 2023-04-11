public class Client {
    String name;
    String surname;
    String gadget;
    int price;

    public Client (String line){
        String[] client=line.split(" ");
        name=client[0];
        surname=client[1];
        gadget=client[2];
        price=Integer.parseInt(client[3]);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGadget() {
        return gadget;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " +surname + " "+gadget + " " + price;

    }
}
