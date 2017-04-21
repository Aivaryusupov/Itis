package ru.itis.list;

public class LinkedList<T> implements List<T> {

    private class Node {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T element){
            this.value = element;
        }

        public void setNext(Node node){
            this.next = node;
        }

    }

    private Node head;
    private Node last;
    private int count;

    public LinkedList() {
        this.count = 0;
        this.head = null;
        this.last = null;

    }

    @Override
    public void add(T element) {
        Node newNode = new Node(element);

        if (head == null) {
            head = newNode;
            last = newNode;
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }
        count++;
    }

    @Override
    public void delete(T element) {
        Node currentElement = head;
        while(currentElement != null){
            if(currentElement.getValue().equals(element)){
                while(currentElement != null){
                    currentElement.setValue(currentElement.getValue());
                    currentElement = currentElement.getNext();
                }
                count--;
                return;
            }
            currentElement = currentElement.getNext();
        }
    }

    @Override
    public void removeByIndex(int index) {
        if(index > count - 1){
            System.err.println("Нет такого индекса!");
            return;
        }
        if(count == 0){
            System.err.println("Нечего удалять!");
            return;
        }
        if(index == 0){
            head = head.getNext();
        }else {
            int i = 0;
            Node currentElement = head;
            while(i + 1 != index){
                i++;
                currentElement = currentElement.getNext();
            }
            Node newNext = currentElement.getNext().getNext();
            if(newNext != null) {
                currentElement.setNext(newNext);
            } else {
                currentElement.setNext(null);
                this.last = currentElement;
            }
        }
        count--;
    }

    @Override
    public T get(int index) {
        if (index < count && index >= 0) {
            Node current = this.head;
            int i = 0;

            while (i < index) {
                current = current.next;
                i++;
            }

            return current.value;
        } throw new IndexOutOfBoundsException();
    }

    @Override
    public int indexOf(T element) {
        Node current = this.head;
        int i = 0;
        while(current.getNext()!= null){
            if(current.getValue().equals(element)){
                return i;
            }
            i++;
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public void addToBegin(T element) {
        addToIndex(0,element);
    }

    @Override
    public void addToIndex(int index, T element) {
        if(index == count){
            add(element);
            return;
        } else if(index > count){
            System.err.println("Неверный индекс");
            return;
        }
        Node newNode = new Node(element);
        if(index == 0){
            Node tmp = head;
            head = newNode;
            newNode.setNext(tmp);
            count++;
            return;
        } else {
            Node currentElement = head;
            int i = 0;
            while(i < index - 1){
                i++;
                currentElement = currentElement.getNext();
            }

            Node tmp = currentElement.getNext();
            currentElement.setNext(newNode);
            currentElement = currentElement.getNext();
            currentElement.setNext(tmp);
        }
        count++;

    }

    @Override
    public void print() {
        Node currentElement = head;
        while(currentElement != null){
            System.out.println(currentElement.getValue());
            currentElement = currentElement.getNext();
        }
    }
}
