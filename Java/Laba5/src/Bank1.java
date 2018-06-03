class Bank1 extends MainBank{
    //просто банк який наслідує головний банк
    Bank1(float percentUsualCredit, float percentHomeCredit, float percentCarCredit,
          int maxMonthsUsual, int maxMonthsCarAndHome) {
        super(percentUsualCredit, percentHomeCredit, percentCarCredit,
                maxMonthsUsual, maxMonthsCarAndHome);
    }
}
