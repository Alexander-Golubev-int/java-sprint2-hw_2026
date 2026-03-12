import java.util.Scanner;

public class Main {

    static String printMonth = "Выберите месяц где: 1 - январь, 2 - февралья, 3 - март, 4 - апрель " +
            "5 - май, 6 - июнь, 7 - июль, 8 - август, 9 - сентябрь, 10 - октрябрь, 11 - ноябрь, 12 - декабрь.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        System.out.println("-".repeat(79));
        System.out.println("Здрастсвуйте! Вас приветствует прототип шагомера v.1.0 Рад измерить ваши шаги!༼ つ ◕_◕ ༽つ");
        System.out.println("-".repeat(79));

        while (true) {
            printMenu();
            int cmd = scanner.nextInt();
            if (cmd == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (cmd == 2) {
                stepTracker.changeStepGoal();
            } else if (cmd == 3) {
                while (true) {
                    printSelectOfAction();
                    cmd = scanner.nextInt();
                    if (cmd == 1) {
                        System.out.println(printMonth);
                        cmd = scanner.nextInt();
                        if (cmd > 0 && cmd < 13) {
                            stepTracker.monthIndex[cmd - 1].printDaysAndStepsFromMonth();
                        } else {
                            System.out.println("Извините, но такого месяца нет!");
                        }
                    } else if (cmd == 2) {
                        System.out.println(printMonth);
                        cmd = scanner.nextInt();
                        if (cmd > 0 && cmd < 13) {
                            System.out.println("В этом месяце вы прошли : " +
                                    stepTracker.monthIndex[cmd - 1].sumStepsFromMonth() + ". Вы молодец!");
                        } else {
                            System.out.println("Извините, но такого месяца нет!");
                        }
                    } else if (cmd == 3) {
                        System.out.println(printMonth);
                        cmd = scanner.nextInt();
                        if (cmd > 0 && cmd < 13) {
                            System.out.println("Введите число шагов от которых будет считаться лучшая серия: ");
                            int goalOfSteps = scanner.nextInt();
                            System.out.println("Лучшая серия по шагам в этом месяца составила: " +
                                    stepTracker.monthIndex[cmd - 1].bestSeries(goalOfSteps));
                        } else {
                            System.out.println("Извините, но такого месяца нет!");
                        }
                    } else if (cmd == 4) {
                        System.out.println(printMonth);
                        cmd = scanner.nextInt();
                        if (cmd > 0 && cmd < 13) {
                            System.out.println("В этом месяце самая максимальное количество шагов за день было: " +
                                    stepTracker.monthIndex[cmd].maxSteps());
                        } else {
                            System.out.println("Извините, но такого месяца нет!");
                        }
                    } else if (cmd == 5) {
                        System.out.println(printMonth);
                        cmd = scanner.nextInt();
                        if (cmd > 0 && cmd < 13) {
                            stepTracker.printStatistic(cmd - 1);
                        } else {
                            System.out.println("Извините, но такого месяца нет!");
                        }
                    } else if (cmd == 6) {
                        break;
                    } else {
                        System.out.println("Такой команды ещё не сущетсвует, выберите другую! ");
                    }

                }
            } else if (cmd == 4) {
                System.out.println("Хорошо дня! ༼ つ ◕_◕ ༽つ");
                return;
            } else {
                System.out.println("Такой команды не существует! ");
            }
        }
    }

    static void printMenu() {
        System.out.println("---Выберите пункт меню, который вам нужен--- ");
        System.out.println("1. Ввод пройденного количества шагов за день. ");
        System.out.println("2. Изменить цель по количеству шагов в день. ");
        System.out.println("3. Вывод статистиски за определенный месяц. ");
    }

    static void printSelectOfAction() {
        System.out.println("-".repeat(45));
        System.out.println("Выберите пункт меню, который вам нужен. ");
        System.out.println("1. Количество пройденных шагов по дням в выбранном месяце. ");
        System.out.println("2. Сумма пройденных шагов за выбранный месяц. ");
        System.out.println("3. Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество" +
                " шагов за день было равно или выше целевого. ");
        System.out.println("4. Самое большое количество шагов за день. ");
        System.out.println("5. Вывод всей статистики за весь выбранный месяц. ");
        System.out.println("6. Выйти из данного меню. ");
    }
}