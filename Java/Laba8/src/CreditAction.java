public class CreditAction {
    private MainBank[] mainBanks;
    /**
     * Конструктор класса
     * @param numberOfBank Розмерность массива обьектов
     */
    CreditAction(int numberOfBank) {
        this.mainBanks = new MainBank[numberOfBank];
    }
    /**
     * В этом методе берётся новый кредит
     * @param list Список банков
     * @param credit Тип кредита
     * @param sum Сумма кредита
     * @param period Период
     * @return Сумма к погашению
     */
    public float getNewCredit(MyList list, int credit, int sum, int period) {
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
            default:
                break;
        }
        return sum * (1 + (percentCredit / 100) * (period / 12));
    }

    /**
     * @param list Список банков
     * @param credit Тип кредита
     * @return Максимальний период на который можно взять кредит
     */

    public int getMaxMonthsCredit(MyList list, int credit) throws MyException{
        int maxMonthsCredit = 0;
        switch (credit) {

            case 1:
                maxMonthsCredit = list.get(0).getMaxMonthsUsual();
                break;
            case 2:
                maxMonthsCredit = list.get(1).getMaxMonthsCarAndHome();
                break;
            case 3:
                maxMonthsCredit = list.get(2).getMaxMonthsCarAndHome();
                break;
            default:
                break;
        }
        return maxMonthsCredit;
    }

    /**
     * @param list Список банков
     * @param index Индекс
     * @return Значения минимальных та максимальных месяцев

     */
    public int MinMaxMonths(MyList list, int index) {
        int[] creditMonths = new int[list.size() * 2];
        for(int j = 0, n = list.size(),i = 0; j < n ; j++, i += 2) {
            creditMonths[i] = list.get(j).getMaxMonthsUsual();
            creditMonths[i + 1] = list.get(j).getMaxMonthsCarAndHome();
        }
        int temp;
        for (int j = 1; j < creditMonths.length; j++) {
            for (int k = creditMonths.length - 1; k >= j; k--) {
                if (creditMonths[k] > creditMonths[k - 1]) {
                    temp = creditMonths[k - 1];
                    creditMonths[k - 1] = creditMonths[k];
                    creditMonths[k] = temp;
                }
            }
        }
        return creditMonths[index];
    }

    /** Функция дублирует предидущую, но для float значений
     * @param list Список банков
     * @param index Индекс
     * @return Значения минимальных та максимальных процентов
     */
    public float MinMaxCredit(MyList list,int index) {
        float[] creditCredit = new float[list.size() * 3];

        for(int j = 0, i = 0, n = list.size(); j < n; j++, i += 3) {
            creditCredit[i] =  list.get(j).getPercentCarCredit();
            creditCredit[i + 1] = list.get(j).getPercentHomeCredit();
            creditCredit[i + 2] = list.get(j).getMaxMonthsUsual();

        }
        float temp;
        for (int j = 1, n = creditCredit.length; j < n; j++) {
            for (int k = creditCredit.length - 1; k >= j; k--) {
                if (creditCredit[k] > creditCredit[k - 1]) {
                    temp = creditCredit[k - 1];
                    creditCredit[k - 1] = creditCredit[k];
                    creditCredit[k] = temp;
                }
            }
        }
        return creditCredit[index];
    }
}
