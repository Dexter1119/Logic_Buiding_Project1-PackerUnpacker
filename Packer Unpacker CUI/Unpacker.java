///////////////////////////////////////////////////////////////////////////////////
//
// Name:        Unacker.java  
// Description: Project File -> File PackerUnpacker - Unpacker file 
// Author:      Pradhumnya Changdev Kalsait.
// Date:        21-07-2025
//
///////////////////////////////////////////////////////////////////////////////////

package PackerUnpacker;

import java.io.*;


public class Unpacker
{
    private String PackName;
    public Unpacker(String A)
    {
        this.PackName = A;
    }
    public void UnpackFile()
    {
        try
        {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("-----------------Marvellous Packer Unpacker---------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("---------------------Unpacking Activity-------------------------------");
    
            
            
            String Header = null;
            File fobjnew = null;
            int iCnt = 0;
            int iRet = 0;
            int FileSize = 0;
            

            File fobj = new File(PackName);

            
            //If Pack file is Not present
            if(!fobj.exists())
            {
                System.out.println("Unable to access packed file");
                return;
            }

            System.out.println("Packed File Successfully Opened");
            FileInputStream fiobj = new FileInputStream(fobj);

            //Buffer to read Buffer
            byte HederBuffer[] = new byte[100];

            //Scan the packed file to extract the files from it
            while((iRet = fiobj.read(HederBuffer,0,100)) != -1)
            {
                //Convert Byte Array to String
                Header = new String(HederBuffer);

                // Trim the WhiteSpaces
                Header = Header.trim();

                //Split the remaining header 
                String tokens[] = Header.split(" ");

                // First File Name milel so tyachi file create karavi lagel
                fobjnew = new File(tokens[0]);
                fobjnew.createNewFile();

                // Define The File Size And Create Buffer
                FileSize = Integer.parseInt(tokens[1]);
                byte Buffer[] = new byte[FileSize];

                FileOutputStream foobj = new FileOutputStream(fobjnew);

                // read the data into packed file
                fiobj.read(Buffer, 0 , FileSize);

                //Write The Data in Extracted file
                foobj.write(Buffer,0,FileSize);

                System.out.println("File Unpack with name : "+ tokens[1]+" having Size "+FileSize);
                iCnt++;
                //close the opened object
                foobj.close();

            }//end of while
            
            //Packed file object closed
            fiobj.close();

            System.out.println("----------------------------------------------------------------------");
            System.out.println("------------------Statistical report----------------------------------");
            System.out.println("----------------------------------------------------------------------");

            System.out.println("TOtal Number of files unpacked :"+ iCnt);

            

            System.out.println("----------------------------------------------------------------------");
            System.out.println("------------Thank You For Using Our Application-----------------------");
            System.out.println("----------------------------------------------------------------------");
                

        }

        catch(Exception e)
        {}
       


    }

}