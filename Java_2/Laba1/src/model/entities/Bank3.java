package model.entities;

public class Bank3 extends MainBank {
    /**
     * Третий Банк который наслудует главный банк
     *  @param percentUsualCredit  Процент по обычному кредиту
     * @param percentHomeCredit   Процент по  ипотеке
     * @param percentCarCredit    Процент по кредиту на авто
     * @param maxMonthsUsual      Макс. месяцев по обычному кредиту
     * @param maxMonthsCarAndHome Макс. месяцев по кредиту на авто или дом
     */
    public Bank3(float percentUsualCredit, float percentHomeCredit, float percentCarCredit,
                 int maxMonthsUsual, int maxMonthsCarAndHome) {
        super(percentUsualCredit, percentHomeCredit, percentCarCredit,
                maxMonthsUsual, maxMonthsCarAndHome);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Bank3)) {
            return false;
        }

        Bank3 c = (Bank3) o;

        return c.maxMonthsCarAndHome == this.maxMonthsCarAndHome
                && ((MainBank) o).maxMonthsUsual == this.maxMonthsUsual
                && ((MainBank) o).percentCarCredit == this.percentCarCredit
                && ((MainBank) o).percentUsualCredit == this.percentUsualCredit
                && ((MainBank) o).maxMonthsCarAndHome == this.maxMonthsCarAndHome
                && ((MainBank) o).percentHomeCredit == this.percentHomeCredit;

    }
}