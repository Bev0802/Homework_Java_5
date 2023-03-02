import java.util.*;

/*Реализуйте структуру телефонной книги с помощью HashMap, учитывая, 
что один человек может иметь несколько телефонов. */
public class Task_01 {

    public static void main(String[] args) {
        // объявление переменных
        Map<String, List<String>> bookPhone = new HashMap<>();       

        String name = "", plasePhone = "", numPhone = "", command = "";
        Scanner sc = new Scanner(System.in, "cp866");

        while (!command.equalsIgnoreCase("0")) {
            plasePhone = "";
            numPhone = "";
            command = "";
            System.out.println("\nВведите команду для совершения действий в телефонной книге:\n" +
                    "0 - выход из телефоной книги;\n" +
                    "1 - посмотреть все контаты в телефонной книге;\n" +
                    "2 - добавить новый контак;\n" +
                    "3 - добавить контаку дополнительный телефон;\n" +
                    "4 - найти контакт в телефонной книге по имени;\n" +
                    "5 - удалить контат из телефонной книге;\n" +
                    "6 - удалить или заменить телефон контакта в телефонной книге;\n");

            command = (sc.nextLine());
            String[] commands = new String[] { "0", "1", "2", "3", "4", "5", "6" };
            Boolean bool = Arrays
                    .asList(commands).contains(command);

            if (bool == false) {
                System.out.println("Ошибка! Вы ввели не верную команду, попробуйте ещё!");
                continue;

            } else if (command.equalsIgnoreCase("0")) {
                System.out.println("Телефонная книга закрыта.");
                System.exit(0);

            } else if (command.equalsIgnoreCase("1")) {
                println(bookPhone);
                
            } else if (command.equalsIgnoreCase("2")) {
                System.out.println("Для добавления нового контакта, введите имя: ");
                name = sc.nextLine();
                System.out.println("Введите место телефона(например: мобильный, домашний, рабочий");
                plasePhone = sc.nextLine();
                System.out.println("Введите номер телефона");
                numPhone = sc.nextLine();
                addContact(bookPhone, name, plasePhone, numPhone);

            } else if (command.equalsIgnoreCase("3")) {
                System.out.println("Для добавления контаку дополнительного телефона введите имя контакта " +
                        "или нажмите *, если вводили котакт только что:");
                String temp = sc.nextLine();
                if (!temp.equalsIgnoreCase("*")) {
                    name = temp;
                }

                System.out.println("Введите место телефона(например: мобильный, домашний, рабочий");
                plasePhone = sc.nextLine();
                System.out.println("Введите номер телефона");
                numPhone = sc.nextLine();
                addNumForContact(bookPhone, name, plasePhone, numPhone);

            } else if (command.equalsIgnoreCase("4")) {
                System.out.println("Для поиска контакт в телефонной книге, введите имя: ");
                name = sc.nextLine();
                contactSearch(name, bookPhone);

            } else if (command.equalsIgnoreCase("5")) {
                System.out.println("Для удаления контата из телефонной книге, введите имя:");
                name = sc.nextLine();
                contactcRemove(name, bookPhone);

            } else if (command.equalsIgnoreCase("6")) {
                System.out.println("Для изменения телефона, введите имя:");
                name = sc.nextLine();
                System.out.println("Введите место телефона(например: мобильный, домашний, рабочий");
                plasePhone = sc.nextLine();
                System.out.println("Введите номер телефона");
                numPhone = sc.nextLine();
                contactReples(bookPhone, name, plasePhone, numPhone);

            } else {
                throw new IllegalStateException("Ошибка! Такой команды нет!");
            }
        }
        sc.close();
    }

    ///////////////////////////// ФУНКЦИИ////////////////////////

    ////////////// ФУНКЦИЯ СОЗАДЕТ НОВЫЙ КОНТАКТ
    public static Map<String, List<String>> addContact(Map<String, List<String>> bookPhone, String name, String plase,
            String numPhone) {
        List<String> LNP = new ArrayList<>();
        LNP.add(0, plase);
        LNP.add(1, numPhone);

        bookPhone.put(name, LNP);
        println(bookPhone);

        return bookPhone;
    }

    ///////////////// ФУНКЦИЯ ИЗМЕНЯЕТ ТЕЛЕФОНЫ КОНТАКТА
    public static void contactReples(Map<String, List<String>> bookPhone, String name, String plasePhone,
            String numPhone) {
        List<String> LNP = new ArrayList<>();
        LNP.addAll(bookPhone.get(name));        
        LNP.clear();
        
        LNP.add(0, plasePhone);
        LNP.add(1, numPhone);

        bookPhone.put(name, LNP);
        
        System.out.println();
        println(bookPhone);
    }

    //////////// ФУНКЦИЯ НАХОДИТ КОНТАКТ И ВЫВВОДИТ ВСЕ ЕГО ТЕЛЕФОНЫ
    private static void contactSearch(String name, Map<String, List<String>> bookPhone) {
        System.out.printf("Имя: %s, телефон: %s", name, bookPhone.get(name));
    }

    ///////////// ФУНКЦИЯ УДАЛЯЕТ КОНТАКТ
    private static void contactcRemove(String name, Map<String, List<String>> bookPhone) {
        bookPhone.remove(name);
        System.out.println();
        println(bookPhone);
    }

    /////////// ФУНКЦИЯ ДОБАВЛЯЕТ НОМЕР КОНТАКТУ
    private static void addNumForContact(Map<String, List<String>> bookPhone, String name, String plasePhone,
            String numPhone) {
        List<String> LNP = new ArrayList<>();
        LNP.addAll(bookPhone.remove(name));

        LNP.add(0, plasePhone);
        LNP.add(1, numPhone);

        bookPhone.put(name, LNP);
        
        System.out.println();
        println(bookPhone);
    }
    private static void println (Map<String, List<String>> bookPhone){
        bookPhone.entrySet().stream()
            .sorted(Map.Entry.<String, List<String>>comparingByKey())
            .forEach(System.out::println);
    }
}