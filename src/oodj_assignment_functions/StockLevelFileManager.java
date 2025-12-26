/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj_assignment_functions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raida
 */


public class StockLevelFileManager {
    public static List<StockLevel> loadFromFile(String filePath) throws IOException {
            List<StockLevel> entries = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                boolean isHeader = true;

                while ((line = reader.readLine()) != null) {
                    if (isHeader) {
                        isHeader = false; // Skip the header row
                        continue;
                    }

                    String[] data = line.split(",");

                    if (data.length >= 11) { 
                                        try {
                                            String itemCode = data[0];
                                            String itemName = data[1];
                                            String category = data[2];
                                            double itemPrice = Double.parseDouble(data[3]);
                                            int stock = Integer.parseInt(data[4]);
                                            int minStockAllowed = Integer.parseInt(data[5]);
                                            String stockUpdateDate = data[6];
                                            String stockStatus = data[7];
                                            String quantityReq = data[8];
                                            String supplierID = data[9];
                                            String supplierName = data[10];

                                            // Add to entries
                                            entries.add(new StockLevel(
                                                itemCode, itemName, category, itemPrice, stock, minStockAllowed,
                                                stockUpdateDate, stockStatus, quantityReq, supplierID, supplierName
                                            ));
                        } catch (NumberFormatException ex) {
                            System.err.println("Invalid number format in line: " + line);
                        }
                    } else {
                        System.err.println("Malformed line: " + line);
                    }
                }
            }
            return entries;
        }

}
