package com.gummybot.stackpractice;

import java.util.Scanner;

public class ClassStackOnArray {
    public int max_size;
    public int [] sar;
    public int top = -1;
    public Scanner sc = new Scanner(System.in);

    public boolean is_full(){
        return ((top+1) >= max_size);
    }

    public boolean is_empty(){
        return (top < 0);
    }

    public void push(int el){
        if(!is_full()){
            top++;
            sar[top] = el;
            return;
        }
        System.out.println("Cannot push element. Stack is full");
    }

    public void pop(){
        if(!is_empty()){
            int el = sar[top];
            top--;
            System.out.println("The element deleted is " + el);
            return;
        }
        System.out.println("Stack Empty");
    }

    public void display(){
        if(is_empty()){
            System.out.println("Stack Empty");
            return;
        }
        for (int i = top; i>=0; i--){
            System.out.println(sar[i]);
        }
    }

    public void peek(){
        if(!is_empty()){
            int el = sar[top];
            System.out.println("The top element is " + el);
            return;
        }
        System.out.println("Stack Empty");
    }

    public static void main(String[] args) {
        ClassStackOnArray obj = new ClassStackOnArray();
        System.out.println("Please enter the max size of the stack");
        Scanner sc = obj.sc;
        obj.max_size = sc.nextInt();
        obj.sar = new int[obj.max_size];
        int choice;
        boolean flag = true;
        while(flag) {
            System.out.println("Enter your choice from the following option:\n1. Push\n2. Pop\n3. Peek\n4. Display\n5. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the element to be pushed");
                    obj.push(sc.nextInt());
                }
                case 2 -> obj.pop();
                case 3 -> obj.peek();
                case 4 -> obj.display();
                case 5 -> flag = false;
                default -> System.out.println("Invalid option");
            }
        }
    }
}
