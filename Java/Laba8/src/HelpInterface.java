/**
 * Интерфейс создан из-за ошибки в IDE
 * При присутствии метода AddList в интерфейсе IMyList
 * происходила ошибка типв "method does not override from its superclass"
 */
public interface HelpInterface {
    /**
     * Метод добавляет в список новый банк
     * @param item Банк который нужно добавить
     * @return Список с добавленным елементом Банк
     */
    boolean addToList(MainBank item);
}
