package org.example;

public class Main {
    public static void main(String[] args) {
        LinkedList<Human> linkedIterable = new LinkedList<>();
        Human h1 = new Human("Петр", "Степанов", 19);
        Human h2 = new Human("Артем", "Владимиров", 21);
        Human h3 = new Human("Виктор", "Иванченко", 24);
        Human h4 = new Human("Максим", "Марков", 35);
        linkedIterable.add(h1);
        linkedIterable.add(h2);
        linkedIterable.add(h3);
        linkedIterable.add(h4);

        for (Human item : linkedIterable) {
            System.out.println(item);
        }
    }
}