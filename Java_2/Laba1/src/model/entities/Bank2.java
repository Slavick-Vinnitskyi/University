package model.entities;

public class Bank2 extends MainBank {
    /**
     *  Второй Банк который наслудует главный банк
     * @param percentUsualCredit Процент по обычному кредиту
     * @param percentHomeCredit Процент по  ипотеке
     * @param percentCarCredit Процент по кредиту на авто
     * @param maxMonthsUsual Макс. месяцев по обычному кредиту
     * @param maxMonthsCarAndHome Макс. месяцев по кредиту на авто или дом
     */
    public Bank2(float percentUsualCredit, float percentHomeCredit, float percentCarCredit,
                 int maxMonthsUsual, int maxMonthsCarAndHome) {
        super(percentUsualCredit, percentHomeCredit, percentCarCredit,
                maxMonthsUsual, maxMonthsCarAndHome);
    }
    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Bank2)) {
            return false;
        }
        Bank2 c = (Bank2) o;


        if (c.maxMonthsCarAndHome == this.maxMonthsCarAndHome
                && ((MainBank) o).maxMonthsUsual == this.maxMonthsUsual
                && ((MainBank) o).percentCarCredit == this.percentCarCredit
                && ((MainBank) o).percentUsualCredit == this.percentUsualCredit
                && ((MainBank) o).maxMonthsCarAndHome == this.maxMonthsCarAndHome
                && ((MainBank) o).percentHomeCredit == this.percentHomeCredit) {
            return true;
        }

        return false;

    }

}
