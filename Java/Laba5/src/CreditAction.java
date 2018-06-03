import java.util.Arrays;

public class CreditAction {
    private MainBank[] mainBanks;
    private int numberOfBank = 0;
    //в конструкторі вказуєм розмірність масиву об'єктів
    CreditAction(int numberOfBank) {
        mainBanks = new MainBank[numberOfBank];
    }
    // заповнюєм масив об'єктів екземплярами класів нащадків
    public void addNewBank(MainBank mainBank) {
        mainBanks[numberOfBank] = mainBank;
        numberOfBank++;
    }
    // в цьому методі "берем новий" кредит
    public float getNewCredit(int bank, int credit, int suma, int period) {
        float percentCredit = 0.0f;
        switch (credit) {
            case 1:
                percentCredit = mainBanks[bank - 1].getPercentUsualCredit();
                break;
            case 2:
                percentCredit = mainBanks[bank - 1].getPercentHomeCredit();
                break;
            case 3:
                percentCredit = mainBanks[bank - 1].getPercentCarCredit();
                break;
        }
        return suma * (1 + (percentCredit / 100) * (period / 12));
    }
    // дізнаємось максимальний період на який можна взяти кредит
    public int getMaxMonthsCredit(int bank, int credit) {
        int a = 0;
        switch (credit) {
            case 1:
                a = mainBanks[bank - 1].getMaxMonthsUsual();
                break;
            case 2:
                a = mainBanks[bank - 1].getMaxMonthsCarAndHome();
                break;
            case 3:
                a = mainBanks[bank - 1].getMaxMonthsCarAndHome();
                break;
        }
        return a;
    }
    //повертаються значення мінімальних та максимальних відсотків і місяців
    public int MinMaxMonths(int who) {
        int[] creditMonths = new int[6];
        int i = 0;
        for (MainBank mainBank : mainBanks) {
            creditMonths[i] = mainBank.getMaxMonthsUsual();
            creditMonths[i + 1] = mainBank.getMaxMonthsCarAndHome();
            i += 2;
        }
        System.out.println(Arrays.toString(creditMonths));
              int flag;
        for (int j = 1; j < creditMonths.length; j++) {
            for (int k = creditMonths.length - 1; k >= j; k--) {
                if (creditMonths[k] > creditMonths[k - 1]) {
                    flag = creditMonths[k - 1];
                    creditMonths[k - 1] = creditMonths[k];
                    creditMonths[k] = flag;
                }
            }
        }

        System.out.println(Arrays.toString(creditMonths));
        if (who == 0)
            return creditMonths[who];
        else
            return creditMonths[who];
    }

    public float MinMaxCredit(int who) {
        float[] creditCredit = new float[9];
        int i = 0;
        for (MainBank mainBank : mainBanks) {
            creditCredit[i] =  mainBank.getPercentCarCredit();
            creditCredit[i + 1] = mainBank.getPercentHomeCredit();
            creditCredit[i + 2] = mainBank.getMaxMonthsUsual();
            i += 3;
        }
        float flag;
        for (int j = 1; j < creditCredit.length; j++) {
            for (int k = creditCredit.length - 1; k >= j; k--) {
                if (creditCredit[k] > creditCredit[k - 1]) {
                    flag = creditCredit[k - 1];
                    creditCredit[k - 1] = creditCredit[k];
                    creditCredit[k] = flag;
                }
            }
        }
        if (who == 0)
            return creditCredit[who];
        else
            return creditCredit[creditCredit.length - 1];
    }
}
