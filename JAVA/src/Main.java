import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Mobile mb = new Mobile("9130456733");
    public static void main(String[] args)
    {
        mobon();
        printinst();
        boolean quit = false;


        while(!quit)
        {
            System.out.println("enter your choice = ");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 0:
                    System.out.println("mobil turning off");
                    quit =true;
                    break;
                case 1:
                    mb.printCon();
                    break;
                case 2:
                    addnum();
                    break;
                case 3:
                    System.out.println("enter new contact number to update:");
                    String newcont = sc.next();
                    System.out.println("enter contact name to update");
                    String newname = sc.next();
                    System.out.println("enter old contact number to replace:");
                    String oldcont = sc.next();
                    System.out.println("enter contact name to replace");
                    String oldname = sc.next();
                    Contact contactold =mb.query(oldname);
                    Contact contactnew = new Contact(newname,newcont);
                    mb.update(contactold,contactnew);
                    break;
                case 4:
                    System.out.println("enter contact name to remove:");
                    String name1 = sc.next();
                    System.out.println("enter contact num to remove");
                    String cont1 = sc.next();
                    Contact contact1 = mb.query(name1);
                    mb.remove(contact1);
                    break;
                case 5:
                    System.out.println("enter contact number :");
                    String cont2 = sc.next();
                    System.out.println("enter contact name");
                    String name2 = sc.next();
                    System.out.println(mb.query(name2));
                    break;
                case 6:
                    printinst();
                    break;

                default:
                    System.out.println("Wrong choice");
                    break;

            }
        }


    }
    public static void addnum()
    {
        System.out.println("enter contact name:");
        String name = sc.next();
        System.out.println("enter contact number:");
        String cont = sc.next();
        Contact contact = new Contact(name,cont);
        mb.addCont(contact);
    }
    public static void mobon()
    {
        System.out.println("Mobile is turming on.....");
    }
    public static void printinst()
    {
        System.out.println("0  - toshutdown\n"+
                "1  - to print contacts\n"+
                "2  -  to add a new contact\n"+
                "3  -   to update contact\n"+
                "4  -    to remove contact\n"+
                "5  - query\n"+
                "6  - print list of action availaible");
    }








}
