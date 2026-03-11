public class MonthData {

    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println(i + 1 + " день: " + days[i]);
        }
        System.out.println("-".repeat(45));
    }

    int sumStepsFromMonth() {
        int sumOfSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumOfSteps = sumOfSteps + days[i];
        }
        return sumOfSteps;
    }

    int maxSteps() {
        int maxOfSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxOfSteps) {
                maxOfSteps = days[i];
            }
        }
        return maxOfSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int bestSeries = 0;
        int currentSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                currentSeries++;
            } else {
                if (bestSeries < currentSeries) {
                    bestSeries = currentSeries;
                }
                currentSeries = 0;
            }
            if (i + 1 == days.length && currentSeries > bestSeries) { //доп. проверка если все 30 дней будет лучшая
                return currentSeries;                                // серия и в else цикл просто не зайдет
            }
        }
        return bestSeries;
    }
}
