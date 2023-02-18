/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jadiarushilproject2;

/**
 *
 * @author rushiljadia
 */
public interface BookstoreSpecification {
    public void restockBook(int id, int stock);
    public void restockCD(int id, int stock);
    public void restockDVD(int id, int stock);
    public double inventoryValue();
}
