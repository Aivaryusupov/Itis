package ru.itis.list;

/**
 * 20.04.2017
 * ArrayList
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ArrayList<T> implements List<T> {

    private int MAX_SIZE = 10;

    private Object elements[];

    private int count;

    public ArrayList() {
        count = 0;
        elements = new Object[MAX_SIZE];
    }

    @Override
    public void add(T element) {
        if (count < MAX_SIZE) {
            this.elements[count] = element;
            count++;
        } else throw new ArrayStoreException();
    }

    @Override
    public void delete(T element) {
        for(int i = 0; i < count; i++){
            if(elements[i] == element){
                for(int j = i + 1; j < count; j++){
                    elements[i] = elements[j];
                    i++;
                }
                count--;
                return;
            }
        }
        System.err.println("Данный элемент отсутствует");
    }

    @Override
    public void removeByIndex(int index) {
        if(index < count){
            for(int i = index; i < count - 1; i++){
                elements[i] = elements[i + 1];
            }
            count--;
        } else {
            System.err.println("Данный индекс отсутствует");
        }

    }

    @Override
    public T get(int index) {
        if(index < count){
            return (T)elements[index];
        }else{
            System.err.println("Неверный индекс");
            return null;
        }
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void addToBegin(T element) {
        if(count < MAX_SIZE){
            for(int i = count; i > 0; i--){
                elements[i] = elements[i - 1];
            }
            elements[0] = element;
            count++;

        } else throw new ArrayStoreException();
    }

    @Override
    public void print(){
        for(int i = 0; i < count; i++){
            System.out.print("[ ");
            System.out.print(elements[i]);
            System.out.println(" ]");
        }
    }

    @Override
    public void addToIndex(int index, T element) {

    }
}