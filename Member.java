/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jadiarushilproject2;

/**
 *
 * @author rushiljadia
 */
public class Member {
    //fields
    private String name;
    public int ID;
    private int numPurchases;
    
    //constructor
    public Member(String n, int id)
    {
        this.name = n;
        this.ID = id;
    }
    
    //methods
    public String getName()
    {
        return name;
    }
    
    public void setName(String n)
    {
        this.name = n;
    }
    
    public int getID()
    {
        return ID;
    }
    
    public void setID(int id)
    {
        this.ID = id;
    }
    
    public int getNumPurchases()
    {
        return numPurchases;
    }
    
    public void setNumPurchases(int num)
    {
        this.numPurchases = num;
    }
    
    public String toString()
    {
        return "Name: " + name + "\nMember ID: " + ID + "\nNumber of Purchases: " + numPurchases;
    }
}
