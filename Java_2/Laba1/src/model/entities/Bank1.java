package model.entities;

public class Bank1 extends MainBank {

    /**
     * Первый Банк который наслудует главный банк
     *  @param percentUsualCredit  Процент по обычному кредиту
     * @param percentHomeCredit   Процент по  ипотеке
     * @param percentCarCredit    Процент по кредиту на авто
     * @param maxMonthsUsual      Макс. месяцев по обычному кредиту
     * @param maxMonthsCarAndHome Макс. месяцев по кредиту на авто или дом
     */

    public Bank1(float percentUsualCredit, float percentHomeCredit, float percentCarCredit,
                 int maxMonthsUsual, int maxMonthsCarAndHome) {
        super(percentUsualCredit, percentHomeCredit, percentCarCredit,
                maxMonthsUsual, maxMonthsCarAndHome);
    }
    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Bank1)) {
            return false;
        }
        Bank1 c = (Bank1) o;


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