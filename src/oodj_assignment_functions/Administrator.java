/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import oodj_assignment.AM_MainForm;
import oodj_assignment.LoginForm;



/**
 *
 * @author Lenovo
 */
public class Administrator implements IDGenerator
{
    private String username;
    private String password;
    private String role;
    private final String FilePath = "src\\oodj_assignment_data\\Accounts.txt";;
    boolean login = false;//declare if login is false
    
    CRUD crud = new CRUD();
   
    //method to retrieve username inputted on login
    public String getName()
    {
        return username;
    }
    //method to authenticate user
    public String AuthenticateUser(String username, String password)
    {
        LoginForm loginn = new LoginForm();
        List<String> lines = crud.readData(FilePath);//fill txt file data to a list
        
        for(String line : lines)//loop through every lines in the list
        {
            String[] data = line.split(",");
            this.username = data[1];
            this.password = data[2];
            this.role = data[3];
            
            if(this.username.equals(username)&& this.password.equals(password))//if username & password is on the same line then login true
            {
                login = true;
                JOptionPane.showMessageDialog(loginn,"Welcome, " + role);
                break;
            }
        }
        if(!login)//if login is still false then show a message box
            {
                JOptionPane.showMessageDialog(loginn,"Wrong Name or Password");
                return null;
            }
        else//if login true return the role
        {
            return role;
        }
    }
    
    public void PopulateUserTable(JTable table)
    {
        List<String> lines = crud.readData(FilePath);

        // Define table column names
        String[] columnNames = {"UID", "Username", "Password", "Role"};
        // Create a DefaultTableModel with column names
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
    
    public String getIDfromName(String name)
    {
        List<String> lines = crud.readData(FilePath);
        for (String line : lines)
        {
            String[] data = line.split(",");
            if(data[1].equals(name))
            {
                return data[0];
            }
        }
        return null;
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
        AM_MainForm amf = new AM_MainForm();
        String newSupplier = String.format("%s,%s,%s,%s", GenerateID("s"), name, payment, date);
        try 
        {
            JOptionPane.showMessageDialog(amf, "Supplier Added Successfully");
            crud.createData(newSupplier, "src\\oodj_assignment_data\\InventorySupplier.txt");
        }
        catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(amf, "Error Adding Supplier");
        }
    }
    
    public void EditSupplier(String id, String newName, String newPayment, String newDate)
    {
        AM_MainForm amf = new AM_MainForm();
        List<String> lines = crud.readData(FilePath);
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
            crud.updateData(lines, FilePath);
            JOptionPane.showMessageDialog(amf, "Details Updated");
        }
        else
        {
            JOptionPane.showMessageDialog(amf, "Failed to Update Data");
        }
    }
    
    
    @Override
    public String GenerateID()
    {
        List<String> lines = crud.readData(FilePath);
        List<Integer> numOfID = new ArrayList<>();
        for(String line : lines)
        {
            numOfID.add(Integer.valueOf((line.split(",")[0].substring(1))));
        }
        Collections.sort(numOfID);
        int LastID = numOfID.getLast();
        return  String.format("U%03d", LastID+1);
    }
    
    public boolean DuplicateChecker(String name)
    {
        AM_MainForm amf = new AM_MainForm();
        List<String> lines = crud.readData(FilePath);
         for (String line : lines) 
        {
            String[] data = line.split(",");
            if (data[1].equals(name)) 
            {
                JOptionPane.showMessageDialog(amf, "Username already exists!");
                return true; //if duplicate is found
            }
        }  
    //no duplicate found
    return false;
    }
    
    public void RegisterUser(String id, String name, String pass, String role)
    {
        AM_MainForm amf = new AM_MainForm();
        String newUser = String.format("%s,%s,%s,%s", id, name, pass, role);
        try 
        {
            JOptionPane.showMessageDialog(amf, "User Added Successfully");
            crud.createData(newUser, FilePath);
        }
        catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(amf, "Error Adding User");
        }
    }
    
    public void EditUser(String id, String newName, String newPass, String newRole)
    {
        AM_MainForm amf = new AM_MainForm();
        List<String> lines = crud.readData(FilePath);
        boolean newLines = false;
        
        for (int line = 0; line < lines.size(); line++) 
        {
        String[] data = lines.get(line).split(",");
            //Check if UID match
            if (data[0].equals(id))
            {
                //Update the record with new username, password, role
                data[1] = newName;
                data[2] = newPass;
                data[3] = newRole;
                lines.set(line, String.join(",", data));//rebuild the updated line and replace it in the list
                newLines = true;
                break;
            }
        }
        if(newLines)
        {
            crud.updateData(lines, FilePath);
            JOptionPane.showMessageDialog(amf, "Details Updated");
        }
        else
        {
            JOptionPane.showMessageDialog(amf, "Failed to Update Data");
        }
    }
    
    public void DeleteUser(String id)
    {
        AM_MainForm amf = new AM_MainForm();
        List<String> lines = crud.readData(FilePath);
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
            crud.updateData(lines, FilePath);
            JOptionPane.showMessageDialog(amf, "User Deleted Successfully!");
        }
        else
        {
            JOptionPane.showMessageDialog(amf, "Failed to Delete User");
        }
    }
}
