import java.util.*;

/*Реализуйте структуру телефонной книги с помощью HashMap, учитывая, 
что один человек может иметь несколько телефонов. */
public class Task_01 {
        
    public static void main(String[] args) {
        Map<Object,ArrayList<Object>> multiMap = new HashMap<Object,ArrayList<Object>>();
        Map<String, List<String>> hm = new HashMap<String, List<String>>();
        List<String> values = new ArrayList<String>();
        values.add("Value 1");
        values.add("Value 2");
        hm.put("Key1", values);

        // to get the arraylist
        System.out.println(hm.get("key1"));


        Map<String, List<String>> map = new HashMap<String, List<String>>();

  // create list one and store values

        List<String> One = new ArrayList<String>();
        One.add("Apple");
        One.add("Aeroplane");

        // create list two and store values
        List<String> Two = new ArrayList<String>();
        Two.add("Bat");
        Two.add("Banana");

        // put values into map
        map.put("A", One);
        map.put("B", Two);
        map.put("C", Three);
}    
    
}