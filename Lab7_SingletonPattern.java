import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account_Holder{
    String Name;
    String Mobile_no;
    String Email;
    String DOB;

    public void setName(String name) {
        Name = name;
    }
    public String getName() {
        return Name;
    }
    public void setMobile_no(String mobile_no) {
        Mobile_no = mobile_no;
    }
    public String getMobile_no() {
        return Mobile_no;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getEmail() {
        return Email;
    }
    public void setDOB(String dOB) {
        DOB = dOB;
    }
    public String getDOB() {
        return DOB;
    }
    @Override
    public String toString() {
       return "\nAccount Holder Details:- \nName:- "+Name+"\nMobile Number:- "+Mobile_no+"\nEmail ID:- "+Email+"\nDate of Birth:- "+DOB;
    }
}
class Account{
    private long Account_no;
    private String Branch;
    private Account_Holder Account_Holder;
    Account(long Account_no, String Branch, Account_Holder Account_Holder ){
        this.Account_no=Account_no;
        this.Branch=Branch;
        this.Account_Holder=Account_Holder;
    }

    public void setAccount_no(long account_no) {
        Account_no = account_no;
    }
    public long getAccount_no() {
        return Account_no;
    }
    public String getBranch() {
        return Branch;
    }
    public void setBranch(String branch) {
        Branch = branch;
    }
    public void setAccount_Holder(Account_Holder account_Holder) {
        Account_Holder = account_Holder;
    }
    public Account_Holder getAccount_Holder() {
        return Account_Holder;
    }
    @Override
    public String toString() {
        return "Account Number:- "+Account_no+"\tBranch:- "+Branch+Account_Holder;
    }
}

class Banker{
    private static Banker banker=null;
    private static List<Account> account = new ArrayList<Account>();
    
    static{
        banker = new Banker();
    }
    private Banker(){
    }
    public static synchronized Banker getInstance(){
        if(banker == null){
            banker = new Banker();
        }
        return banker;
    }
    @Override
    public String toString() {
        return account.toString();
    }
    public void addAccount(Account account2) {
        Banker.account.add(account2);
    }
    public void removeAccount(Account account2) {
        Banker.account.remove(account2);
    }
}



public class Lab7_SingletonPattern {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        Account_Holder accountHolder = new Account_Holder();

        // Ask the user to input the Account Holder's details
        System.out.print("Enter the Account Holder's Name: ");
        String name = sc.nextLine();
        accountHolder.setName(name);
    
        System.out.print("Enter the Account Holder's Mobile Number: ");
        String mobile = sc.nextLine();
        accountHolder.setMobile_no(mobile);
    
        System.out.print("Enter the Account Holder's Email: ");
        String email = sc.nextLine();
        accountHolder.setEmail(email);
    
        System.out.print("Enter the Account Holder's Date of Birth: ");
        String dob = sc.nextLine();
        accountHolder.setDOB(dob);
    
        // Create an Account object using the Account_Holder object
        System.out.print("Enter the Account Number: ");
        long accountNumber = sc.nextLong();
        System.out.print("Enter the Branch: ");
        sc.nextLine();
        String branch = sc.nextLine();

        Account account = new Account(accountNumber, branch, accountHolder);
        Banker b1 = Banker.getInstance();
        b1.addAccount(account);
        System.out.println(b1.toString());


    }
}
