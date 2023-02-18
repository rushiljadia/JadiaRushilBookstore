/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jadiarushilproject2;

/**
 *
 * @author rushiljadia
 */
public class CD extends Product{
    
    //constructor
    public CD(int id, String n, String a, double p, int s)
    {
        super(id,n,a,p,s);
    }
    
    public void display()
    {
        System.out.println("#" + super.getID() + " Name: " + super.getName() + " Artist: " + super.getCreator() + " Price: " + super.getPrice() + " Stock: " + super.getStock());
    }
    @Override
    public String toString()
    {
        return "#" + super.getID() + " Name: " + super.getName() + " Artist: " + super.getCreator() + " Price: " + super.getPrice() + " Stock: " + super.getStock();
    }
}
