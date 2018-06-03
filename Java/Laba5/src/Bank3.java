class Bank3 extends MainBank{
    //і ще один банк
    Bank3(float percentUsualCredit, float percentHomeCredit, float percentCarCredit,
          int maxMonthsUsual, int maxMonthsCarAndHome) {
        super(percentUsualCredit, percentHomeCredit, percentCarCredit,
                maxMonthsUsual, maxMonthsCarAndHome);
    }
}