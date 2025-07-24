

///////////////////////////////////////////////////////////////////////////////////
//
// Name:        Client.java  
// Description: Project File _> Client file for Project
// Author:      Pradhumnya Changdev Kalsait.
// Date:        21-07-2025
//
///////////////////////////////////////////////////////////////////////////////////

import PackerUnpacker.Unpacker;
import PackerUnpacker.Packer;
import java.util.Scanner;


public class Client 
{
    public static void main(String A[]) 
    {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        String dir = null;
        String PackName = null;

            System.out.println("----------------------------------------------------------------------");
            System.out.println("-----------------Marvellous Packer Unpacker---------------------------");

            System.out.println("Enter Which Operation you wanna Perform Your Choice");
            System.out.println("1.Packing");
            System.out.println("2.Unpacking");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:

                    System.out.println("Enter the name of the directory that you want to pack:");
                    dir = sc.nextLine();
            
                    System.out.println("Enter the name of the file that you want create to pack:");
                    PackName = sc.nextLine();
            
            
                    Packer pobj = new Packer(dir, PackName);
                    pobj.PackFile();
                     
                    
                    break;
                case 2:

                    System.out.println("Enter the name of the file that contains packed data:");
                    PackName = sc.nextLine();
                    
                    Unpacker uobj = new Unpacker(PackName);
                    uobj.UnpackFile();
                    
                    break;
        
                default:
                    break;
            }
            sc.close(); 



          

    }//End Of Main
    
}//End of Public class 
