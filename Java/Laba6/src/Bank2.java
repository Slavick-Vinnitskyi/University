class Bank2 extends MainBank{
    /**
     *  Второй Банк который наслудует главный банк
     * @param percentUsualCredit Процент по обычному кредиту
     * @param percentHomeCredit Процент по  ипотеке
     * @param percentCarCredit Процент по кредиту на авто
     * @param maxMonthsUsual Макс. месяцев по обычному кредиту
     * @param maxMonthsCarAndHome Макс. месяцев по кредиту на авто или дом
     */
    Bank2(float percentUsualCredit, float percentHomeCredit, float percentCarCredit,
          int maxMonthsUsual, int maxMonthsCarAndHome) {
        super(percentUsualCredit, percentHomeCredit, percentCarCredit,
                maxMonthsUsual, maxMonthsCarAndHome);
    }
}
