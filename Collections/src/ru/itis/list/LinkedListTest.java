package ru.itis.list;

import org.junit.Before;
import org.junit.Test;
import ru.itis.models.Contract;

import static org.junit.Assert.*;

public class LinkedListTest {
    private LinkedList<Contract> contractLinkedList;

    private final Contract CONTRACT = new Contract(1, "Sidikov", "Ypsupov", "02.02.02");
    private final Contract CONTRACT_1 = new Contract(1, "Sidikova", "Ypsupova", "02.02.02");
    private final Contract CONTRACT_2 = new Contract(1, "Sidikovs", "Ypsupovs", "02.02.02");
    @Before
    public void setUp() throws Exception {
        contractLinkedList = new LinkedList<>();
        contractLinkedList.add(CONTRACT);
        contractLinkedList.add(CONTRACT_1);
        contractLinkedList.add(CONTRACT_2);
    }

    @Test
    public void indexOf() throws Exception {
        int actual = contractLinkedList.indexOf(CONTRACT_1);
        int expected = 1;
        assertEquals(actual, expected);
    }

}
