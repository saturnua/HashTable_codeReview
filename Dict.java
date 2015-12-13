// =======================================
// Dict.java
//
// (C) Alexandr Frolov, 1998
// E-mail: frolov@glasnet.ru
// Web:    http://www.glasnet.ru/~frolov
// =======================================

import java.util.*;

public class Dict
{
  public static void main(String args[])
  {
	//---------------------------------------------- ��������� �������, ����� ���������� ---------------------------------
	// ���������� ������������ ��� ���� �� ��������� ������,
	// Dictionary<String, String> dictPhoneBook = new Hashtable<String, String>(); 
	// �� ��� ��� � �� ���� ����� ���������� ������ ������ ���(�����������) �� ����� :)  
	Dictionary dictPhoneBook = new Hashtable(); 
    String szStr = "";
    String szPhone = "";
    byte bKbd[] = new byte[256];
    StringTokenizer st;
    //-------------------------------------------------����������� � ������ ������ --------------------------------
    dictPhoneBook.put("Ivanov",  "322-223-228");
    dictPhoneBook.put("Petrov",  "326-211-227");
    dictPhoneBook.put("Sidorov", "311-225-263");
    dictPhoneBook.put("Ivanoff", "355-243-229");
    
    //---------------------------------�������� ������ ������ ----------------------------------------------------
    Enumeration en = dictPhoneBook.keys(); 
    //---- ��� ��������� ���� ��������� �����, �� ��� �� ������ � ���� ����� ----------------------------------------
    while(en.hasMoreElements())
    {
      szStr = (String)en.nextElement();
      szPhone = 
        (String)dictPhoneBook.get(szStr);
      System.out.println(szStr + ": " + 
          szPhone); 
    }
    
    
    System.out.println(
      "\nEnter name or 'exit' to terminate:"); 
    //--------------------------- ���� ��� ������ ���������� ����� � �������------------------------------------------
    while(true)
    {
      try
      {
        int iCnt = System.in.read(bKbd);
	szStr = new String(bKbd, 0, iCnt);
      
        st = new StringTokenizer(szStr, "\r\n");
        szStr = 
          new String((String)st.nextElement());
      }  
      catch(Exception ex)
      {
        System.out.println(ex.toString()); 
      }
      
      if(szStr.equals("exit"))
	break;
      //---------------------------------------------��������, ���� �� ��������� ������-----------------------------
      szPhone = (String)dictPhoneBook.get(szStr); 
      if(szPhone != null)
    	  //----------------------------- ���� ���� ������� �� ����� ------------------------------------ � ���������--------
        System.out.println("Name:" +
           szStr + ", phone:" + szPhone); 
      else
    	  //-------------------------------------�� �����--------------------------------------------------------------
        System.out.println("\nNot found"); 
    }
    System.out.println("\nDone!"); 
  }
}
// ������ � ������ ������ ������������ ����� � ���������������   - ������ , ����� �����!!!!
// ������ ��� ���� ���� ��������� ��� � �� ����� ������� ���������� - ������������� ������� � ��������� �����, � ����� ����� ������
//������ ����� ����� � ������ � ��������� ������. ���� ��� ��� ���� ���� ����� ����� ������ �����������