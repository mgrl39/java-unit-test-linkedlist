package ex1;

import org.junit.jupiter.api.Assertions;

class LinkedListTest {
    @org.junit.jupiter.api.Test
    void instantiate() {
        Object variable = 23;

        LinkedList l = new LinkedList(variable);

        /**
         * Esto funciona por la implementacion personalizada del
         * toString. Si lo usas default el profe tiene un throw que hace que pete.
         */
        System.out.println(l);
        /**
         * getSize es un metodo de la clase LinkedList, este te devuelve un INT
         */
        Assertions.assertEquals(1, l.getSize());
        /**
         * Find es un metodo de la clase LinkedList, este te devuelve el nodo que toque
         * Entonces ahi usas el getData del Node.
         */
        Assertions.assertEquals(variable, l.find(0).getData());
    }

    @org.junit.jupiter.api.Test
    void addAtHead() {
        //First insert (creation)
        LinkedList l = new LinkedList("Node 1");
        System.out.println("Antes del addAtHead: "  + l);
        l.printList();

        l.addAtHead("Node 0");
        System.out.println("Despues del addAtHead: "  + l);
        l.printList();

        Assertions.assertEquals(2, l.getSize());
        Assertions.assertEquals("Node 0", l.find(0).getData());
        Assertions.assertEquals("Node 1", l.find(1).getData());
    }

    @org.junit.jupiter.api.Test
    void addAtTail() {
        //First insert (creation)
        LinkedList l = new LinkedList("Node 0");
        l.printList();

        l.addAtTail("Node 1");
        l.printList();
        Assertions.assertEquals(2, l.getSize());
        Assertions.assertEquals("Node 0", l.find(0).getData());
        Assertions.assertEquals("Node 1", l.find(1).getData());
    }

    @org.junit.jupiter.api.Test
    void addAtIndex() {
        //First insert (creation)
        LinkedList l = new LinkedList("Node 1");

        //Insert at first
        l.addAtIndex(0, "Node 0");
        Assertions.assertEquals(2, l.getSize());
        Assertions.assertEquals("Node 0", l.find(0).getData());
        Assertions.assertEquals("Node 1", l.find(1).getData());
        l.printList();

        //Insert at last
        l.addAtIndex(l.getSize(), "Node 3");
        Assertions.assertEquals(3, l.getSize());
        Assertions.assertEquals("Node 0", l.find(0).getData());
        Assertions.assertEquals("Node 1", l.find(1).getData());
        Assertions.assertEquals("Node 3", l.find(2).getData());
        l.printList();

        //Insert in the middle
        l.addAtIndex(2, "Node 2");
        Assertions.assertEquals(4, l.getSize());
        Assertions.assertEquals("Node 0", l.find(0).getData());
        Assertions.assertEquals("Node 1", l.find(1).getData());
        Assertions.assertEquals("Node 2", l.find(2).getData());
        Assertions.assertEquals("Node 3", l.find(3).getData());
        l.printList();

        //Insert at < first
        l.addAtIndex(-99, "Node -99");
        Assertions.assertEquals(5, l.getSize());
        Assertions.assertEquals("Node -99", l.find(0).getData());
        Assertions.assertEquals("Node 0", l.find(1).getData());
        Assertions.assertEquals("Node 1", l.find(2).getData());
        Assertions.assertEquals("Node 2", l.find(3).getData());
        Assertions.assertEquals("Node 3", l.find(4).getData());
        l.printList();

        //Insert at > last
        l.addAtIndex(99, "Node 99");
        Assertions.assertEquals(6, l.getSize());
        Assertions.assertEquals("Node -99", l.find(0).getData());
        Assertions.assertEquals("Node 0", l.find(1).getData());
        Assertions.assertEquals("Node 1", l.find(2).getData());
        Assertions.assertEquals("Node 2", l.find(3).getData());
        Assertions.assertEquals("Node 3", l.find(4).getData());
        Assertions.assertEquals("Node 99", l.find(5).getData());
        l.printList();
    }

    @org.junit.jupiter.api.Test
    void deleteAtIndex() {
        //Creating initial list
        LinkedList l = new LinkedList("Node 0");
        l.addAtTail("Node 1");
        l.addAtTail("Node 2");
        l.addAtTail("Node 3");
        l.addAtTail("Node 4");
        l.addAtTail("Node 5");
        Assertions.assertEquals(6, l.getSize());
        l.printList();

        //Delete the last
        l.deleteAtIndex(l.getSize() - 1);
        Assertions.assertEquals(5, l.getSize());
        Assertions.assertEquals("Node 0", l.find(0).getData());
        Assertions.assertEquals("Node 1", l.find(1).getData());
        Assertions.assertEquals("Node 2", l.find(2).getData());
        Assertions.assertEquals("Node 3", l.find(3).getData());
        Assertions.assertEquals("Node 4", l.find(4).getData());
        l.printList();

        //Delete the first
        l.deleteAtIndex(0);
        Assertions.assertEquals(4, l.getSize());
        Assertions.assertEquals("Node 1", l.find(0).getData());
        Assertions.assertEquals("Node 2", l.find(1).getData());
        Assertions.assertEquals("Node 3", l.find(2).getData());
        Assertions.assertEquals("Node 4", l.find(3).getData());
        l.printList();

        //Delete from the middle
        l.deleteAtIndex(2);
        Assertions.assertEquals(3, l.getSize());
        Assertions.assertEquals("Node 1", l.find(0).getData());
        Assertions.assertEquals("Node 2", l.find(1).getData());
        Assertions.assertEquals("Node 4", l.find(2).getData());
        l.printList();

        //Delete > last
        l.deleteAtIndex(99);
        Assertions.assertEquals(2, l.getSize());
        Assertions.assertEquals("Node 1", l.find(0).getData());
        Assertions.assertEquals("Node 2", l.find(1).getData());
        l.printList();

        //Delete < first
        l.deleteAtIndex(-99);
        Assertions.assertEquals(1, l.getSize());
        Assertions.assertEquals("Node 2", l.find(0).getData());
        l.printList();
    }

    @org.junit.jupiter.api.Test
    void _toString() {
        LinkedList l = new LinkedList("Node 1");
        Assertions.assertEquals("Node 1", l.toString());
        System.out.println(l);

        l.addAtTail("Node 2");
        Assertions.assertEquals("Node 1 => Node 2", l.toString());
        System.out.println(l);

        l.addAtTail("Node 3");
        Assertions.assertEquals("Node 1 => Node 2 => Node 3", l.toString());
        System.out.println(l);

        l.addAtTail("Node 4");
        Assertions.assertEquals("Node 1 => Node 2 => Node 3 => Node 4", l.toString());
        System.out.println(l);
    }

}