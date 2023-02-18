/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jadiarushilproject2;
import java.util.*;

/**
 *
 * @author rushiljadia
 */
public class Bookstore implements BookstoreSpecification{
    //fields
    private static int memberId = 1;
    private static int premiumId = 1;
    private static boolean hasPaid;
    
    //ArrayLists
    private ArrayList<Book> bookInventory = new ArrayList<Book>();
    private ArrayList<CD> cdInventory = new ArrayList<CD>();
    private ArrayList<DVD> dvdInventory = new ArrayList<DVD>();
    private ArrayList<Member> membersInventory = new ArrayList<Member>();
    private ArrayList<PremiumMember> premiumMembersInventory = new ArrayList<PremiumMember>();
    
    //constructor
    public Bookstore(){
        generateInventory();
    }
    
    //methods
    public void generateInventory()
    {
        //Books
        bookInventory.add(new Book(1, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 12.00, 5));
        bookInventory.add(new Book(2, "Harry Potter and the Chamber of Secrets", "J.K. Rowling", 10.00, 12));
        bookInventory.add(new Book(3, "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 8.00, 8));
        bookInventory.add(new Book(4, "Divergent", "Veronica Roth", 9.00, 0));
        bookInventory.add(new Book(5, "The Hunger Games", "Suzanne Collins", 8.00, 3));
        
        //CDs
        cdInventory.add(new CD(1, "good kid, m.A.A.d city", "Kendrick Lamar", 15.00, 15));
        cdInventory.add(new CD(2, "Take Care", "Drake", 13.00, 0));
        cdInventory.add(new CD(3, "2014 Forest Hills Drive", "J. Cole", 16.00, 0));
        cdInventory.add(new CD(4, "Views", "Drake", 13.00, 12));
        cdInventory.add(new CD(5, "Because the Internet", "Childish Gambino", 18.00, 14));
        
        //DVDs
        dvdInventory.add(new DVD(1, "The Dark Knight", "Cristopher Nolan", 20.00, 0));
        dvdInventory.add(new DVD(2, "Kill Bill", "Quentin Tarantino", 25.00, 20));
        dvdInventory.add(new DVD(3, "Toy Story", "John Lassester", 30.00, 0));
        dvdInventory.add(new DVD(4, "Avengers: Infinity War", "Russo Brothers", 18.00, 30));
        dvdInventory.add(new DVD(5, "Spider-Man: No Way Home", "Jon Watts", 20.00, 25));
    }
    
    public void generateMembers()
    {
        
    }
    
    public void addNewMember(String n,boolean isPremium)
    {
        membersInventory.add(new Member(n, memberId));
        memberId++;
    }
    
    public void addNewPremiumMember(String n, boolean isPremium)
    {
        premiumMembersInventory.add(new PremiumMember(n, premiumId));
        premiumId++;
    }
    
    public Member searchMemberId(int id)
    {
        for (int i = 0; i < membersInventory.size(); i++)
        {
            if (membersInventory.get(i).getID() == id)
            {
                return membersInventory.get(i);
            }
        }
        return null;
    }
    
    public PremiumMember searchPremiumMemberId(int id)
    {
        for (int i = 0; i < premiumMembersInventory.size(); i++)
        {
            if (premiumMembersInventory.get(i).getID() == id)
            {
                return premiumMembersInventory.get(i);
            }
        }
        return null;
    }
    
    public ArrayList<Book> getBookInventory()
    {
        return bookInventory;
    }
    
    public ArrayList<CD> getCDInventory()
    {
        return cdInventory;
    }
    
    public ArrayList<DVD> getDVDInventory()
    {
        return dvdInventory;
    }
    
    public ArrayList<Member> getMembersInventory()
    {
        return membersInventory;
    }
    
    public ArrayList<PremiumMember> getPremiumMembersInventory()
    {
        return premiumMembersInventory;
    }
    
    public void displayBookInventory()
    {
        for (int i = 0; i < bookInventory.size(); i++)
        {
            bookInventory.get(i).display();
        }
    }
    
    public void displayCDInventory()
    {
        for (int i = 0; i < cdInventory.size(); i++)
        {
            cdInventory.get(i).display();
        }
    }
    
    public void displayDVDInventory()
    {
        for (int i = 0; i < dvdInventory.size(); i++)
        {
            dvdInventory.get(i).display();
        }
    }
    
    public int getMemberId()
    {
        return memberId - 1;
    }
    
    public int getPremiumId()
    {
        return premiumId - 1;
    }
    
    public void removeBook(Book b)
    {
        int currentBookStock = b.getStock();
        b.setStock(currentBookStock - 1);
    }
    
    public void removeDVD(DVD d)
    {
        int currentDVDStock = d.getStock();
        d.setStock(currentDVDStock - 1);
    }
    
    public void removeCD(CD c)
    {
        int currentCDStock = c.getStock();
        c.setStock(currentCDStock - 1);
    }
    
    public Product searchBookById(int id)
    {
        for (int i = 0; i < bookInventory.size(); i++)
        {
            if (bookInventory.get(i).getID() == id) 
            {
                return bookInventory.get(i);
            }
        }
        return null;
    }
    
    public Product searchCDById(int id)
    {
        for (int i = 0; i < cdInventory.size(); i++)
        {
            if (cdInventory.get(i).getID() == id) 
            {
                return cdInventory.get(i);
            }
        }
        return null;
    }
    
    public Product searchDVDById(int id)
    {
        for (int i = 0; i < dvdInventory.size(); i++)
        {
            if (dvdInventory.get(i).getID() == id) 
            {
                return dvdInventory.get(i);
            }
        }
        return null;
    }
    
    @Override
    public void restockBook(int id, int stock)
    {
        Book bookChosen = getBookInventory().get(id);
        bookChosen.restock(id, stock);
    }
    
    @Override
    public void restockCD(int id, int stock)
    {
        CD cdChosen = getCDInventory().get(id);
        cdChosen.restock(id, stock);
    }
    
    @Override
    public void restockDVD(int id, int stock)
    {
        DVD dvdChosen = getDVDInventory().get(id);
        dvdChosen.restock(id, stock);
    }
    
    @Override
    public double inventoryValue()
    {
        double bookInvValue = 0.0; 
        double cdInvValue = 0.0;
        double dvdInvValue = 0.0;
        double totalInvValue = 0.0;
        for (int i = 0; i < bookInventory.size(); i++)
        {
            bookInvValue += bookInventory.get(i).getPrice() * bookInventory.get(i).getStock();
        }
        for (int i = 0; i < cdInventory.size(); i++)
        {
            cdInvValue += cdInventory.get(i).getPrice() * cdInventory.get(i).getStock();
        }
        for (int i = 0; i < dvdInventory.size(); i++)
        {
            dvdInvValue += dvdInventory.get(i).getPrice() * dvdInventory.get(i).getStock();
        }
        totalInvValue = bookInvValue + cdInvValue + dvdInvValue;
        return totalInvValue;
    }
}
