
package oodj_assignment_functions;

/**
 *
 * @author raida
 */


public class StockLevel  {
    
    private String itemCode, itemName, category, stockUpdateDate, stockStatus, quantityReq, supplierID, supplierName;
        private double itemPrice;
        private int stock, minStockAllowed;

        // Constructor
        public StockLevel(String itemCode, String itemName, String category, double itemPrice,
                          int stock, int minStockAllowed, String stockUpdateDate, 
                          String stockStatus, String quantityReq, String supplierID, String supplierName) {
            this.itemCode = itemCode;
            this.itemName = itemName;
            this.category = category;
            this.itemPrice = itemPrice;
            this.stock = stock;
            this.minStockAllowed = minStockAllowed;
            this.stockUpdateDate = stockUpdateDate;
            this.stockStatus = stockStatus;
            this.quantityReq = quantityReq;
            this.supplierID = supplierID;
            this.supplierName = supplierName;
        }

        // Getters and setters
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
            this.itemPrice = itemPrice;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public int getMinStockAllowed() {
            return minStockAllowed;
        }

        public void setMinStockAllowed(int minStockAllowed) {
            this.minStockAllowed = minStockAllowed;
        }

        public String getStockUpdateDate() {
            return stockUpdateDate;
        }

        public void setStockUpdateDate(String stockUpdateDate) {
            this.stockUpdateDate = stockUpdateDate;
        }

        public String getStockStatus() {
            return stockStatus;
        }

        public void setStockStatus(String stockStatus) {
            this.stockStatus = stockStatus;
        }

        public String getQuantityReq() {
            return quantityReq;
        }

        public void setQuantityReq(String quantityReq) {
            this.quantityReq = quantityReq;
        }

        public String getSupplierID() {
            return supplierID;
        }

        public void setSupplierID(String supplierID) {
            this.supplierID = supplierID;
        }

        public String getSupplierName() {
            return supplierName;
        }

        public void setSupplierName(String supplierName) {
            this.supplierName = supplierName;
        }

        @Override
        public String toString() {
            return "StockLevel{" +
                   "itemCode='" + itemCode + '\'' +
                   ", itemName='" + itemName + '\'' +
                   ", category='" + category + '\'' +
                   ", itemPrice=" + itemPrice +
                   ", stock=" + stock +
                   ", minStockAllowed=" + minStockAllowed +
                   ", stockUpdateDate='" + stockUpdateDate + '\'' +
                   ", stockStatus='" + stockStatus + '\'' +
                   ", quantityReq='" + quantityReq + '\'' +
                   ", supplierID='" + supplierID + '\'' +
                   ", supplierName='" + supplierName + '\'' +
                   '}';
        }

        public String toCSV() {
            return itemCode + "," + itemName + "," + category + "," + itemPrice + "," 
                    + stock + "," + minStockAllowed + "," + stockUpdateDate + "," 
                    + stockStatus + "," + quantityReq + "," + supplierID + "," + supplierName;
        }

        public Object[] toArray() {
            return new Object[] { 
                getItemCode(), 
                getItemName(), 
                getCategory(), 
                getItemPrice(), 
                getStock(), 
                getMinStockAllowed(), 
                getStockUpdateDate(), 
                getStockStatus(), 
                getQuantityReq(),
                getSupplierID(),
                getSupplierName()
            };
        }
        
}
