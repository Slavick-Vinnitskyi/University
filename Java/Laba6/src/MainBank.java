public abstract class MainBank {
    //Процент по обычному кредиту и ипотеке
    private int maxMonthsUsual, maxMonthsCarAndHome;
    //Процент по кредиту на авто,  Макс. месяцев по обычному кредиту, по кредиту на авто или ипотеке
    private float percentUsualCredit, percentHomeCredit, percentCarCredit;

    /**
     * Конструктор
     * @param percentUsualCredit Процент по обычному кредиту
     * @param percentHomeCredit Процент по  ипотеке
     * @param percentCarCredit Процент по кредиту на авто
     * @param maxMonthsUsual Макс. месяцев по обычному кредиту
     * @param maxMonthsCarAndHome Макс. месяцев по кредиту на авто или ипотеке
     */
    MainBank(float percentUsualCredit, float percentHomeCredit, float percentCarCredit,
             int maxMonthsUsual, int maxMonthsCarAndHome) {
        this.percentCarCredit = percentCarCredit;
        this.percentHomeCredit = percentHomeCredit;
        this.percentUsualCredit = percentUsualCredit;
        this.maxMonthsUsual = maxMonthsUsual;
        this.maxMonthsCarAndHome = maxMonthsCarAndHome;
    }

    /**
     * @return Возвращает максимальное кол-во месяцев по ипотеке
     */
    public int getMaxMonthsUsual() {
        return maxMonthsUsual;
    }

    /**
     * @return @return Возвращает максимальное кол-во месяцев по кредиту
     */
    public int getMaxMonthsCarAndHome() {

        return maxMonthsCarAndHome;
    }

    /**
     * @return Возвращает процент по обычному кредиту
     */
    public float getPercentUsualCredit() {

        return percentUsualCredit;
    }

    /**
     * @return Возвращает процент по ипотеке
     */
    public float getPercentHomeCredit() {

        return percentHomeCredit;
    }

    /**
     * @return Возвращает процент по кредиту на авто
     */
    public float getPercentCarCredit() {

        return percentCarCredit;
    }
}