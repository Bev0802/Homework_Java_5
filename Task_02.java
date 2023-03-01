import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* Пусть дан список сотрудников: Иван, Пётр, Антон и так далее. 
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
*/
public class Task_02 {
    public static void main(String[] args) {
        LinkedList<String> listOfEmployees = new LinkedList<>() {
            {
                offer("Иван");
                offer("Пётр");
                offer("Антон");
                offer("Василий");
                offer("Маша");
                offer("Иван");
                offer("Миша");
                offer("Иван");
                offer("Василий");
                offer("Маша");
                offer("Пётр");
                offer("Иван");
                offer("Миша");
                offer("Маша");
            }
        };

        System.out.println(listOfEmployees);
        ListOfEmployees(listOfEmployees);
    }

    public static Map<String, Integer> ListOfEmployees(LinkedList<String> list) {
        Map<String, Integer> listOfEmployees = new HashMap<>();
        //LinkedHashMap<String, Integer> listOfEmployees = new LinkedHashMap<>();

        for (int i = 0; i < list.size() - 1; i++) {
            int count = 1;
            for (int j = 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    count++;
                    list.remove(j);
                }
                listOfEmployees.put(list.get(i), count);
            }
        }
        System.out.println(listOfEmployees);
        listOfEmployees.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);

        return listOfEmployees;
    }

}
