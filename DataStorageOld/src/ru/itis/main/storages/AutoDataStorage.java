package ru.itis.main.storages;

import ru.itis.main.generators.IdGenerator;
import ru.itis.main.generators.SingletonIdGenerator;
import ru.itis.main.models.Auto;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AutoDataStorage {

    private String fileName;

    public AutoDataStorage(String fileName) {
        this.fileName = fileName;
    }

    public int save(Auto auto) {
        try {
            auto.setId(SingletonIdGenerator.getGenerator().generateId());
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            String autoDataAsString = auto.toString();
            writer.write(autoDataAsString);
            writer.newLine();
            writer.close();
            return auto.getId();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }

        return -1;
    }

    public Auto find(int id) {
        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));

            String currentAutoData = reader.readLine();

            while (currentAutoData != null) {
                String currentAutoDataAsArray[] =
                        currentAutoData.split(" ");

                int currentUserId =
                        Integer.parseInt(currentAutoDataAsArray[0]);

                if (currentUserId == id) {
                    Auto founded = new Auto(
                            currentAutoDataAsArray[1],
                            currentAutoDataAsArray[2],
                            Integer.parseInt(currentAutoDataAsArray[3]));
                    founded.setId(id);
                    reader.close();
                    return founded;
                }
                currentAutoData = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
        return null;
    }

    public List<Auto> findAll() {
        ArrayList<Auto> allAutos = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String currentAutoData = reader.readLine();

            while (currentAutoData != null) {
                String currentAutoDataAsArray[] = currentAutoData.split(" ");
                Auto fromFile = new Auto(currentAutoDataAsArray[1],
                        currentAutoDataAsArray[2],
                        Integer.parseInt(currentAutoDataAsArray[3]));
                fromFile.setId(Integer.parseInt(currentAutoDataAsArray[0]));
                allAutos.add(fromFile);
                currentAutoData = reader.readLine();
            }
            reader.close();
            return allAutos;
        }
        catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
        return null;
    }

    public void delete(int id) {
        List<Auto> buffer = findAll();
        int indexOfDeleted = -1;
        for (int i = 0; i < buffer.size(); i++) {
            Auto currentAuto = buffer.get(i);
            if (currentAuto.getId() == id) {
                indexOfDeleted = i;
                break;
            }
        }
        if (indexOfDeleted > -1) {
            buffer.remove(indexOfDeleted);
        }

        flushFromBuffer(buffer);
    }

    public void update(Auto auto) {
        int idToUpdate = auto.getId();
        List<Auto> updateList = findAll();
        for (int i = 0; i < updateList.size(); i++){
            if ((updateList.get(i)).getId() == idToUpdate){
                updateList.set(i, auto);
                break;
            }
        }
        flushFromBuffer(updateList);
    }
    private void flushFromBuffer(List<Auto> buffer) {
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
