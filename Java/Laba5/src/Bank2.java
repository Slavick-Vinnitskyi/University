class Bank2 extends MainBank{
    //ще один банк
    Bank2(float percentUsualCredit, float percentHomeCredit, float percentCarCredit,
          int maxMonthsUsual, int maxMonthsCarAndHome) {
        super(percentUsualCredit, percentHomeCredit, percentCarCredit,
                maxMonthsUsual, maxMonthsCarAndHome);
    }
}
