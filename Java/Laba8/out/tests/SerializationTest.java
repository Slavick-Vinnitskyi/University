import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class SerializationTest {
    /**
     * Тест проверяет serializeList на ввод/чтение
     */
    @Test
    public void serializeList() throws IOException, ClassNotFoundException {
        MyList myList = new MyList();
        myList.addToList(new Bank1(43.2f, 17.9f, 18.0f, 60, 120));
        Serialization.serializeList("test1.bin", myList);
        MyList list = Serialization.deserializeList("test1.bin");
        assertEquals(list.allSize(), myList.allSize());
    }
    /**
     * Тест проверяет serializeSeq  на ввод/чтение
     */
    @Test
    public void serializeSeq() throws IOException, ClassNotFoundException {
        MyList myList = new MyList();
        myList.addToList(new Bank1(43.2f, 17.9f, 18.0f, 60, 120));
        Serialization.serializeSeq("test2.bin", myList);
        MyList hashSet = Serialization.deserializeSeq("test2.bin");
        assertEquals(myList.allSize(), hashSet.allSize());
    }


}