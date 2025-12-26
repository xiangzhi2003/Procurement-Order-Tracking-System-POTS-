
package oodj_assignment_functions;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class PRGenerator {
    private static final String PR_FILE = "pr.txt";
    private static final String INVENTORY_FILE = "inventory.txt";

    private List<PR> prList = new ArrayList<>();
    private List<InventoryItem> inventoryList = new ArrayList<>();

    
    public void createUI() {
        JFrame frame = new JFrame("PR Generator");
        JPanel panel = new JPanel();

        JButton loadButton = new JButton("Load PR");
        JButton generateButton = new JButton("Generate PR");

        // Load Button Action
        loadButton.addActionListener(e -> loadPR());

        // Generate Button Action
        generateButton.addActionListener(e -> generatePR());

        panel.add(loadButton);
        panel.add(generateButton);
        frame.add(panel);

        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Load PR data from the pr.txt file
    private void loadPR() {
        prList.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(PR_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                prList.add(new PR(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4], data[5]));
            }
            System.out.println("PRs Loaded: " + prList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    private void generatePR() {
        loadInventory();  // Load inventory from the file

        Set<String> generatedPRs = prList.stream()
                .map(pr -> pr.getItemID() + pr.getPRDate())  
                .collect(Collectors.toSet());

        for (InventoryItem item : inventoryList) {
            if ("Understock".equals(item.getStockStatus()) && !generatedPRs.contains(item.getItemID() + item.getStockUpdateDate())) {
                // Generate a new PR for this understock item
                PR newPR = new PR("PR" + (prList.size() + 1), item.getItemID(), item.getQuantityReq(), item.getStockUpdateDate(), item.getSupplierID(), "Pending");
                prList.add(newPR);
                generatedPRs.add(item.getItemID() + item.getStockUpdateDate());  // Add the new PR key to avoid future duplicates
                System.out.println("Generated PR: " + newPR);
            }
        }
    }

    // Load inventory data from inventory.txt
    private void loadInventory() {
        inventoryList.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(INVENTORY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                inventoryList.add(new InventoryItem(data[0], data[8], Integer.parseInt(data[9]), data[6], data[7]));
            }
            System.out.println("Inventory Loaded: " + inventoryList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PRGenerator generator = new PRGenerator();
        generator.createUI();  
    }
}


class PR {
    private String prID;
    private String itemID;
    private int quantity;
    private String prDate;
    private String supplierID;
    private String prStatus;

    public PR(String prID, String itemID, int quantity, String prDate, String supplierID, String prStatus) {
        this.prID = prID;
        this.itemID = itemID;
        this.quantity = quantity;
        this.prDate = prDate;
        this.supplierID = supplierID;
        this.prStatus = prStatus;
    }

    public String getItemID() {
        return itemID;
    }

    public String getPRDate() {
        return prDate;
    }

    @Override
    public String toString() {
        return prID + ", " + itemID + ", " + quantity + ", " + prDate + ", " + supplierID + ", " + prStatus;
    }
}

// Class to represent an Inventory item
class InventoryItem {
    private String itemID;
    private String stockStatus;
    private int quantityReq;
    private String stockUpdateDate;
    private String supplierID;

    public InventoryItem(String itemID, String stockStatus, int quantityReq, String stockUpdateDate, String supplierID) {
        this.itemID = itemID;
        this.stockStatus = stockStatus;
        this.quantityReq = quantityReq;
        this.stockUpdateDate = stockUpdateDate;
        this.supplierID = supplierID;
    }

    public String getItemID() {
        return itemID;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public int getQuantityReq() {
        return quantityReq;
    }

    public String getStockUpdateDate() {
        return stockUpdateDate;
    }

    public String getSupplierID() {
        return supplierID;
    }
}
