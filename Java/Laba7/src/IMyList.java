public interface IMyList<MainBank> extends Iterable<MainBank>, HelpInterface{
    /**
     *
     * @return Возвращает размер списка(заполненные)
     */
    int size();

    /**
     *
     * @return Возвращает полный размер списка (ячейки с выделенной памятью)
     */
    int allSize();

    /**
     *
     * @param index индекс банка в списке
     * @return Возвращает Банк
     */
    MainBank get(int index);

    /**
     * @param index индекс банка в списке
     * @return Возвращает процент по обычному кредиту
     */
    float getpercentUsualCredit(int index);

    /**
     * @param index индекс банка в списке
     * @return Возвращает процент по ипотеке
     */
    float getpercentHomeCredit(int index);

    /**
     * @param index индекс банка в списке
     * @return Возвращает процент по кредиту на авто
     */
    float getpercentCarCredit(int index);

    /**
     * @param index индекс банка в списке
     * @return Возвращает максимальное кол-во месяцев по ипотеке
     */
    int getmaxMonthsUsual(int index);

    /**
     * @param index индекс банка в списке
     * @return Возвращает максимальное кол-во месяцев по кредиту
     */
    int maxMonthsCarAndHome(int index);


}
