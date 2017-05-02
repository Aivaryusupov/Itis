package ru.itis.main.storages;

import ru.itis.main.exceptions.UserNotFoundException;
import ru.itis.main.generators.SingletonIdGenerator;
import ru.itis.main.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDataStorage {

    // поле, в котором хранится имя файла
    // в котором содежатся данные о пользователях
    private String fileName;

    public UsersDataStorage(String fileName) {
        this.fileName = fileName;
    }

    public int save(User user) {
        try {
            // на вход принимаем можель без id
            // генерируем id
            user.setId(SingletonIdGenerator.getGenerator().generateId());
            // открываем файловый поток для дозаписи
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            // преобразуем пользователя в строку через toString
            String userDataAsString = user.toString();
            // преобразуем строку в массив байтов
            // записываем в файл
            writer.write(userDataAsString);
            writer.newLine();
            writer.close();
            return user.getId();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }

        return -1;
    }

    public User find(int id) {
        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));

            String currentUserData = reader.readLine();

            while (currentUserData != null) {
                String currentUserDataAsArray[] =
                        currentUserData.split(" ");

                int currentUserId =
                        Integer.parseInt(currentUserDataAsArray[0]);

                if (currentUserId == id) {
                    User founded = new User(
                            currentUserDataAsArray[1],
                            currentUserDataAsArray[2],
                            currentUserDataAsArray[3],
                            Integer.parseInt(currentUserDataAsArray[4]));
                    founded.setId(id);
                    reader.close();
                    return founded;
                }
                currentUserData = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
        throw new UserNotFoundException("User with id: " + id + " not found!");
    }

    public List<User> findAll() {
        ArrayList<User> allUsers = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String currentUserData = reader.readLine();

            while (currentUserData != null) {
                String currentUserDataAsArray[] = currentUserData.split(" ");
                User fromFile = new User(currentUserDataAsArray[1],
                        currentUserDataAsArray[2],
                        currentUserDataAsArray[3],
                        Integer.parseInt(currentUserDataAsArray[4]));
                fromFile.setId(Integer.parseInt(currentUserDataAsArray[0]));
                allUsers.add(fromFile);
                currentUserData = reader.readLine();
            }
            reader.close();
            return allUsers;
        }
        catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
        return null;
    }

    public void delete(int id) {
        // получили всех пользователей
        List<User> buffer = findAll();
        // индекс удаляемого пользователя в списке
        int indexOfDeleted = -1;
        // идем по всему списку
        for (int i = 0; i < buffer.size(); i++) {
            // получаем текущего i-го пользователя
            User currentUser = buffer.get(i);
            // если id просматриваемого пользователя
            // совпал с id пользователя, которого мы хотим удалить
            if (currentUser.getId() == id) {
                // запоминаем его индекс
                indexOfDeleted = i;
                // останавливаем цикл
                break;
            }
        }
        // если мы нашли пользователя, которого надо удалить
        if (indexOfDeleted > -1) {
            // удаляем
            buffer.remove(indexOfDeleted);
        }

        flushFromBuffer(buffer);
    }

    public void update(User user) {
        int idToUpdate = user.getId();
        List<User> updateList = findAll();
        for (int i=0;i<updateList.size();i++){
            if ((updateList.get(i)).getId() == idToUpdate){
                updateList.set(i,user);
                break;
            }
        }
        flushFromBuffer(updateList);
    }
    private void flushFromBuffer(List<User> buffer) {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(fileName));

            for (int i = 0; i < buffer.size(); i++) {
                writer.write(buffer.get(i).toString());
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
    }
}
