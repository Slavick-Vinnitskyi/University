public class MainBank {
    private int minMonths, maxMonthsUsual, maxMonthsCarAndHome;
    private float percentUsualCredit, percentHomeCredit, percentCarCredit;
    //в конструкторі приймаються значення процентів звичайного, іпотечного та кредиту на автомобіль
    //та максимально можливий термін взяття кредиту
    MainBank(float percentUsualCredit, float percentHomeCredit, float percentCarCredit,
             int maxMonthsUsual, int maxMonthsCarAndHome) {
        this.percentCarCredit = percentCarCredit;
        this.percentHomeCredit = percentHomeCredit;
        this.percentUsualCredit = percentUsualCredit;
        this.maxMonthsUsual = maxMonthsUsual;
        this.maxMonthsCarAndHome = maxMonthsCarAndHome;
    }
    //гетери для отримання значеннь відсотків та макс значень
    public int getMaxMonthsUsual() {
        return maxMonthsUsual;
    }

    public int getMaxMonthsCarAndHome() {
        return maxMonthsCarAndHome;
    }

    public float getPercentUsualCredit() {
        return percentUsualCredit;
    }

    public float getPercentHomeCredit() {
        return percentHomeCredit;
    }

    public float getPercentCarCredit() {
        return percentCarCredit;
    }
}