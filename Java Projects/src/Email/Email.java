package Email;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Email {
  Scanner sc=new Scanner(System.in);
  // private to not give access  n
  private String fname;
  private String lname;
  private String dept;
  private String email;
  private String password;
  private int mailCapacity=500;
  private String alter_email;

  // Constructor
  Email(String fname,String lname) throws Exception {
    this.fname=fname;
    this.lname=lname;
    System.out.println("New Employee-->"+this.fname+" "+this.lname);
    // calling methods
    this.dept=this.set_dept();
    this.password=this.generate_pass(8);
    this.email=this.generateEmail();
  }
  // Generate Email
  private String generateEmail(){
    return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".company.com";
  }

  // Asking for Department
  private String set_dept() throws Exception {
    System.out.println("Department\n1. for sales \n2. for Development \n3. for Accounting \n4. IT");
    boolean flag=false;
    // using do as it will execute again and again
    do{
      System.out.println("Enter Department Code");
      int choice=sc.nextInt();
      switch (choice){

        case 1:
          return "Sales";

        case 2:
          return "Development";

        case 3:
          return "Accounting";

        case 4:
          return "IT";
        default:
          throw new Exception("Please Enter valid input");
      }
    }while(!flag);
  }

  // Generate random password
  private String generate_pass(int length){
    Random r=new Random();
    String Capital_chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String Small_chars="abcdefghijklmnopqrstuvwxyz";
    String numbers="0123456789";
    String symbols="!@#$%&?*^";
    String value=Capital_chars+Small_chars+numbers+symbols;
    StringBuilder password= new StringBuilder();
    for (int i = 0; i <length; i++) {
      password.append(value.charAt(r.nextInt(value.length())));
    }
    return password.toString();
  }

  //Change Password
  public void set_password() throws Exception{
    boolean flag=false;
    System.out.println("Are your sure you want to Change Your Password");
    char c=sc.next().charAt(0);

    if(c=='Y' || c=='y'){
      flag=true;
      System.out.println("Enter your Current Password-->");
      String temp=sc.next();
      if(temp.equals(this.password)){
        System.out.println("Enter New Password");
        this.password=sc.next();
        System.out.println("Password Changed.....!!!!");
      }else {
        throw new Exception("Your are Scammer or you forgot your Password");
      }
    }else if(c=='N' || c=='n'){
      flag=true;
      System.out.println("Password Changed Option Cancelled");
    }else{
      throw new Exception("Enter either Yes Or No");
    }
  }

  // Set mailbox Capacity
  public void set_mailCap(){
    System.out.println("Current Capacity="+this.mailCapacity+"mb");
    System.out.println("Enter new mailbox Capacity:");
    this.mailCapacity=sc.nextInt();
    System.out.println("The new capacity is:"+this.mailCapacity);
  }

  // Set alternate Email
  public void alternate_email(){
    System.out.println("Enter new alternate Email");
    this.alter_email=sc.next();
    System.out.println("Alternate Email is now-->"+this.alter_email);
  }

  // Display user info
  public void getInfo(){
    System.out.println("Employee name is--> "+this.fname+" "+this.lname);
    System.out.println("Department is--> "+this.dept);
    System.out.println("Email of Employee is-->"+this.email);
    System.out.println("Password is-->"+this.password);
    System.out.println("Mailbox Capacity-->"+this.mailCapacity+"mb");
    System.out.println("Alternate Email-->"+this.alter_email);
  }
  public void store_file(){
    try{
      FileWriter f=new FileWriter("F:\\Java File.txt");
      f.write("First name-->"+this.fname);
      f.append(" Last Name-->"+this.lname);
      f.append(" Email-->").append(this.email);
      f.append(" Password-->"+this.password);
      f.append(" Capacity-->"+this.mailCapacity);
      f.close();
      System.out.println("Data Stored ");
    }catch (Exception e){
      System.out.println(e);
    }
  }
  public void read_file(){
    try{
      FileReader f=new FileReader("F:\\Java File.txt");
      int i;
      while((i=f.read())!=-1){
        System.out.print((char)i);
      }
      f.close();
      System.out.println("Done....");
    }catch(Exception e){
      System.out.println(e);
    }
  }
}
