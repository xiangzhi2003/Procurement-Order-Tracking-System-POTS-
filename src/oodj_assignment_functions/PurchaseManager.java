/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj_assignment_functions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oodj_assignment.PM_PurchaseOrder;

/**
 *
 * @author Lenovo
 */
public class PurchaseManager implements IDGenerator
{
    CRUD crud = new CRUD();
    String FilePath;
    
    public void ViewItem(JTable table) 
    {
        FilePath = "src\\oodj_assignment_data\\InventoryData.txt";
        List<String> lines = crud.readData(FilePath);
        
        String[] columnNames = {"Item ID", "Item Name", "Stock", "StockStatus"};
        //assign name for column
        DefaultTableModel Table = new DefaultTableModel(columnNames, 0);
        
        boolean isFirstLine = true;
        for (String line : lines) 
        {
            if (isFirstLine) 
            {
                isFirstLine = false; // Skip the first line
                continue;
            }

            String[] data = line.split(","); // Split the line into columns

            // Check if the line has enough columns
            if (data.length > 7) 
            {
                Vector<String> row = new Vector<>();
                row.add(data[0].trim());
                row.add(data[1].trim());
                row.add(data[4].trim());
                row.add(data[7].trim());
                Table.addRow(row);
            }
        }
    table.setModel(Table);
    }
    
    public void ViewSupplier(JTable table) 
    {
        FilePath = "src\\oodj_assignment_data\\InventorySupplier.txt";
        List<String> lines = crud.readData(FilePath);
        
        String[] columnNames = {"SupplierID", "SupplierName", "PaymentMethod", "PaymentDue"};
        //assign name for column
        DefaultTableModel Table = new DefaultTableModel(columnNames, 0);
        
        boolean isFirstLine = true;
        for (String line : lines) 
        {
            if (isFirstLine) 
            {
                isFirstLine = false; // Skip the first line
                continue;
            }

            String[] data = line.split(",");
            Vector<String> row = new Vector<>();
            for (String cell : data)
            {
                row.add(cell.trim());
            }
            Table.addRow(row);
        }
        table.setModel(Table); //fill the table with vector filled with data from txtfile
    }
    
    public void ViewPO(JTable table) 
    {
        FilePath = "src\\oodj_assignment_data\\PurchaseOrder.txt";
        List<String> lines = crud.readData(FilePath);
        
        String[] columnNames = {"PO ID", "PR ID", "SupplierName", "ItemName", "ItemPrice", "ItemQuantity", "PRDate","Status"};
        //assign name for column
        DefaultTableModel Table = new DefaultTableModel(columnNames, 0);
        
        for (String line : lines)
        {
            String[] data = line.split(",");
            Vector<String> row = new Vector<>();
            for (String cell : data)
            {
                row.add(cell.trim());
            }
            Table.addRow(row);
        }
        table.setModel(Table); //fill the table with vector filled with data from txtfile
    }
    
    public void ViewPR(JTable table) 
    {
        FilePath = "src\\oodj_assignment_data\\PurchaseRequisition.txt";
        List<String> lines = crud.readData(FilePath);
        
        String[] columnNames = {"PrID", "itemID","Quantity","PRDate","supplierID","prStatus"};
        //assign name for column
        DefaultTableModel Table = new DefaultTableModel(columnNames, 0);
        
        boolean isFirstLine = true;
        for (String line : lines)
        {
            if (isFirstLine) 
            {
                isFirstLine = false; // Skip the first line
                continue;
            }
            String[] data = line.split(",");
            Vector<String> row = new Vector<>();
            for (String cell : data)
            {
                row.add(cell.trim());
            }
            Table.addRow(row);
        }
        table.setModel(Table);
    }
    
    public void generatePurchaseOrder(String selectedPRID) 
    {
        PM_PurchaseOrder po = new PM_PurchaseOrder();
        List<String> prData = crud.readData("src\\oodj_assignment_data\\PurchaseRequisition.txt");
        List<String> inventoryData = crud.readData("src\\oodj_assignment_data\\InventoryData.txt");
        List<String> supplierData = crud.readData("src\\oodj_assignment_data\\InventorySupplier.txt");

        List<String> purchaseOrderData = crud.readData("src\\oodj_assignment_data\\PurchaseOrder.txt");
        if (purchaseOrderData.isEmpty()) 
        {
            purchaseOrderData.add("PO ID,PR ID,SupplierName,ItemName,ItemPrice,ItemQty,PRDate,PO Status");
        }

        List<String> updatedPRData = new ArrayList<>();
        updatedPRData.add(prData.get(0)); // Add the header line from PR file

        boolean isProcessed = false;
        int poCounter = purchaseOrderData.size(); // Use existing lines to determine PO ID counter

        for (String prLine : prData) 
        {
                if (prLine.startsWith("PrID")) continue; // Skip header line

                String[] prParts = prLine.split(",");
                String prID = prParts[0];
                String prStatus = prParts[5];

                if (prID.equals(selectedPRID) && prStatus.equals("Pending")) 
                {
                    String itemID = prParts[1];
                    int itemQty = Integer.parseInt(prParts[2]);
                    String prDate = prParts[3];
                    String supplierID = prParts[4];

                    // Get Supplier Name
                    String supplierName = null;
                    for (String supplierLine : supplierData) 
                    {
                        if (supplierLine.startsWith("supplierID")) continue; // Skip header line
                        String[] supplierParts = supplierLine.split(",");
                        if (supplierParts[0].equals(supplierID)) 
                        {
                            supplierName = supplierParts[1];
                            break;
                        }
                    }

                    // Get Item Name and Item Price
                    String itemName = null;
                    double itemPrice = 0.0;
                    for (String inventoryLine : inventoryData) 
                    {
                        if (inventoryLine.startsWith("itemCode")) continue; // Skip header line
                        String[] inventoryParts = inventoryLine.split(",");
                        if (inventoryParts[0].equals(itemID)) 
                        {
                            itemName = inventoryParts[1];
                            itemPrice = Double.parseDouble(inventoryParts[3]);
                            break;
                        }
                    }

                    // Ensure all data is found
                    if (supplierName != null && itemName != null) 
                    {
                        String poID = String.format("PO%03d", poCounter++);
                        String purchaseOrderLine = String.format("%s,%s,%s,%s,%.2f,%d,%s,Pending", GenerateID(), prID, supplierName, itemName, itemPrice, itemQty, prDate);
                        purchaseOrderData.add(purchaseOrderLine);

                        // Update the PR status to "Completed"
                        String updatedPRLine = String.format("%s,%s,%d,%s,%s,Completed", prID, itemID, itemQty, prDate, supplierID);
                        updatedPRData.add(updatedPRLine);

                        isProcessed = true;
                    }
                } 
                else 
                {
                    // Keep other PR records unchanged
                    updatedPRData.add(prLine);
                }
            }

            if (isProcessed) 
            {
                // Write to PurchaseOrder.txt
                crud.updateData(purchaseOrderData, "src\\oodj_assignment_data\\PurchaseOrder.txt");

                // Update PurchaseRequisition.txt with updated PR data
                crud.updateData(updatedPRData, "src\\oodj_assignment_data\\PurchaseRequisition.txt");

                JOptionPane.showMessageDialog(po, "Purchase order created successfully");
            } 
            else 
            {
                JOptionPane.showMessageDialog(po, "Failed to create purchase order");
            }
    }
    
    @Override
    public String GenerateID()
    {
        FilePath = "src\\oodj_assignment_data\\PurchaseOrder.txt";
        List<String> lines = crud.readData(FilePath);
        List<Integer> numOfID = new ArrayList<>();
        for(String line : lines)
        {
            numOfID.add(Integer.valueOf((line.split(",")[0].substring(2))));
        }
        Collections.sort(numOfID);
        int LastID = numOfID.getLast();
        return  String.format("PO%03d", LastID+1);
    }
    
    public void FillComboBox(JComboBox<String> comboBox) {
        FilePath = "src\\oodj_assignment_data\\PurchaseOrder.txt";
        List<String> lines = crud.readData(FilePath);
        Set<String> supplierNames = new HashSet<>();
        for (String line : lines) 
        {
            String[] SupplierName = line.split(",");
            supplierNames.add(SupplierName[1].trim()); // Add supplier name
        }
        comboBox.removeAllItems(); // Clear existing items
        for (String name : supplierNames) {
            comboBox.addItem(name); // Add each supplier name
        }
    }
    
    public void EditPO(String id, String newSupplier, String newItem, String newPrice, String newQty)
    {
        FilePath = "src\\oodj_assignment_data\\PurchaseOrder.txt";
        PM_PurchaseOrder po = new PM_PurchaseOrder();
        List<String> lines = crud.readData(FilePath);
        boolean newLines = false;
        
        for (int line = 0; line < lines.size(); line++) 
        {
        String[] data = lines.get(line).split(",");
            //Check if UID match
            if (data[0].equals(id))
            {
                data[2] = newSupplier;
                data[3] = newItem;
                data[4] = newPrice;
                data[5] = newQty;
                data[6] = data[6];
                lines.set(line, String.join(",", data));
                newLines = true;
                break;
            }
        }
        if(newLines)
        {
            crud.updateData(lines, FilePath);
            JOptionPane.showMessageDialog(po, "Purchase Order Updated");
        }
        else
        {
            JOptionPane.showMessageDialog(po, "Failed to Update Data");
        }
    }
    
    public void DeletePO(String id)
    {
        FilePath = "src\\oodj_assignment_data\\PurchaseOrder.txt";
        PM_PurchaseOrder po = new PM_PurchaseOrder();
        List<String> lines = crud.readData(FilePath);
        boolean PODeleted = false;
        
        Iterator<String> iterator = lines.iterator();
        while (iterator.hasNext()) 
        {
            String line = iterator.next();
            String[] data = line.split(",");
            if (data[0].equals(id)) 
            {
                iterator.remove();
                PODeleted = true;
                break;
            }
        }
        if(PODeleted)
        {
            crud.updateData(lines, FilePath);
            JOptionPane.showMessageDialog(po, "Record Deleted Successfully!");
        }
        else
        {
            JOptionPane.showMessageDialog(po, "Failed to Delete Record");
        }
    }
}
