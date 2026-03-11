import java.util.Scanner;
import java.util.Locale;

public class StepTracker {

    MonthData[] monthIndex = new MonthData[12];
    Scanner scanner;
    int goalByStepsPerDay = 500;

    public StepTracker(Scanner scanner) {
        for (int i = 0; i < monthIndex.length; i++) {
            monthIndex[i] = new MonthData();
        }
        this.scanner = scanner;
        this.scanner.useLocale(Locale.US); // пришлось добавить эту строчку, т.к. стоит ру версия IDE и с "." были
        // проблемы и при вводе дробных чисел ловил вылет.
    }

    void addNewNumberStepsPerDay() {
        System.out.print("Введите номер месяца от 1(январь) до 12(декабрь): ");
        int numberOfMonth = scanner.nextInt();
        if (numberOfMonth > 12 || numberOfMonth < 1) {
            System.out.println("Вы ввели не существующий месяц!");
            return;
        }
        System.out.print("Введите номер дня от 1 до 30(включительно): ");
        int dayOfMonth = scanner.nextInt();
        if (dayOfMonth > 30 || dayOfMonth < 1) {
            System.out.println("Вы ввели не существующий день!");
            return;
        }
        System.out.print("Введите количество шагов. Число должно быть целым и положительным: ");
        int amountOfSteps;
        if (scanner.hasNextDouble()) { // доп. проверка если число оказывается с плавающей точкой
            double numberWithPoint = scanner.nextDouble();
            amountOfSteps = (int) numberWithPoint;
            if (amountOfSteps < 0) {
                System.out.println("Введено число меньше нуля!");
                return;
            }
        } else {
            amountOfSteps = scanner.nextInt();
            if (amountOfSteps < 0) {
                System.out.println("Введено число меньше нуля!");
                return;
            }
        }
        monthIndex[numberOfMonth - 1].days[dayOfMonth - 1] =
                monthIndex[numberOfMonth - 1].days[dayOfMonth - 1] + amountOfSteps;
        System.out.println("-".repeat(45));
    }

    void changeStepGoal() {
        System.out.println("Поставьте цель сколько вы бы хотели проходить шагов в день: ");
        int goalByStepsFromUser = scanner.nextInt();
        if (goalByStepsFromUser <= 0 ) {
            System.out.println("Введено число равное или меньше нуля.");
            return;
        }
        System.out.print("Старая цель по ежедневному количеству шагов изменена c : " + goalByStepsPerDay + ". ");
        goalByStepsPerDay = goalByStepsFromUser;
        System.out.println("Новая цель по шагам теперь: " + goalByStepsPerDay + ". ");
    }

    void printStatistic(int month) {
        monthIndex[month].printDaysAndStepsFromMonth();
        System.out.println("Общее количество шагов за этот месяц составило: " + monthIndex[month].sumStepsFromMonth());
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthIndex[month].maxSteps());
        System.out.println("Среднее количество шагов за этот месяц составило: " +
                (monthIndex[month].sumStepsFromMonth() / 30));
        System.out.println("Пройденная дистанция составила: " + Converter.convertToKm(monthIndex[month].maxSteps()) +
                " километров.");
        System.out.println("Количество сожжёных килокалорий составило: " +
                Converter.convertStepsToKilocalories(monthIndex[month].maxSteps()));
        System.out.println("Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество " +
                "шагов за день было равно или выше целевого: " + monthIndex[month].bestSeries(goalByStepsPerDay));
    }
}
