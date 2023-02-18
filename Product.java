/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jadiarushilproject2;

/**
 *
 * @author rushiljadia
 */
public abstract class Product implements Comparable{
    //fields
    private int id;
    private String name;
    private String creator;
    private double price;
    private int stock;
    
    //constructor
    public Product(int id, String n, String c, double p, int s)
    {
        this.id = id;
        this.name = n;
        this.creator = c;
        this.price = p;
        this.stock = s;
    }
    
    //methods
    public int getID()
    {
        return id;
    }
    
    public void setID(int id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String n)
    {
        this.name = n;
    }
    
    public String getCreator()
    {
        return creator;
    }
    
    public void setCreator(String c)
    {
        this.creator = c;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public void setPrice(double p)
    {
        this.price = p;
    }
    
    public int getStock()
    {
        return stock;
    }
    
    public void setStock(int s)
    {
        this.stock = s;
    }
    
    @Override
    public int compareTo(Product o1)
    {
        if (this.getPrice() > o1.getPrice())
        {
            return 1;
        }
        else if (this.getPrice() < o1.getPrice())
        {
            return -1;
        }
        else 
        {
            return 0;
        }
    }
    
    public void restock(int id, int stock)
    {
        int currentStock = getStock();
        System.out.println("This is the current stock of the product: " + currentStock);
        setStock(currentStock + stock);
        int newStock = getStock();
        System.out.println("This is the new stock of the product: " + newStock);
        
    }
    @Override
    public String toString()
    {
        return "ID: " + id + " Name: " + name + " Creator: " + creator + " Price: " + price + " Stock: " + stock;
    }
}
