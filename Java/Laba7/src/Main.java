import java.util.Scanner;
/*
Сформувати набір пропозицій клієнту по цільовим кредитам різних банків.
Враховувати можливість дострокового погашення кредиту й\або збільшення
кредитної лінії. Реалізувати вибір та пошук кредиту за будь-якими
параметрами.
*/
public class Main {
    /**
     * Старт програми відбувається тут
     * Создается список обьектов трёх банков с которыми мы можем выполнять дальнейшие действия в creditAction
     * @param args
     */
    public static void main(String[] args) {
        //"Вибір кредиту за банком" или "Пошук кредиту за параметрами" или "Вихід"
        int chooseOrFind;
        //Номер банка
        int check_bank;
        //Тип кредита
        int credit;
        //Сумма кредита
        int suma;
        //Период кредита
        int period;
        //"Достроково погасити" или Збільшити період" или "Нові кредити" или "Вихід"
        int addAction;
        //Длина нового периода
        int new_period;
        //Возвращаемая сумма
        float newCreditMany;

        CreditAction creditAction = new CreditAction(3);
        MyList myList = new MyList();

        myList.addToList(new Bank1(43.2f, 17.9f, 18.0f, 60, 120));
        myList.addToList(new Bank2(55.6f, 19.9f, 22.0f, 48, 180));
        myList.addToList(new Bank3(49.9f, 19.9f, 19.9f, 72, 240));

        // "і" и "j" управляют выходом из программы
        boolean i = true;
        boolean j;
        while (i){
            j = true;
            System.out.println("1--Вибір кредиту за банком\n2--Пошук кредиту за параметрами\n3--Вихід");
            chooseOrFind = ChooseAction(3);
            while (j) {
                if (chooseOrFind == 1) {
                    //Ввод от пользователя, выбор банка
                    System.out.println("1--Банк 1\n2--Банк 2\n3--Банк 3");
                    check_bank = ChooseAction(3);
                    //Ввод от пользователя, выбор целевого кредита
                    System.out.println("1--Звичайний кредит\n2--Іпотека\n3--Кредит на авто");
                    credit = ChooseAction(3);
                    //Ввод от пользователя, сумма кредита
                    System.out.println("Введіть суму кредиту - ");
                    suma = ChooseAction(500000);
                    //Ввод от пользователя, период кредита
                    System.out.println("На який період - ");
                    float creditMany = 0;
                        try {
                    period = ChooseAction(creditAction.getMaxMonthsCredit(myList, credit));
                    //Сумма которую нужно отдать банку за кредитный период
                    creditMany = creditAction.getNewCredit(myList, credit, suma, period);
                    System.out.printf("Взятий новий кредит на суму %d грн на період %d місяці\nПотрібно повернути %f грн\n",
                        suma, period, creditMany);
                        }catch (MyException e) {
                            System.out.println(e.getNumb());
                            e.purpose();
                        }
                    System.out.println("1--Достроково погасити\n2--Збільшити період\n3--Нові кредити\n4--Вихід");
                    //Выбор способа взаємодействия
                    addAction = ChooseAction(4);
                if (addAction == 4) {
                        i = false;
                        j = false;
                }else if (addAction == 3) {
                        i = true;
                        j = false;
                }else if (addAction == 2) {

                    //Блок увеличения времени на возвращение кредита
                    System.out.println("Вкажіть новий період - ");

                    try {
                        new_period = ChooseAction(creditAction.getMaxMonthsCredit(myList, credit));
                        newCreditMany = newPeriod(myList, credit, suma, new_period, creditAction);
                        System.out.printf("Треба було повернути %f грн\nА тепер треба повернути %f грн\n", creditMany, newCreditMany);
                        creditMany = newCreditMany;
                        period = new_period;
                    }catch (MyException e){
                        System.out.println(e.getNumb());
                        e.purpose();}

                 } else {
                    //Досрочное погашение кредита
                    System.out.printf("Достроково погасити %f грн?\n1--Так\n2--Ні\n", creditMany);
                    if (ChooseAction(2) == 1)
                        System.out.printf("Кредит %f грн достроково погашено, заплачено було %d\n", creditMany, suma);
                    else
                        j = false;
                }

                }
                else if (chooseOrFind == 2) {
                    //Поиск по пареметрам(сортировка)
                    System.out.println("1--Найменший та найбільший відсоток\n2--Найдовший та найменший період\n3--До головного меню");
                    credit = ChooseAction(3);
                    if (credit == 3)
                        j = false;
                    else if(credit == 2){
                        System.out.printf("Найдовший період - %d\nНайкоротший - %d\n",
                                creditAction.MinMaxMonths(myList,0), creditAction.MinMaxMonths(myList,5));
                    }else
                        System.out.printf("Найдовший період - %f\nНайкоротший - %f\n",
                                creditAction.MinMaxCredit(myList,0), creditAction.MinMaxCredit(myList,5));

                }
                else {
                    j = false;
                    i = false;
                }
            }
        }
    }

    /**
     * Метод для выбора действия в интерфейсе
     * @param max максимальное значение(месяцев, процентов)
     * @return Действие в интерфейсе
     */

    private static int ChooseAction(int max) {
        int num;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.printf("Ведіть число від %d до %d: ", 1, max);
            while (!scan.hasNextInt()) {
                System.out.printf("Ведіть число!!! від %d до %d: ", 1, max);
                scan.next();
            }
            num = scan.nextInt();
        }while ((num > max) || (num < 1));
        return num;

    }

    /**
     * @param myList Список банков
     * @param credit Тип кредита
     * @param suma Сумма кредита
     * @param new_period Длина нового периода
     * @param creditAction Обьект нужен для создания нового метода
     * @return Новый период, используется метод getNewCredit, как и для обычного кредита
     */
    private static float newPeriod(MyList myList, int credit, int suma, int new_period, CreditAction creditAction) {

        return creditAction.getNewCredit(myList, credit, suma, new_period);
    }

}
