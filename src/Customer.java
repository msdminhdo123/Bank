public class Customer {
    private String fname;
    private String lname;
    private int age;
    private int balance;

    Customer(String fname, String lname, int age, int balance) {
        this.fname = fname;
        this.lname =lname;
        this.age = age;
        this.balance = balance;

    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
