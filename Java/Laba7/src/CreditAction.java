import java.util.Arrays;

public class CreditAction {
    private MainBank[] mainBanks;
    /**
     * Конструктор класса
     * @param numberOfBank Розмерность массива обьектов
     */
    CreditAction(int numberOfBank) {
        mainBanks = new MainBank[numberOfBank];
    }
    /**
     * В этом методе берётся новый кредит
     * @param list Список банков
     * @param credit Тип кредита
     * @param suma Сумма кредита
     * @param period Период
     * @return Сумма к погашению
     */
    public float getNewCredit(MyList list, int credit, int suma, int period) {
        float percentCredit = 0.0f;
        switch (credit) {
            case 1:
                percentCredit = list.get(0).getPercentUsualCredit();
                break;
            case 2:
                percentCredit = list.get(1).getPercentHomeCredit();
                break;
            case 3:
                percentCredit = list.get(2).getPercentCarCredit();
                break;
        }
        return suma * (1 + (percentCredit / 100) * (period / 12));
    }

    /**
     * @param list Список банков
     * @param credit Тип кредита
     * @return Максимальний период на который можно взять кредит
     */

    public int getMaxMonthsCredit(MyList list, int credit) throws MyException{
        int a = 0;
        switch (credit) {

            case 1:
                a = list.get(0).getMaxMonthsUsual();
                break;
            case 2:
                a = list.get(1).getMaxMonthsCarAndHome();
                break;
            case 3:
                a = list.get(2).getMaxMonthsCarAndHome();
                break;
        }
        return a;
    }

    /**
     * @param list Список банков
     * @param who Индекс
     * @return Значения минимальных та максимальных месяцев

     */
    public int MinMaxMonths(MyList list,int who) {
        int[] creditMonths = new int[6];
        int i = 0;
        for(int j = 0 ,n = list.size(); j < n ; j++) {
            creditMonths[i] = list.get(j).getMaxMonthsUsual();
            creditMonths[i + 1] = list.get(j).getMaxMonthsCarAndHome();
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

    /** Функция дублирует предидущую, но для float значений
     * @param list Список банков
     * @param who Индекс
     * @return Значения минимальных та максимальных процентов
     */
    public float MinMaxCredit(MyList list,int who) {
        float[] creditCredit = new float[9];
        int i = 0;
        for(int j = 0 ; j< list.size();j++) {
            creditCredit[i] =  list.get(j).getPercentCarCredit();
            creditCredit[i + 1] = list.get(j).getPercentHomeCredit();
            creditCredit[i + 2] = list.get(j).getMaxMonthsUsual();
            i += 3;
        }
        float flag;
        for (int j = 1, n = creditCredit.length; j < n; j++) {
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
