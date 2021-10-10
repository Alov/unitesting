package me.alov.unitesting.list;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCustomListTest {

    @Test
    public void addSingleItem() {
        MyCustomList<String> list = new MyCustomList<>();
        String data = "test1";

        list.add(data);

        assertEquals(data, list.get(0));
    }

    @Test
    public void addFromArray() {
        MyCustomList<String> list = new MyCustomList<>();
        String[] data = new String[] {"test1", "test2", "test3"};

        list.add(data);

        assertEquals(data.length, list.size());
        for (int i = 0; i < data.length; i++) {
            assertEquals(data[i], list.get(i));
        }
    }

    @Test
    public void addMultipleItems() {
        MyCustomList<String> list = new MyCustomList<>();
        String data1 = "test1";
        String data2 = "test2";
        String data3 = "test3";

        list.add(data1);
        list.add(data2);
        list.add(data3);

        assertEquals(3, list.size());
        assertEquals(data1, list.get(0));
        assertEquals(data2, list.get(1));
        assertEquals(data3, list.get(2));
    }

    @Test
    public void addToFirstPosition() {
        MyCustomList<String> list = new MyCustomList<>();
        String[] data = new String[] {"test1", "test2", "test3"};

        list.add(data);
        list.add("test4", 0);

        assertEquals("test4", list.get(list.size() - 1));
    }

    @Test
    public void addToSecondPosition() {
        List<String> actualList = new MyCustomList<>();
        List<String> expList = new MyCustomList<>();
        String[] actual = new String[]{"test1", "test2", "test3"};
        String[] expectedArray = new String[]{"test1", "test2", "test4", "test3"};
        expList.add(expectedArray);

        actualList.add(actual);
        actualList.add("test4", 1);

        assertEquals(expList.get(2), actualList.get(2));
    }

    @Test
    public void addToLastPosition() {
        List<String> actual = new MyCustomList<>();
        actual.add(new String[]{"test1", "test2", "test3"});
        List<String> expected = new MyCustomList<>();
        expected.add(new String[]{"test4", "test1", "test2", "test3"});

        actual.add("test4", actual.size());

        assertEquals("test4", actual.get(0));
    }

    @Test
    public void testStringCasting() {
        List<String> actual = new MyCustomList<>();
        actual.add(new String[]{"test1", "test2", "test3"});

        assertEquals("test1,test2,test3,", actual.toString());

        actual = new MyCustomList<>();
        assertEquals("", actual.toString());

    }

}