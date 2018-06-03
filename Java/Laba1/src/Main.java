import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // сумма во вложеном цикле
        float first_sum = 0;
        // результирующая сумма
        float sum = 0;
        //индексы
        char m; //внешнего цикла
        char n; //внутреннего цикла
        //константа
        final int MY_CONST = 0;
        // Считывание из System.in
        Scanner reader = new Scanner(System.in);
        //Сканируем как int и переводим в char
        System.out.println("Введите n: ");
        n = (char)(reader.nextInt() + 48);
        System.out.println("Введите m: ");
        m = (char)(reader.nextInt() + 48);
        //закрываем stdin
        reader.close();
        System.out.println("n = " + n + ", m = " + m);
        //Подсчет выражения
        for(char i = '0'; i < n; i++) {
            if(i == '0') continue;
            float it = i;
            it -=48;
            for (char j = '0'; j <= m; j++ ) {
                if(j == '0') continue;
                float at = j;
                at -=48;
                first_sum += (it /at)/(it + MY_CONST);

            }
            sum += first_sum;
        }
        System.out.println("The result is :" + sum);
    }

}