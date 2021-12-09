package com.company;

import org.w3c.dom.Node;

import java.util.Iterator;

public class LinkedListTalent<T> implements Iterable{
    private static class Node<T>
    {
        T value;
        Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
            this.next=null;
        }
    }
    Node first,last;
    class ListIterator implements Iterator
    {
        @Override
        public boolean hasNext() {
            return first.next!=null;
        }

        @Override
        public Object next() {
            return first.next;
        }
    }
    public void addFirst(T data)
    {
        if(first==null)
            first=new Node(data);
        else
        {
            Node nouNod=new Node(data,first);
            first=nouNod;
        }
    }
    public void add(T data)
    {
        Node update=new Node(data);
        if(last==null || last==first)
        {
            if(first==null)
            {
                first=new Node(data);
                last=first;
                return;
            }
            last.next=update;
            last=update;
            return;
        }
        Node node=new Node(data);
        last.next=node;
        last=node;
    }
    public T getNode()
    {
        return (T)first.value;
    }
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }
}
