public class Converter {

    public static int convertToKm(int steps) {
        return (int)(steps * 0.75) / 1000;
    }

    public static int convertStepsToKilocalories(int steps) {
        return steps * 50 /1000;
    }
}
