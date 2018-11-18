package serialization;//import java.io.*;
///**
// * Класс реалізует ввод/вывод данных в файл
// */
//public class serialization.Serialization {
//    /**
//     * Метод сериализаации/записи файла колекции как одного обьекта.
//     * @param file Название файла
//     * @param list Название коллекции
//     */
//    public static void serializeList(String file, MyList list) throws IOException {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
//            oos.writeObject(list);
//            oos.flush();
//        }
//    }
//    /**
//     * Метод сериализаации/записи файла колекции как последовательности обьектов.
//     * @param file Название файла
//     * @param list Название коллекции
//     */
//    public static void serializeSeq(String file, MyList list) throws IOException {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
//            oos.writeInt(list.size());
//            for (int i = 0; i < list.size(); i++) {
//                if (list.get(i) != null)
//                    oos.writeObject(list.get(i));
//            }
//            oos.flush();
//        }
//    }
//    /**
//     * Метод десериализаации/считывания файла колекции как одного обьекта.
//     * @param file Название файла
//     */
//    public static MyList deserializeList(String file) throws IOException, ClassNotFoundException {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
//            return (MyList) ois.readObject();
//        }
//    }
//    /**
//     * Метод десериализаации/считывания файла колекции как последовательности обьектов.
//     * @param file Название файла
//     */
//    public static MyList deserializeSeq(String file) throws IOException, ClassNotFoundException {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
//            int size = ois.readInt();
//            MyList set = new MyList();
//            for (int i = 0; i < size; i++) {
//                set.add(ois.readObject());
//            }
//            return set;
//        }
//    }
//}
import model.entities.BankSystem;
import model.list.MyList;

import java.io.*;
import java.util.Iterator;

/**
 * Делаем запись одновременно для Списка ListIntr и для массива обьектов Train
 * @param <T> При создвнии, мы указываем <T>, что указывает на тип обьекта
 */
public class Serialization <T> implements Serializable {
    static final long serialVersionUID = 48L;

    public boolean writeObj(T obj, String fileName) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();

        return true;
    }
    public boolean writeObjAsSequence(MyList obj, String fileName) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        Iterator iterator = obj.iterator();
        while(iterator.hasNext()) {
            objectOutputStream.writeObject(iterator.next());
        }
//        objectOutputStream.writeObject(obj);

        objectOutputStream.close();
        return true;
    }

    /**
     * @param fileName имя файла
     * @return Возвр обьект (model.entities.BankSystem или MyList)
     * @throws Exception ex
     */
    public T readObj(String fileName) throws Exception {

        FileInputStream fileInputStream = new FileInputStream(fileName);

        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        T obj = (T) objectInputStream.readObject();
        objectInputStream.close();
        return obj;
    }

    public MyList readObjAsSequence(String fileName) throws Exception {

        FileInputStream fileInputStream = new FileInputStream(fileName);

        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        MyList train = (MyList) objectInputStream.readObject();
        objectInputStream.close();
        return train;
    }

    /**
     * @param fileName   Входные данные - имя файла
     * @param bankSystem train
     * @return если все ок, то true
     * @throws IOException если не сможет записать
     */
    public boolean writeToTxt(String fileName, BankSystem bankSystem) throws IOException {
        File file = new File(fileName);
        // Создание файла
        file.createNewFile();
        // Создание объекта FileWriter
        FileWriter writer = new FileWriter(file);
        // Запись содержимого в файл
        for (int i = 0; i < bankSystem.banks.length; i++) {

            writer.write(bankSystem.banks[i].getPercentUsualCredit() + " ");
            writer.write(bankSystem.banks[i].getPercentHomeCredit() + " ");
            writer.write(bankSystem.banks[i].getPercentCarCredit() + " ");
            writer.write(bankSystem.banks[i].getMaxMonthsUsual() + " ");
            writer.write(bankSystem.banks[i].getMaxMonthsCarAndHome() + "\n");
        }
        writer.flush();
        writer.close();

        return true;
    }

    /**
     * @param fileName имя файла
     * @return Возвр класс Train с последовательными элементами
     * @throws IOException если нет такого файла
     */
    public BankSystem readFromTxt(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName); // читаем файл
        byte[] array = new byte[in.available()];
        in.read(array);
        String text = new String(array);
        String lines[] = text.split("\n");// Прочитали файл и разделили на строки
        String tempLines[];
        BankSystem train = new BankSystem();
        for (int i = 0; i < lines.length; i++) {
            tempLines = lines[i].split(" ");
            // Теперь строку разделили на цифры (через пробел) и записали последовательно в нужные ячейки
            train.banks[i].percentUsualCredit = Float.parseFloat(tempLines[0]);
            train.banks[i].percentHomeCredit = Float.parseFloat(tempLines[1]);
            train.banks[i].percentCarCredit = Float.parseFloat(tempLines[2]);
            train.banks[i].maxMonthsUsual = Integer.parseInt(tempLines[3]);
            train.banks[i].maxMonthsCarAndHome = Integer.parseInt(tempLines[3]);
        }

        return train;
    }
}