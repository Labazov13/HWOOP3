package org.example;

import java.util.Iterator;


public class LinkedList<H> implements Iterable<H> {    //Создан класс, реализующий интерфейс Iterable
    private Node<H> head;   //Создан начальный узел "голова"
    private int size;   //Переменная, отвечающая за количество элементов в списке

    private static class Node<H> {   //Создан класс Node с полями: данные(Тип Н) и следующий узел
        H data;
        Node<H> next;

        Node(H data) {   //При создании нового узла ему будут присвоены данные, которые введет пользователь
            this.data = data;
        }
    }

    public void add(H data) {    //Метод, отвечающий за добавление элементов в список
        Node<H> newNode = new Node<>(data); //Создается новый узел с данными, переданными в этом методе
        newNode.next = head;    //Следующему узлу передается предыдущий, "головной" узел
        head = newNode;     //"Голове" передается следующий узел
        size++;
    }
    public boolean remove(H data) {     //Метод для удаления элемента из списка
        if (head == null) {     //Если головной узел == 0, то удалить объект нельзя, так как его нет
            return false;
        }
        if (head.data.equals(data)) {       //Если введенные данные соответствуют данным в списке, то объект удалится
            head = head.next;           //Головным элементом становится следующий элемент ДО удаления предыдущего
            size--;
            return true;
        }
        Node<H> current = head;
        while (current.next != null) {      //Цикл будет работать, пока есть следующий после головы элемент
            if (current.next.data.equals(data)) {       //Если введенные данные соответствуют данным в списке, то объект удалится
                current.next = current.next.next;       //Следующим элементом становится элемент, который был следующим за тем, который был удален
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public boolean contains(H data) {
        Node<H> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public int size() {
        return size;
    }
    @Override
    public Iterator<H> iterator() {
        return new LinkedListIterator<>(head);
    }
    private static class LinkedListIterator<H> implements Iterator<H> {
        Node<H> current;
        LinkedListIterator(Node<H> head) {
            current = head;
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public H next() {
            H data = current.data;
            current = current.next;
            return data;
        }
    }
}
