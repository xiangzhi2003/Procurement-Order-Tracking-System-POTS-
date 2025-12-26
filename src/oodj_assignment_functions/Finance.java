package oodj_assignment_functions;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.*;

public class Finance {
//////////////////////////////////////verifypaymentstatus///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    private String PoId;
    private String PrId;
    private String Suppliername;
    private String Itemname;
    private String ItemPrice;
    private String ItemQuantity;
    private String Date;

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getPrId() {
        return PrId;
    }

    public void setPrId(String PrId) {
        this.PrId = PrId;
    }
    private String Status;

    public String getItemname() {
        return Itemname;
    }

    public void setItemname(String Itemname) {
        this.Itemname = Itemname;
    }

    public String getSuppliername() {
        return Suppliername;
    }

    public void setSuppliername(String Suppliername) {
        this.Suppliername = Suppliername;
    }

    public String getPoId() {
        return PoId;
    }

    public void setPoId(String PoId) {
        this.PoId = PoId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(String ItemPrice) {
        this.ItemPrice = ItemPrice;
    }

    public String getItemQuantity() {
        return ItemQuantity;
    }

    public void setItemQuantity(String ItemQuantity) {
        this.ItemQuantity = ItemQuantity;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    public CRUD getCrud() {
        return crud;
    }

    public void setCrud(CRUD crud) {
        this.crud = crud;
    }

    CRUD crud = new CRUD();
    private final String FilePath = "src/oodj_assignment_data/PurchaseOrder.txt";  // Update file path     

    // Method to populate the JTable with data from the PurchaseOrder.txt file
    public void PopulatePurchaseOrderTable(JTable table) {
    // Read data from file
    List<String> lines = crud.readData(FilePath);
    System.out.println("Lines read from file: " + lines);  // Debugging

    // Define table column names
    String[] columnNames = {"PoID", "PrID", "SupplierName", "ItemName", "ItemPrice", "ItemQuantity", "Date", "Status" , "Payment"};
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

    // Loop through each line from the file
    for (String line : lines) {
        String[] data = line.split(",");  // Split by comma
        Vector<String> row = new Vector<>();

        for (int i = 0; i < columnNames.length; i++) {
            if (i < data.length) {
                // Add existing data, trimmed
                row.add(data[i].trim());
            } else {
                // For missing columns, add "-"
                row.add("-");
            }
        }

        // Add the processed row to the table model
        tableModel.addRow(row);
    }

    // Set the table model and refresh the JTable
    table.setModel(tableModel);
    table.revalidate();  // Ensure the table updates its layout
    table.repaint();     // Redraw the table
}


    // Method to approve a specific purchase order by ID
        // Approve a purchase order
    public void approvePurchaseOrder(String PoId, JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).equals(PoId)) {
                tableModel.setValueAt("Approve", i, 7); // Update Status to Approve
                updateFileWithNewData(tableModel, PoId);
                JOptionPane.showMessageDialog(null, "Purchase Order " + PoId + " approved.");
                break;
            }
        }
    }
    
    // Method to approve a specific purchase order by ID
    // Reject a purchase order
    public void rejectPurchaseOrder(String PoId, JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).equals(PoId)) {
                tableModel.setValueAt("Reject", i, 7); // Update Status to Reject
                updateFileWithNewData(tableModel, PoId);
                JOptionPane.showMessageDialog(null, "Purchase Order " + PoId + " rejected.");
                break;
            }
        }
    }

    // Method to update the file with the new data
     // Update only the row matching the PoID in the file
    private void updateFileWithNewData(DefaultTableModel tableModel, String PoId) {
        try {
            List<String> lines = crud.readData(FilePath);
            List<String> updatedLines = new ArrayList<>();

            for (String line : lines) {
                String[] data = line.split(",");
                if (data.length > 0 && data[0].equals(PoId)) {
                    StringBuilder updatedRow = new StringBuilder();
                    int rowIndex = findRowIndexByPoId(tableModel, PoId);

                    if (rowIndex != -1) {
                        for (int j = 0; j < tableModel.getColumnCount(); j++) {
                            updatedRow.append(tableModel.getValueAt(rowIndex, j));
                            if (j < tableModel.getColumnCount() - 1) {
                                updatedRow.append(",");
                            }
                        }
                    }
                    updatedLines.add(updatedRow.toString());
                } else {
                    updatedLines.add(line);
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FilePath))) {
                for (String updatedLine : updatedLines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }
            System.out.println("File updated for PoID: " + PoId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

////////////////////////////////////////////////makepayment/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String Payment;
    
    public String getPayment() {
        return Payment;
    }

    public void setPayment(String Payment) {
        this.Payment = Payment;
    }
    public void PopulateMakePaymentTable(JTable table) {
    // Read data from file
    List<String> lines = crud.readData(FilePath);
    System.out.println("Lines read from file: " + lines);  // Debugging

    // Define table column names
    String[] columnNames = {"PoID", "PrID", "SupplierName", "ItemName", "ItemPrice", "ItemQuantity", "Date", "Status" , "Payment"};
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

    // Loop through each line from the file
    for (String line : lines) {
        String[] data = line.split(",");  // Split by comma

        // Check if the "Verification" column is "Approve"
        if (data.length >= 8 && data[7].trim().equalsIgnoreCase("Approve")) {
            Vector<String> row = new Vector<>();
            for (int i = 0; i < columnNames.length; i++) {
                if (i < data.length) {
                    // Add existing data, trimmed
                    row.add(data[i].trim());
                } else if (i == 8) {
                    // Add "-" for missing "Payment" column
                    row.add("-");
                }
            }
            tableModel.addRow(row);  // Add row to table model
        }
    }

    // Set the table model and refresh the JTable
    table.setModel(tableModel);
    table.revalidate();  // Ensure the table updates its layout
    table.repaint();     // Redraw the table
}

    
    // Method to approve a specific purchase order by ID
    public void SuccessMakePayment(String PoId, JTable table) {
    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
    for (int i = 0; i < tableModel.getRowCount(); i++) {
        if (tableModel.getValueAt(i, 0).equals(PoId)) {
            tableModel.setValueAt("Paid", i, 8); // Update Payment to Paid
            updateFileWithNewData(tableModel, PoId);
            
            // Append the paid purchase order to PaymentHistory.txt
            appendPaymentToHistory(tableModel, i);
            
            JOptionPane.showMessageDialog(null, "Payment for Purchase Order " + PoId + " successful.");
            break;
        }
    }
}
    
    // Find row index by PoID in the table model
    private int findRowIndexByPoId(DefaultTableModel tableModel, String PoId) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).equals(PoId)) {
                return i;
            }
        }
        return -1; // Not found
    }
    
    // CRUD Helper class (Stub for example purposes)
    static class CrudHelper {
        public List<String> readData(String filePath) {
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return lines;
        }
    }

///////////////////////////////////////////////////////////////stockstatus//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    private String Itemcode;
    private String ItemName;
    private String Category;
    private String Itemprice;
    private String Stock;
    private String MinStockAllowed;
    private String StockUpdateDate;
    private String StockStatus;
    private String QuantityReq;
    private String SupplierID;
    private String SupplierName;

    public String getItemcode() {
        return Itemcode;
    }

    public void setItemcode(String Itemcode) {
        this.Itemcode = Itemcode;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getItemprice() {
        return Itemprice;
    }

    public void setItemprice(String Itemprice) {
        this.Itemprice = Itemprice;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String Stock) {
        this.Stock = Stock;
    }

    public String getMinStockAllowed() {
        return MinStockAllowed;
    }

    public void setMinStockAllowed(String MinStockAllowed) {
        this.MinStockAllowed = MinStockAllowed;
    }

    public String getStockUpdateDate() {
        return StockUpdateDate;
    }

    public void setStockUpdateDate(String StockUpdateDate) {
        this.StockUpdateDate = StockUpdateDate;
    }

    public String getStockStatus() {
        return StockStatus;
    }

    public void setStockStatus(String StockStatus) {
        this.StockStatus = StockStatus;
    }

    public String getQuantityReq() {
        return QuantityReq;
    }

    public void setQuantityReq(String QuantityReq) {
        this.QuantityReq = QuantityReq;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(String SupplierID) {
        this.SupplierID = SupplierID;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String SupplierName) {
        this.SupplierName = SupplierName;
    }
    
    private final String FilePath1 = "src/oodj_assignment_data/InventoryData.txt";  // Update file path 
// Update file path 
    
    // Method to populate the JTable with data from the StockStatus.txt file
    public void PopulateStockStatusTable(JTable table) {
        // Read data from file
        List<String> lines = crud.readData(FilePath1);
        System.out.println("Lines read from file: " + lines);  // Debugging

        // Define table column names   
        String[] columnNames = {"itemCode", "itemName", "category", "itemPrice", "stock", "minStockAllowed", "stockUpdateDate", "stockStatus", "quantutyReq", "supplierID", "supplierName"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Loop through each line from the file
        for (String line : lines) {
            String[] data = line.split(",");  // Split by comma
            Vector<String> row = new Vector<>();
            for (String cell : data) {
                row.add(cell.trim());  // Add trimmed data to row
            }
            tableModel.addRow(row);  // Add row to table model
        }

        // Set the table model and refresh the JTable
        table.setModel(tableModel);
        table.revalidate();  // Ensure the table updates its layout
        table.repaint();     // Redraw the table
    }
/////////////////////////////////////////////////////////////////////payment history///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    
    private boolean isPoInPaymentHistory(String PoId) {
    List<String> lines = crud.readData(FilePath2);
    for (String line : lines) {
        String[] data = line.split(",");
        if (data.length > 0 && data[0].equals(PoId)) {
            return true; // PO already exists in the payment history
        }
    }
    return false;
}

    private void appendPaymentToHistory(DefaultTableModel tableModel, int rowIndex) {
        String PoId = tableModel.getValueAt(rowIndex, 0).toString();
        if (isPoInPaymentHistory(PoId)) {
            JOptionPane.showMessageDialog(null, "Payment history already contains PO " + PoId, "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FilePath2, true))) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                row.append(tableModel.getValueAt(rowIndex, j));
                if (j < tableModel.getColumnCount() - 1) {
                    row.append(",");
                }
            }
            writer.write(row.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating payment history file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private final String FilePath2 = "src/oodj_assignment_data/PaymentHistory.txt";  // Update file path 
    public void PopulatePaymentHistoryTable(JTable table) {
        // Read data from file
        List<String> lines = crud.readData(FilePath2);
        System.out.println("Lines read from file: " + lines);  // Debugging

        // Define table column names   
        String[] columnNames = {"PoID", "PrId", "SupplierName", "ItemName", "ItemPrice", "ItemQuantity", "Date", "Status" , "Payment"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Loop through each line from the file
        for (String line : lines) {
            String[] data = line.split(",");  // Split by comma
            Vector<String> row = new Vector<>();
            for (String cell : data) {
                row.add(cell.trim());  // Add trimmed data to row
            }
            tableModel.addRow(row);  // Add row to table model
        }

        // Set the table model and refresh the JTable
        table.setModel(tableModel);
        table.revalidate();  // Ensure the table updates its layout
        table.repaint();     // Redraw the table
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Main method to test the functionality
    public static void main(String[] args) {
        // Create a frame to hold the table
        JFrame frame = new JFrame("Purchase Order");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JTable
        JTable table = new JTable();

        // Create an instance of Finance and populate the table
        Finance finance = new Finance();
        finance.PopulatePurchaseOrderTable(table);

        // Add the table to the frame inside a scroll pane
        frame.add(new JScrollPane(table));

        // Set frame settings
        frame.pack();
        frame.setLocationRelativeTo(null);  // Center the frame
        frame.setVisible(true);  // Make the frame visible
    }

    public void PopulateUserTable(JTable PO_Table) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
