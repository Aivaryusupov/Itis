package ru.itis.main.storages;

import org.junit.Before;
import org.junit.Test;
import ru.itis.main.exceptions.UserNotFoundException;
import ru.itis.main.models.User;

import static org.junit.Assert.*;


public class UsersDataStorageTest {

    // объектная переменная для тестируемого класса
    private UsersDataStorage usersDataStorage;

    @Before // Before - говорит JUnit-у о том, что этот метод
    // нужно вызывать перед каждым тестом
    public void setUp() throws Exception {
    }

    @Test // Test - говорит JUnit-у, что данный метод является методом-тестом
    public void testFind() throws Exception {
        User expected = new User(3, "ayazTheBest", "qwerty008", "Ayaz", 25);
        User actual = usersDataStorage.find(3);
        assertEquals(expected, actual);
    }

    @Test(expected = UserNotFoundException.class)
    public void testFindIncorrectData() throws Exception {
        usersDataStorage.find(34);
    }

    // проверить на работоспособность
    @Test
    public void testSave() throws Exception {
        User actual = new User(5, "ayazTheBest", "qwerty008", "Ayaz", 25);
        idToFind = usersDataStorage.save(actual);
        User expected = usersDataStorage.find(idToFind);
        assertEquals(expected,actual);
    }

    // ???
    @Test
    public void testFindAll() throws Exception {

    }

    // Какой exception выдаст
    @Test(expected = )
    public void testDelete() throws Exception {
        User actual = new User(6, "ayazTheBest", "qwerty008", "Ayaz", 25);
        idToDelete = usersDataStorage.save(actual);
        usersDataStorage.delete(idToDelete);
        usersDataStorage.find(idToDelete);
    }

    // проверить на работоспособность
    @Test
    public void testUpdate() throws Exception {
        User someone = new User(7, "ayazTheBest", "qwerty008", "Ayaz", 25);
        idToUpdate = usersDataStorage.save(someone);
        User expected = new User(7, "someone", "password", "name", 20);
        usersDataStorage.update(expected);
        User actual = usersDataStorage.find(idToUpdate);
        assertEquals(expected, actual);
    }
}