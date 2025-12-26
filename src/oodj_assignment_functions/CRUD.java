/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj_assignment_functions;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class CRUD {
    String path = "";
    
    public void createData(String line, String path) throws IOException
    {
        this.path = path;
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true)))
        {
            bw.write(line);
            bw.newLine();
        }
        catch(IOException e)
        {
            System.out.println("error");
        }
    }
    
    public List<String> readData(String path)
    {
        List<String> lines = new ArrayList<>();
        this.path = path;
        try (BufferedReader br = new BufferedReader(new FileReader(path)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                lines.add(line);
            }
        } 
        catch (IOException e) 
        {
            System.out.println("error");
        }
        return lines;
    }
    
    public void updateData(List<String> newDataSet, String file)
    {
        this.path = file;
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path)))
        {
            for(String line : newDataSet)
            {
                bw.write(line);
                bw.newLine();
            }
        } 
        catch (IOException e) 
        {
            System.out.println("error");
        }
    }    
}
