class Bank1 extends MainBank{
    /** Первый Банк который наслудует главный банк
     * @param percentUsualCredit Процент по обычному кредиту
     * @param percentHomeCredit Процент по  ипотеке
     * @param percentCarCredit Процент по кредиту на авто
     * @param maxMonthsUsual Макс. месяцев по обычному кредиту
     * @param maxMonthsCarAndHome Макс. месяцев по кредиту на авто или дом
     */

    Bank1(float percentUsualCredit, float percentHomeCredit, float percentCarCredit,
          int maxMonthsUsual, int maxMonthsCarAndHome) {
        super(percentUsualCredit, percentHomeCredit, percentCarCredit,
                maxMonthsUsual, maxMonthsCarAndHome);
    }
}
