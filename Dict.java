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
	//---------------------------------------------- создается словарь, книга телефонная ---------------------------------
	// компилятор подсказывает что нада бы параметры писать,
	// Dictionary<String, String> dictPhoneBook = new Hashtable<String, String>(); 
	// но так как я не имею опыта разработки просто поверю ему(компилятору) на слово :)  
	Dictionary dictPhoneBook = new Hashtable(); 
    String szStr = "";
    String szPhone = "";
    byte bKbd[] = new byte[256];
    StringTokenizer st;
    //-------------------------------------------------Добавляется в ловарь записи --------------------------------
    dictPhoneBook.put("Ivanov",  "322-223-228");
    dictPhoneBook.put("Petrov",  "326-211-227");
    dictPhoneBook.put("Sidorov", "311-225-263");
    dictPhoneBook.put("Ivanoff", "355-243-229");
    
    //---------------------------------получаем список ключей ----------------------------------------------------
    Enumeration en = dictPhoneBook.keys(); 
    //---- тут выводится весь словарь на экран, то что мы ввелли в него ранее ----------------------------------------
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
    //--------------------------- цикл для поиска введенного имени в таблице------------------------------------------
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
      //---------------------------------------------проверка, есть ли введенная запись-----------------------------
      szPhone = (String)dictPhoneBook.get(szStr); 
      if(szPhone != null)
    	  //----------------------------- если есть выводин на экран ------------------------------------ с телефоном--------
        System.out.println("Name:" +
           szStr + ", phone:" + szPhone); 
      else
    	  //-------------------------------------не нашли--------------------------------------------------------------
        System.out.println("\nNot found"); 
    }
    System.out.println("\nDone!"); 
  }
}
// Напишу с высоты своего огромнейшего опыта в программировани   - бугага , шутка юмора!!!!
// Следуя как меня учат принципам ООП я бы вынес функцию заполнения - инициализации словаря в отдельный класс, а также вынес функию
//поиска ввода имени и поиска в отдельные классы. Пока все ибо мало мало опыта чтобы делать рефакторинг