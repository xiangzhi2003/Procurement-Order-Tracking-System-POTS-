
package oodj_assignment_functions;
//
public class SalesEntry {
    //Variable declaration
    private String itemCode;
    private String itemName;
    private String category;
    private int quantity;
    private String date;
    
    // Constructor
    public SalesEntry(String itemCode, String itemName, String category, int quantity, String date) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.category = category;
        this.quantity = quantity;
        this.date = date;
    }

    // Getters
    public String getItemCode() {
        return itemCode;
    }
    public String getItemName() {
        return itemName;
    }
    public String getCategory() {
        return category;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getDate() {
        return date;
    }

    // Setters
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setDate(String date) {
        this.date = date;
    }
    
    
    public String[] toArray() {
        return new String[]{itemCode, itemName, category, String.valueOf(quantity), date};
    }
    
    
    @Override
    public String toString() {
        return String.format("SalesEntry[itemCode=%s, itemName=%s, category=%s, quantity=%d, date=%s]",
            itemCode, itemName, category, quantity, date);
    }
}
