///////////////////////////////////////////////////////////////////////////////////
//
// Name:        UnpackerGUI.java  
// Description: Project File -> File Packer GUI 
// Author:      Pradhumnya Changdev Kalsait.
// Date:        22-07-2025
//
///////////////////////////////////////////////////////////////////////////////////

import javax.swing.*;
import java.awt.*;

import PackerUnpacker.Unpacker;


public class UnpackerGUI
{
    public static void main(String A[])
    {
        JFrame fobj = new JFrame("Marvellous Packer Unpacker-Unpacker");
        fobj.setSize(600, 400);
        fobj.setLayout(null);
        fobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fobj.setVisible(true);

        JLabel Title = new JLabel("-------------------------Marvellous UnPacker-------------------------------");
        JButton bobj = new JButton("Unpack File");
        
        JLabel packNameLabel = new JLabel("Enter Packed File Name: ");
        JTextField packName = new JTextField();

        Title.setBounds(100, 30, 400, 30);                    

        
        packNameLabel.setBounds(50, 160, 180, 30);            
        packName.setBounds(250, 160, 280, 30);                

        bobj.setBounds(210, 250, 180, 40);
        
        fobj.add(bobj);
        fobj.add(packNameLabel);
        fobj.add(packName);
        fobj.add(Title);

        fobj.setVisible(true);
        bobj.setVisible(true);
        
        packNameLabel.setVisible(true);
        packName.setVisible(true);
        
        
        bobj.addActionListener(e -> 
        {
            
            String PackedFileName = packName.getText();
            Unpacker uobj = new Unpacker( PackedFileName);
            uobj.UnpackFile();
            JOptionPane.showMessageDialog(fobj,"Unpacking Completed Successfully");
            System.exit(0);
            
        });
    }
}

