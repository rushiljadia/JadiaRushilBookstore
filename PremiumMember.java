/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jadiarushilproject2;

/**
 *
 * @author rushiljadia
 */
public class PremiumMember extends Member{
     //fields
    private boolean hasPaidDues;
    private String paymentMethod = "$ - Dollars";
    
    //constructor
    public PremiumMember(String n, int id)
    {
        super(n, id);
        payDues();
    }
    
    //methods
    public boolean hasPaidDues()
    {
        return hasPaidDues;
    }
    
    public void setPaidDues(boolean isPaid)
    {
        this.hasPaidDues = isPaid;
    }
    
    public boolean getHasPaid()
    {
        return hasPaidDues;
    }
    
    public void payDues()
    {
        hasPaidDues = true;
    }
    
    @Override
    public String toString()
    {
        return "Name: " + super.getName() + "\nPremium Member ID: " + super.getID() + "\nNumber of Purchases: " + super.getNumPurchases() + "\nMonthly Dues Paid? " + hasPaidDues + "\nPayment Method: " + paymentMethod;
    }
}
