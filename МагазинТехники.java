import java.util.*;
public class МагазинТехники {
    public static void main(String[] args) {
        // Создаем множество ноутбуков
        Set<Ноутбук> ноутбуки = new HashSet<>();
        ноутбуки.add(new Ноутбук("Dell XPS", 16, 512, "Windows 10", "Серый"));
        ноутбуки.add(new Ноутбук("MacBook Pro", 32, 256, "macOS", "Серебристый"));
        ноутбуки.add(new Ноутбук("Lenovo ThinkPad", 8, 1, "Windows 10", "Черный"));

        // Запрашиваем у пользователя критерии фильтрации
        Map<String, Object> фильтр = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int выборКритерия = scanner.nextInt();
        scanner.nextLine(); // Очищаем буфер после ввода числа

        switch (выборКритерия) {
            case 1:
                System.out.println("Введите минимальное значение ОЗУ:");
                int минОзу = scanner.nextInt();
                фильтр.put("озу", минОзу);
                break;
            case 2:
                System.out.println("Введите минимальное значение объема ЖД:");
                int минОбъемЖД = scanner.nextInt();
                фильтр.put("объемЖД", минОбъемЖД);
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                String оперСистема = scanner.nextLine();
                фильтр.put("операционнаяСистема", оперСистема);
                break;
            case 4:
                System.out.println("Введите цвет:");
                String цвет = scanner.nextLine().trim();
                фильтр.put("цвет", цвет);
                break;
            default:
                System.out.println("Неверный выбор критерия.");
                return;
        }

        // Фильтруем ноутбуки
        Set<Ноутбук> отфильтрованныеНоутбуки = фильтроватьНоутбуки(ноутбуки, фильтр);

        // Выводим результат
        System.out.println("Отфильтрованные ноутбуки:");
        for (Ноутбук ноутбук : отфильтрованныеНоутбуки) {
            System.out.println(ноутбук);
        }
    }

    private static Set<Ноутбук> фильтроватьНоутбуки(Set<Ноутбук> ноутбуки, Map<String, Object> фильтр) {
        Set<Ноутбук> результат = new HashSet<>();

        for (Ноутбук ноутбук : ноутбуки) {
            if (проходитПоУсловиям(ноутбук, фильтр)) {
                результат.add(ноутбук);
            }
        }

        return результат;
    }

    private static boolean проходитПоУсловиям(Ноутбук ноутбук, Map<String, Object> фильтр) {
        for (Map.Entry<String, Object> entry : фильтр.entrySet()) {
            String критерий = entry.getKey();
            Object значение = entry.getValue();

            switch (критерий) {
                case "озу":
                    if (ноутбук.getОзу() < (int) значение) {
                        return false;
                    }
                    break;
                case "объемЖД":
                    if (ноутбук.getОбъемЖД() < (int) значение) {
                        return false;
                    }
                    break;
                case "операционнаяСистема":
                    if (!ноутбук.getОперационнаяСистема().equalsIgnoreCase((String) значение)) {
                        return false;
                    }
                    break;
                case "цвет":
                    if (!ноутбук.getЦвет().trim().equalsIgnoreCase(((String) значение).trim())) {
                        return false;
                    }
                    break;
            }
        }

        return true;
    }
}

