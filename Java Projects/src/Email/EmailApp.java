package Email;

import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Your First Name-->");
        String fname=sc.next();
        System.out.println("Enter Last Name-->");
        String lname=sc.next();

        Email e=new Email(fname,lname);
        int choice=-1;
        do {
            System.out.println("\n**********\n Enter your Choice\n1.Show Info\n2.Change Password\n3.Change mailbox Capacity\n4.Set Alternate Email\n5.Store Data in File\n6.Read data\n7.Exit");
            choice= sc.nextInt();
            switch (choice){
                case 1:
                    e.getInfo();
                    break;
                case 2:
                    e.set_password();
                    break;
                case 3:
                    e.set_mailCap();
                    break;
                case 4:
                    e.alternate_email();
                    break;
                case 5:
                    e.store_file();
                    break;
                case 6:
                    e.read_file();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    throw new Exception("Enter Valid number from 1 to 7");
            }
        }while (choice!=7);
    }
}
