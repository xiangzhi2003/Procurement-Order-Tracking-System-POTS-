
package oodj_assignment_functions;

/**
 *
 * @author raida
 */
public class SalesItem {

    String itemCode;
    String itemName;
    private String category;
    private double itemPrice;

    //constructor

    public SalesItem(String itemCode, String itemName, String category, double itemPrice) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.category = category;
        this.itemPrice = itemPrice;
    }


    //getter setter
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getItemPrice() {
        return itemPrice;
    }


    public void setItemPrice(double itemPrice) {
        if (itemPrice < 0) {
            throw new IllegalArgumentException("Item price cannot be negative.");
        }
        this.itemPrice = itemPrice;
    }

    
    public SalesItem() {
        // Default constructor
    }

    public String[] toArray() {
        return new String[]{itemCode, itemName, category, String.format("%.2f",itemPrice)};
    }
    
    // toString method
    @Override
    public String toString() {
        return "SalesItem{" +
                "itemCode='" + itemCode + 
                ", itemName='" + itemName +
                ", category='" + category + 
                ", itemPrice=" + itemPrice +
                "}";
    }

    // toCSV method
    public String toCSV() {
        return itemCode + "," + itemName + "," + category + "," + itemPrice;
    }
    
}
