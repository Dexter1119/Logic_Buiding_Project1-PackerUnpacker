///////////////////////////////////////////////////////////////////////////////////
//
// Name:        Packer.java  
// Description: Project File -> File Packer 
// Author:      Pradhumnya Changdev Kalsait.
// Date:        21-07-2025
//
///////////////////////////////////////////////////////////////////////////////////

package PackerUnpacker;

import java.io.*;

public class Packer
{
    private String dir;
    private String PackName;

    public Packer(String A , String B)
    {
        this.dir = A;
        this.PackName = B;
    }

    public void PackFile()
    {
        try
        {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("-----------------Marvellous Packer Unpacker---------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("-----------------------Packing Activity-------------------------------");
    
            
            int i = 0;
            int j = 0;
            int iRet = 0;
            int iCount = 0;

            //Created The File Object of Directory As in Java everything is treated as file
            File fobj = new File(dir);

            //Check the existance of directory
            if(fobj.exists() && fobj.isDirectory())
            {

                System.out.println(dir + " is Successfully opened ");

                //Created the object of packed file
                File pobj = new File(PackName);
                Boolean bRet = pobj.createNewFile();
                if(bRet == false)
                {
                    System.out.println("Unable to create pack file");
                   
                    return;
                }
                System.out.println("Packed file successfully created with packname:"+PackName);



                //Create the Array of the file to retrive from directory
                File Arr[] = fobj.listFiles();

                //Buffer for read write activity
                byte Buffer[] = new byte[1024];
                

                //passes pack file object to FileOutputStream foe writing
                FileOutputStream foobj = new FileOutputStream(pobj);
                String header = null;

                //Directory Traversal

                for(i = 0;i < Arr.length;i++)
                {
                    header = Arr[i].getName() +" "+ Arr[i].length();

                    //Header traversal to form 100 byte header
                    for(j = header.length() ; j < 100 ; j++)
                    {
                        header = header + " ";
                    }
                    //Wrte Heder into file 
                    foobj.write(header.getBytes());

                    //passes file object of directory file to FileInputStream for reading
                    FileInputStream fiobj = new FileInputStream(Arr[i]);

                    //Write the contents into file
                    while((iRet = fiobj.read(Buffer)) != -1)
                    {
                        foobj.write(Buffer,0,iRet);
                        System.out.println("File Scanned :"+ Arr[i].getName());
                        System.out.println("File Size read is:"+iRet);

                    }
                    fiobj.close();
                    iCount++;
                }
                
                System.out.println("Packing Activity Done...");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("------------------Statistical report----------------------------------");
                System.out.println("----------------------------------------------------------------------");

                // To be Add
                System.out.println("The Number of File in Directory are:" + Arr.length);
                System.out.println("the Number of files Packed from the directory:"+iCount);


                System.out.println("----------------------------------------------------------------------");
                System.out.println("------------Thank You For Using Our Application-----------------------");
                System.out.println("----------------------------------------------------------------------");
                
                foobj.close();
            }
            else
            {
                System.out.println("Directory not for of such name");

                System.out.println("----------------------------------------------------------------------");
                System.out.println("------------Thank You For Using Our Application-----------------------");
                System.out.println("----------------------------------------------------------------------");          
            }
        }//End of try

        catch(Exception e)
        {}

    }//End Of PackFile
    
}
// End Of Packer Class