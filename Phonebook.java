import java.util.*;

public class Phonebook {
    private HashMap<String, TreeSet<String>> contacts;

    public Phonebook() {
        contacts = new HashMap<>();
    }

    // Добавление контакта
    public void addContact(String name, String phoneNumber) {
        TreeSet<String> phoneNumbers = contacts.getOrDefault(name, new TreeSet<>());
        phoneNumbers.add(phoneNumber);
        contacts.put(name, phoneNumbers);
    }

    // Получение всех номеров телефонов по имени
    public TreeSet<String> getPhoneNumbers(String name) {
        return contacts.getOrDefault(name, new TreeSet<>());
    }

    // Вывод телефонной книги с сортировкой по убыванию числа телефонов
    public void printPhoneBook() {
        // Создаем список записей телефонной книги
        List<Map.Entry<String, TreeSet<String>>> list = new ArrayList<>(contacts.entrySet());

        // Сортируем список по убыванию количества номеров телефонов
        list.sort((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size());

        // Выводим отсортированные записи
        for (Map.Entry<String, TreeSet<String>> entry : list) {
            String name = entry.getKey();
            TreeSet<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }

    public static void main(String[] args) {
        Phonebook phoneBook = new Phonebook();
        // Пример добавления контактов
        phoneBook.addContact("Пётр", "1234567890");
        phoneBook.addContact("Сергей", "0987654321");
        phoneBook.addContact("Анна", "9876543210");
        phoneBook.addContact("Пётр", "1357924680");
        phoneBook.addContact("Александр", "2468013579");
        phoneBook.addContact("Василий", "9876543210");
        phoneBook.addContact("Александр", "6756543210");
        phoneBook.addContact("Александр", "2465943579");
        phoneBook.addContact("Василий", "9846159210");
        phoneBook.addContact("Василий", "9875043210");
        phoneBook.addContact("Василий", "681591510");

        // Вывод отсортированной телефонной книги
        phoneBook.printPhoneBook();
    }
}
