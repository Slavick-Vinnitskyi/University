import java.io.*;
/**
 * Класс реалізует ввод/вывод данных в файл
 */
public class Serialization {
    /**
     * Метод сериализаации/записи файла колекции как одного обьекта.
     * @param file Название файла
     * @param list Название коллекции
     */
    public static void serializeList(String file, MyList list) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(list);
            oos.flush();
        }
    }
    /**
     * Метод сериализаации/записи файла колекции как последовательности обьектов.
     * @param file Название файла
     * @param list Название коллекции
     */
    public static void serializeSeq(String file, MyList list) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeInt(list.size());
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null)
                    oos.writeObject(list.get(i));
            }
            oos.flush();
        }
    }
    /**
     * Метод десериализаации/считывания файла колекции как одного обьекта.
     * @param file Название файла
     */
    public static MyList deserializeList(String file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (MyList) ois.readObject();
        }
    }
    /**
     * Метод десериализаации/считывания файла колекции как последовательности обьектов.
     * @param file Название файла
     */
    public static MyList deserializeSeq(String file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            int size = ois.readInt();
            MyList set = new MyList();
            for (int i = 0; i < size; i++) {
                set.addToList((MainBank) ois.readObject());
            }
            return set;
        }
    }
}
