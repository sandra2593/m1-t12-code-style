import java.util.Scanner;

public class calculateDeposit {
    double calculateComplexPercent(double amount, double rate, int depositPeriod) {
        double pay = amount * Math.pow((1 + rate / 12), 12 * depositPeriod);
        return roundValue(pay, 2);
    }

    double calculateSimplePercent(double amount, double rate, int depositPeriod) {
        return roundValue(amount + amount * rate * depositPeriod, 2);
    }

    double roundValue(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void printFinalAccoutSum() {
        int period;
        int action;
        int amount;
        double percent = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");

        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");

        action = scanner.nextInt();
        if (action == 1) {
            percent = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            percent = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + percent);
    }

    public static void main(String[] args) {
        new calculateDeposit().printFinalAccoutSum();
    }
}
