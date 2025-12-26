package oodj_assignment_functions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oodj_assignment.IM_SupplierList;
import oodj_assignment_functions.CRUD;



public class Inventory implements IDGenerator{
    
    @Override
    public String GenerateID()
    {
        
        List<String> lines = crud.readData("src\\oodj_assignment_data\\InventoryData.txt");
        List<Integer> numOfID = new ArrayList<>();
        for(String line : lines)
        {
            numOfID.add(Integer.valueOf((line.split(",")[0].substring(1))));
        }
        Collections.sort(numOfID);
        int LastID = numOfID.getLast();
        return  String.format("I%03d", LastID+1);
    }
    
    public void EditInventoryItem(String itemCode, String newName, double newPrice, int newStock, int newMinStock, 
                               String newStatus, String newQuantityReq, String newSupplierID, String newSupplierName) 
    {
    // Read the data from the file
    List<String> lines = crud.readData("src\\oodj_assignment_data\\InventoryData.txt");
    boolean itemUpdated = false;
    
    // Iterate through the lines to find the item by itemCode
    for (int i = 0; i < lines.size(); i++) {
        // Split the current line into individual values
        String[] data = lines.get(i).split(",");
        
        // Check if itemCode matches the one we need to update
        if (data[0].equals(itemCode)) {
            // Update the relevant fields with the new data
            data[1] = newName;          // itemName
            data[3] = String.valueOf(newPrice); // itemPrice
            data[4] = String.valueOf(newStock);  // stock
            data[5] = String.valueOf(newMinStock); // minStockAllowed
            data[7] = newStatus;        // stockStatus
            data[8] = newQuantityReq;   // quantityReq
            data[9] = newSupplierID;    // supplierID
            data[10] = newSupplierName; // supplierName
            
            // Rebuild the updated line and replace it in the list
            lines.set(i, String.join(",", data));
            itemUpdated = true;
            break;  // Item found and updated, no need to continue loop
        }
    }
    
    // Check if the item was updated and save it back to the file
    if (itemUpdated) {
        crud.updateData(lines, "src\\oodj_assignment_data\\InventoryData.txt"); 
        JOptionPane.showMessageDialog(null, "Item Updated Successfully");
    } else {
        JOptionPane.showMessageDialog(null, "Failed to Find Item with Item Code: " + itemCode);
    }
}

    CRUD crud = new CRUD();
    public void ViewTable(JTable table) {
        // Define the path to the file
        String FilePath = "src\\oodj_assignment_data\\InventoryData.txt";

        // Get lines from the file as List<String>
        List<String> lines = crud.readData(FilePath);

        // Define table column names
        String[] columnNames = {"Item ID", "Item Name", "Category", "Stock", "Stock Status"};

        // Create a DefaultTableModel with column names
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Iterate over the list of lines
        for (String line : lines) {
            // Split each line by commas to create an array of string values
            String[] row = line.split(",");

            // check row has at least 8 elements to match the required format
            if (row.length >= 8) {
                // Create a vector to store data for each row
                Vector<Object> rowData = new Vector<>();

                // Add the data for the table's row (id, item, category, stock, status)
                rowData.add(row[0]);    // Item ID
                rowData.add(row[1]);    // Item Name
                rowData.add(row[2]);    // Category
                rowData.add(row[4]);    // Stock Quantity (position of stock based on your example data)
                rowData.add(row[7]);    // Stock Status (e.g., "Understock", "Sufficient")

                // Add row data to the table model
                tableModel.addRow(rowData);
            }
        }

        // Set the model to the table
        table.setModel(tableModel);
    }
  
    public void ViewSupplier(JTable table) {
        // Define the path to the file
        String FilePath = "src\\oodj_assignment_data\\InventorySupplier.txt";

        // Get lines from the file as List<String>
        List<String> lines = crud.readData(FilePath);

        // Define table column names
        String[] columnNames = {"Supplier ID", "Supplier Name", "Payment Method", "Payment Due"};

        // Create a DefaultTableModel with column names
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Iterate over the list of lines
       DefaultTableModel Table = new DefaultTableModel(columnNames, 0);

        for (String line : lines) 
        {
            String[] data = line.split(",");
            Vector<String> row = new Vector<>();//initiate a vector
            for (String cell : data)
            {
                row.add(cell.trim());//add every cell to the vector row
            }
            Table.addRow(row);
        }
        table.setModel(Table); //fill the table with vector filled with data from txtfile
    }
    
    public void ViewUnderstock(JTable table) {
    // iventory data file path
    String FilePath = "src\\oodj_assignment_data\\InventoryData.txt";

    // Get lines from the file as List<String>
    List<String> lines = crud.readData(FilePath);

    // Define table column names
    String[] columnNames = {"Item ID", "Item Name", "Category", "Stock", "Stock Status"};

    // Create a DefaultTableModel with column names
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

    // Iterate over the list of lines
    for (String line : lines) {
        // Split each line by commas to create an array of string values
        String[] row = line.split(",");

        // Check if row has at least 9 elements (to match the expected format)
        if (row.length >= 7) {
            // Check if the Stock Status is "understock" (case-sensitive)
            if ("Understock".equals(row[7].trim())) {  // Ensure trimming for extra spaces
                // Create a vector to store data for each row
                Vector<Object> rowData = new Vector<>();
                
                // Add the data for the table's row (id, item, category, stock, status)
                rowData.add(row[0]);    // Item ID
                rowData.add(row[1]);    // Item Name
                rowData.add(row[2]);    // Category
                rowData.add(row[4]);    // Stock Quantity (assuming this is the correct index)
                rowData.add(row[7]);    // Stock Status (position for "understock")
                
                // Add row data to the table model
                tableModel.addRow(rowData);
            }
        }
    }

    // Set the model to the table
    table.setModel(tableModel);
}
    public void ViewSufficient(JTable table) {
    // Define the path to the file
    String FilePath = "src\\oodj_assignment_data\\InventoryData.txt";

    // Get lines from the file as List<String>
    List<String> lines = crud.readData(FilePath);

    // Define table column names
    String[] columnNames = {"Item ID", "Item Name", "Category", "Stock", "Stock Status"};

    // Create a DefaultTableModel with column names
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

    // Iterate over the list of lines
    for (String line : lines) {
        // Split each line by commas to create an array of string values
        String[] row = line.split(",");

        // Check if row has at least 8 elements (to match the expected format)
        if (row.length >= 7) {
            // Create a vector to store data for each row
            Vector<Object> rowData = new Vector<>();

            // Check if the Stock Status is "Understock"
            if ("Sufficient".equals(row[7])) {
                // Add the data for the table's row (id, item, category, stock, status)
                rowData.add(row[0]);    // Item ID
                rowData.add(row[1]);    // Item Name
                rowData.add(row[2]);    // Category
                rowData.add(row[4]);    // Stock Quantity
                rowData.add(row[7]);    // Stock Status ("Understock")

                // Add row data to the table model
                tableModel.addRow(rowData);
            }
        }
    }

    // Set the model to the table
    table.setModel(tableModel);
}
    public void ViewAllInventory(JTable table) {
    // Define the path to the inventory data file
    String FilePath = "src\\oodj_assignment_data\\InventoryData.txt";

    // Get lines from the file as List<String>
    List<String> lines = crud.readData(FilePath);

    // Define table column names, corresponding to all fields in your data
    String[] columnNames = {
        "Item Code", "Item Name", "Category", "Item Price", "Stock", 
        "Min Stock Allowed", "Stock Update Date", "Stock Status", 
        "Quantity Required", "Supplier ID", "Supplier Name"
    };

    // Create a DefaultTableModel with column names
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

    // Iterate over the list of lines
    for (String line : lines) {
        // Split each line by commas to create an array of string values
        String[] row = line.split(",");

        // Ensure the row has enough data (at least 11 columns expected)
        if (row.length >= 11) {
            // Create a vector to store data for each row
            Vector<Object> rowData = new Vector<>();

            // Add the data for the table's row based on the updated fields
            rowData.add(row[0]);    // Item Code
            rowData.add(row[1]);    // Item Name
            rowData.add(row[2]);    // Category
            rowData.add(row[3]);    // Item Price
            rowData.add(row[4]);    // Stock
            rowData.add(row[5]);    // Min Stock Allowed
            rowData.add(row[6]);    // Stock Update Date
            rowData.add(row[7]);    // Stock Status
            rowData.add(row[8]);    // Quantity Required
            rowData.add(row[9]);    // Supplier ID
            rowData.add(row[10]);   // Supplier Name

            // Add row data to the table model
            tableModel.addRow(rowData);
        }
    }

    // Set the model to the table to display the data
    table.setModel(tableModel);
}
    public String GenerateID(String s)
    {
        List<String> lines = crud.readData("src\\oodj_assignment_data\\InventorySupplier.txt");
        List<Integer> numOfID = new ArrayList<>();
        for(String line : lines)
        {
            numOfID.add(Integer.valueOf((line.split(",")[0].substring(1))));
        }
        Collections.sort(numOfID);
        int LastID = numOfID.getLast();
        return  String.format("%s%03d", s,LastID+1);
    }
    
    public void addSupplier(String id, String name, String payment, String date)
    {
        IM_SupplierList spl = new IM_SupplierList();
        String newSupplier = String.format("%s,%s,%s,%s", GenerateID("s"), name, payment, date);
        try 
        {
            JOptionPane.showMessageDialog(spl, "Supplier Added Successfully");
            crud.createData(newSupplier, "src\\oodj_assignment_data\\InventorySupplier.txt");
        }
        catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(spl, "Error Adding Supplier");
        }
    }
    
    public void EditSupplier(String id, String newName, String newPayment, String newDate)
    {
        IM_SupplierList spl = new IM_SupplierList();
        List<String> lines = crud.readData("src\\oodj_assignment_data\\InventorySupplier.txt");
        boolean newLines = false;
        
        for (int line = 0; line < lines.size(); line++) 
        {
        String[] data = lines.get(line).split(",");
            //Check if UID match
            if (data[0].equals(id))
            {
                //Update the record with new username, password, role
                data[1] = newName;
                data[2] = newPayment;
                data[3] = newDate;
                lines.set(line, String.join(",", data));//rebuild the updated line and replace it in the list
                newLines = true;
                break;
            }
        }
        if(newLines)
        {
            crud.updateData(lines, "src\\oodj_assignment_data\\InventorySupplier.txt");
            JOptionPane.showMessageDialog(spl, "Details Updated");
        }
        else
        {
            JOptionPane.showMessageDialog(spl, "Failed to Update Data");
        }
    }
    public void DeleteSupplier(String id)
    {
        IM_SupplierList spl = new IM_SupplierList();
        List<String> lines = crud.readData("src\\oodj_assignment_data\\InventorySupplier.txt");
        boolean userDeleted = false;
        
        Iterator<String> iterator = lines.iterator();
        while (iterator.hasNext()) 
        {
            String line = iterator.next();
            String[] data = line.split(",");
            if (data[0].equals(id)) 
            {
                iterator.remove();
                userDeleted = true;
                break;
            }
        }
        if(userDeleted)
        {
            crud.updateData(lines, "src\\oodj_assignment_data\\InventorySupplier.txt");
            JOptionPane.showMessageDialog(spl, "User Deleted Successfully!");
        }
        else
        {
            JOptionPane.showMessageDialog(spl, "Failed to Delete User");
        }}}




//    public boolean DuplicateChecker(String name)
//    {
//        AM_MainForm amf = new AM_MainForm();
//        List<String> lines = crud.readData(FilePath);
//         for (String line : lines) 
//        {
//            String[] data = line.split(",");
//            if (data[1].equals(name)) 
//            {
//                JOptionPane.showMessageDialog(amf, "Username already exists!");
//                return true; // Duplicate found
//            }
//        }  
//    // No duplicate found
//    return false;
//    }
//}
