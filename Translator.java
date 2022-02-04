package edu.ics211.h01;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Isaac Segawa
 *
 */
public class Translator implements Translate {

  @Override
  public String asBinaryString(InputStream in) {
    // TODO Auto-generated method stub
    //Create a StringBuilder to hold the string
    StringBuilder string = new StringBuilder();
    //Create a BitReader from in
    try {
      BitReader reader = new BitReader(in);
      
    //Loop until BitReader is done
      while (!reader.isDone()) {
    // Append the 0 or 1 to the StringBuilder
        int bitReadInt = reader.readAsInt();
        string.append(bitReadInt);
      }
    //Close the BitReader
      reader.close();
    //return StringBuilder.toString();
      return string.toString();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }


  @Override
  public String asHexadecimalString(InputStream in) {
    // TODO Auto-generated method stub
    //Create a new StringBuilder
    StringBuilder string = new StringBuilder();
    //Create a variable for the byte and initialize it
    try {
    //Loop until end of unit
      while (in.available() != 0) {
    // Read the byte
        int bytes = in.read();
    // Convert the byte to a hex string Integer.toHexString(byte)
        string.append(String.format("%02x", bytes));
      }
    //Close in
      in.close();
    //return StringBuilder.toString();
      return string.toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }


  @Override
  public String asUtf8String(InputStream in) {
    // TODO Auto-generated method stub
    //Create an array of bytes
    try {
      byte[] byteArr = new byte[in.available()];
      int i = 0;
      while (in.available() != 0) {
    //Fill the array read(byte[])
        byteArr[i] = (byte)in.read();
        i++;
      }
    //Return the new String
      return new String(byteArr, "UTF-8");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

}
