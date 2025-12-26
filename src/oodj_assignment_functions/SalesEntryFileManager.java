
package oodj_assignment_functions;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *  Purpose : Manage File
 * 
 */

public class SalesEntryFileManager {
    
    public static void saveToFile(List<SalesEntry> salesEntries, String filePath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            // Write column headers
            bw.write("Item Code,Item Name,Category,Quantity,Date");  
            bw.newLine();

            // Write each sales entry to the file
            for (SalesEntry entry : salesEntries) {
                bw.write(entry.getItemCode() + "," + entry.getItemName() + "," + entry.getCategory() + "," +
                         entry.getQuantity() + "," + entry.getDate());
                bw.newLine();
            }

            JOptionPane.showMessageDialog(null, "Data saved successfully!");
        }
    }

    public static List<SalesEntry> loadFromFile(String filePath) throws IOException {
        List<SalesEntry> entries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                boolean isHeader = true;

                while ((line = reader.readLine()) != null) {
                    if (isHeader) {
                        isHeader = false;
                        continue;
                    }
                    String[] data = line.split(",");
                    if (data.length == 5) { 
                        try {
                            entries.add(new SalesEntry(
                                data[0],
                                data[1],
                                data[2],
                                Integer.parseInt(data[3]), 
                                data[4]
                            ));
                        } catch (NumberFormatException ex) {
                            System.err.println("Invalid quantity in line: " + line);
                        }
                    } else {
                        System.err.println("Malformed line: " + line);
                    }
                }
            }
            return entries;
    }
    
    
    
}

