/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jadiarushilproject2;
import java.util.*;

/**
 *
 * @author rushiljadia
 */
public class BookstoreDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore();
        int option = 0;
        Scanner scnr = new Scanner(System.in);
        while (option != 4)
        {
            System.out.println("**************************");
            System.out.println("Welcome to RJ's Bookstore!");
            System.out.println("**************************");
            System.out.println("Please select a valid number below:");
            System.out.println("\t 1. Register a member.");
            System.out.println("\t 2. Make a purchase.");
            System.out.println("\t 3. Get information on members.");
            System.out.println("\t 4. Compare prices.");
            System.out.println("\t 5. Restock products.");
            System.out.println("\t 6. Get Inventory Value.");
            System.out.println("\t 7. Exit.");
            option = scnr.nextInt();
            scnr.nextLine();
            switch(option)
            {
                case 1:
                    System.out.println("What is your name?");
                    String name = scnr.nextLine();
                    System.out.println("Hello " + name + "!");                    
                    System.out.println("Are you a Premium Member? (true/false)");
                    boolean isPremium = scnr.nextBoolean();

                    if (isPremium)
                    {
                        System.out.println("Will you be paying the monthly dues? (true/false)");
                        boolean isPaying = scnr.nextBoolean();

                        if (isPaying)
                        {
                            bookstore.addNewPremiumMember(name, isPremium);
                            System.out.println("Congrats! We have added a new premium member. \nPremium ID: " + bookstore.getPremiumId());
                            System.out.println(bookstore.getPremiumMembersInventory());
                        }
                        else
                        {
                            System.out.println("You have to pay your dues to become a premium member.");
                            break;
                        }
                    }
                    else 
                    {
                        bookstore.addNewMember(name, isPremium);
                        System.out.println("Welcome! A new member has been added. \n ID: " + bookstore.getMemberId());
                    }
                    break;
                case 2:
                    System.out.println("Are you a Regular or a Premium Member?");
                    Member customer;
                    String customerChoice = scnr.nextLine();
                    if (customerChoice.contains("a"))
                    {
                        System.out.println("What is your Regular Member ID?");
                        int regularId = scnr.nextInt();
                        customer = bookstore.searchMemberId(regularId);
                        scnr.nextLine();
                    }
                    else
                    {
                        System.out.println("What is your Premium Member ID?");
                        int premiumId = scnr.nextInt();
                        customer = bookstore.searchPremiumMemberId(premiumId);
                        scnr.nextLine();
                    }
                    
                    System.out.println("What are you interested in purchasing? \n1. Book \n2. CD \n3. DVD");
                    int purchaseOption = scnr.nextInt();
                    switch (purchaseOption)
                    {
                        case 1:
                            bookstore.displayBookInventory();
                            System.out.println("What Book would you like to purchase? (1-5)");
                            int bookId = scnr.nextInt() - 1;
                            Book bookChosen = bookstore.getBookInventory().get(bookId);
                            if (bookChosen.getStock() == 0)
                            {
                                System.out.println("This item is out of stock. Please choose another book.");
                            }
                            else
                            {
                                bookstore.removeBook(bookChosen);
                                System.out.println("Thank you for your purchase. Your total cost is: $" + bookChosen.getPrice());
                            }
                            break;
                        case 2:
                            bookstore.displayCDInventory();
                            System.out.println("What CD would you like to purchase? (1-5)");
                            int cdId = scnr.nextInt() - 1;
                            CD cdChosen = bookstore.getCDInventory().get(cdId);
                            if (cdChosen.getStock() == 0)
                            {
                                System.out.println("This item is out of stock. Please choose another CD.");
                            }
                            else
                            {
                                bookstore.removeCD(cdChosen);
                                System.out.println("Thank you for your purchase. Your total cost is: $" + cdChosen.getPrice());
                            }
                            break;
                        case 3:
                            bookstore.displayDVDInventory();
                            System.out.println("What DVD would you like to purchase? (1-5)");
                            int dvdId = scnr.nextInt() - 1;
                            DVD dvdChosen = bookstore.getDVDInventory().get(dvdId);
                            if (dvdChosen.getStock() == 0)
                            {
                                System.out.println("This item is out of stock. Please choose another DVD.");
                            }
                            else
                            {
                                bookstore.removeDVD(dvdChosen);
                                System.out.println("Thank you for your purchase. Your total cost is: $" + dvdChosen.getPrice());
                            }
                            break;
                        default:
                            System.out.println("Please enter a valid number.");
                    }
                    break;
                case 3:
                    System.out.println("Do you want to search for a Regular or a Premium Member?");
                    String searchOption = scnr.nextLine();
                    if (searchOption.contains("m"))
                    {
                        System.out.println("What is the ID of the Premium Member?");
                        int preId = scnr.nextInt();
                        PremiumMember premiumSearch = bookstore.searchPremiumMemberId(preId);
                        System.out.println(premiumSearch.toString());
                    }
                    else
                    {
                        System.out.println("What is the ID of the Regular Member?");
                        int regId = scnr.nextInt();
                        Member memberSearch = bookstore.searchMemberId(regId);
                        System.out.println(memberSearch.toString());
                    }
                    break;
                case 4:
                    System.out.println("Here are the products we offer. (Books, CDs, DVDs)");
                    bookstore.displayBookInventory();
                    bookstore.displayCDInventory();
                    bookstore.displayDVDInventory();
                    System.out.println("What is the first type of product you would like to compare? (Book, CDs, DVDs)");
                    String compareType1 = scnr.nextLine();
                    Product prod1 = null;
                    Product prod2 = null;
                    if (compareType1.contains("k"))
                    {
                        System.out.println("Please enter the ID of the Book you would like to compare.");
                        int comp1 = scnr.nextInt();
                        prod1 = bookstore.searchBookById(comp1);
                        scnr.nextLine();
                    }
                    if (compareType1.contains("c"))
                    {
                        System.out.println("Please enter the ID of the CD you would like to compare.");
                        int comp1 = scnr.nextInt();
                        prod1 = bookstore.searchCDById(comp1);
                        scnr.nextLine();
                    }
                    if (compareType1.contains("v"))
                    {
                        System.out.println("Please enter the ID of the DVD you would like to compare.");
                        int comp1 = scnr.nextInt();
                        prod1 = bookstore.searchDVDById(comp1);
                        scnr.nextLine();
                    }
                    System.out.println("What is the type of the second product you would like to compare? (Book, CDs, DVDs)");
                    String compareType2 = scnr.nextLine();
                    if (compareType2.contains("k"))
                    {
                        System.out.println("Please enter the ID of the Book you would like to compare.");
                        int comp2 = scnr.nextInt();
                        prod2 = bookstore.searchBookById(comp2);
                        scnr.nextLine();
                    }
                    if (compareType2.contains("c")||compareType2.contains("C"))
                    {
                        System.out.println("Please enter the ID of the CD you would like to compare.");
                        int comp2 = scnr.nextInt();
                        prod2 = bookstore.searchCDById(comp2);
                        scnr.nextLine();
                    }
                    if (compareType2.contains("v"))
                    {
                        System.out.println("Please enter the ID of the DVD you would like to compare.");
                        int comp2 = scnr.nextInt();
                        prod2 = bookstore.searchDVDById(comp2);
                        scnr.nextLine();
                    }
                    prod1.toString();
                    prod2.toString();
                    int compareResult = prod1.compareTo(prod2);
                    System.out.println(compareResult);
                    break;
                case 5:
                    System.out.println("What product type would you like to restock? (Book, CDs, DVDs)");
                    String restockType = scnr.nextLine();                    
                    if (restockType.contains("k"))
                    {
                        bookstore.displayBookInventory();
                        System.out.println("Please enter the ID of the Book you would like to restock.");
                        int restockID = scnr.nextInt() - 1;
                        Book bookChosen = bookstore.getBookInventory().get(restockID);
                        System.out.println("How much quantity would you like to restock?");
                        int restockQuantity = scnr.nextInt();
                        bookstore.restockBook(restockID, restockQuantity);
                        scnr.nextLine();
                    }
                    if (restockType.contains("c") || restockType.contains("C"))
                    {
                        bookstore.displayCDInventory();
                        System.out.println("Please enter the ID of the CD you would like to restock.");
                        int restockID = scnr.nextInt() - 1;
                        System.out.println("How much quantity would you like to restock?");
                        int restockQuantity = scnr.nextInt();
                        bookstore.restockCD(restockID, restockQuantity);
                        scnr.nextLine();
                    }
                    if (restockType.contains("v"))
                    {
                        bookstore.displayDVDInventory();
                        System.out.println("Please enter the ID of the DVD you would like to restock.");
                        int restockID = scnr.nextInt() - 1;
                        System.out.println("How much quantity would you like to restock?");
                        int restockQuantity = scnr.nextInt();
                        bookstore.restockDVD(restockID, restockQuantity);
                        scnr.nextLine();
                    }
                    break;
                case 6:
                    double invValue = bookstore.inventoryValue();
                    System.out.println("The total value of the Inventory is: $" + invValue);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Please enter a valid number.");
            }
        }
    }
}