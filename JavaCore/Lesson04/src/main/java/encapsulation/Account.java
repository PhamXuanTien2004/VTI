package encapsulation;

public class Account {
    private String id;
    private String name;
    private int balance;

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount) {
        return balance+amount;
    }

    public int debit(int amount) {
        return balance+amount;
    }

    public void tranferTo (Account account, int amount){}

}
