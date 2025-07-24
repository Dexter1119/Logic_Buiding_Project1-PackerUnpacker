///////////////////////////////////////////////////////////////////////////////////
//
// Name:        PackerGUI.java  
// Description: Project File -> File Packer GUI 
// Author:      Pradhumnya Changdev Kalsait.
// Date:        22-07-2025
//
///////////////////////////////////////////////////////////////////////////////////


import javax.swing.*;
import java.awt.*;

import PackerUnpacker.Packer;

public class PackerGUI
{
    public static void main(String A[])
    {
        JFrame fobj = new JFrame("Marvellous Packer Unpacker-Packer");
        fobj.setSize(600, 400);
        fobj.setLayout(null);
        fobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fobj.setVisible(true);

        JLabel Title = new JLabel("-------------------------Marvellous Packer-------------------------------");
        JButton bobj = new JButton("Pack File");
        JLabel dirLabel = new JLabel("Enter Directory Path: ");
        JTextField dir = new JTextField();
        JLabel packNameLabel = new JLabel("Enter Pack Name: ");
        JTextField packName = new JTextField();


        Title.setBounds(100, 30, 400, 30);                    

        dirLabel.setBounds(50, 100, 180, 30);                 
        dir.setBounds(250, 100, 280, 30);                    

        packNameLabel.setBounds(50, 160, 180, 30);            
        packName.setBounds(250, 160, 280, 30);                

        bobj.setBounds(210, 250, 180, 40);
        
        fobj.add(bobj);
        fobj.add(dirLabel);
        fobj.add(dir);
        fobj.add(packNameLabel);
        fobj.add(packName);
        fobj.add(Title);

        fobj.setVisible(true);
        bobj.setVisible(true);
        dirLabel.setVisible(true);
        dir.setVisible(true);
        packNameLabel.setVisible(true);
        packName.setVisible(true);
        
        
        bobj.addActionListener(e -> 
        {
            String directory = dir.getText();
            String packNameText = packName.getText();
            if (directory.isEmpty() || packNameText.isEmpty()) 
            {
                JOptionPane.showMessageDialog(fobj, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else 
            {
                Packer pobj = new Packer(directory, packNameText);
                pobj.PackFile();
                JOptionPane.showMessageDialog(fobj,"packing Completed Successfully");
            }
        });



        
    }
}
