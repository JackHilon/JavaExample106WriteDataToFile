
package javaexample106writedatatofile;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class JavaExample106WriteDataToFile {

   // Data are byte, short, int, long, float, double, char, string , string(UTF-format), ........
    
    
    public static void main(String[] args) {
        
        
        File folder = MyHelper.CreateWorkingFolder("myWorkingFolder");
        
        MyHelper.FolderCheck(folder);
        
        File fil = MyHelper.CreateWorkingFile(folder, "myData.dat");
        
        MyHelper.FileCheck(fil);
        
        try{
            
            FileOutputStream fos = new FileOutputStream(fil);
            
            // create an object which can translate primitive values and strings
            // to series of bytes
            /*
            Creates a new data output stream to write data to the specified 
            underlying output stream. The counter written is set to zero.
            */
            DataOutputStream dos = new DataOutputStream(fos);
            
            byte b = 65;
            short s = -567;
            int i = 123000;
            long l = 76656545L;
            
            float f = -26.87F;
            double d = 135.9876;
            
            boolean bv = true;
            char c = 'A';
            
            String s1 = "Water, water everywhere!";
            String s2 = "Sun 123 Sun Sun!?|"; // | is string-end
            
            // writing
            dos.writeByte(b);
            dos.writeShort(s);
            dos.writeInt(i);
            dos.writeLong(l);
            dos.writeFloat(f);
            dos.writeDouble(d);
            dos.writeBoolean(bv);
            dos.writeChar(c);
            
            // write string with UTF-Format
            dos.writeUTF(s1);
            
            // write string as a series of unicode-chars, with given string-end
            dos.writeChars(s2);
            
            
            // close
            dos.close();
            fos.close();
        }// end-try
        
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
