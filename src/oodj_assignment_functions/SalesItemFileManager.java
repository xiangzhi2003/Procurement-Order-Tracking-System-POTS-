
package oodj_assignment_functions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SalesItemFileManager {
    public static List<SalesItem> loadFromFile(String filePath) throws IOException {
        List<SalesItem> entries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                boolean isHeader = true;

                while ((line = reader.readLine()) != null) {
                    if (isHeader) {
                        isHeader = false;
                        continue;
                    }
                    String[] data = line.split(",");
                    if (data.length == 4) { // Updated to match correct number of columns
                        try {
                            entries.add(new SalesItem(
                                data[0],                      // itemCode
                                data[1],                      // itemName
                                data[2],                      // category
                                Double.parseDouble(data[3])   // itemPrice
                            ));
                        } catch (NumberFormatException ex) {
                            System.err.println("Invalid price in line: " + line);
                        }
                    

                    } else {
                        System.err.println("Malformed line: " + line);
                    }
                }
            }
            return entries;
    }
}
