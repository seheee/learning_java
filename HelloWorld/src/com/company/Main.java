package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("HelloWorld");

        int nVar = 10;
        float fVar = 3.14f;
        System.out.println("정수: " + nVar + ", 실수: " + fVar);

        System.out.println("3: " + (int)'3' + ", A: " + (int)'A'); // unicode

        for(int i=0; i<3; i++) {
            System.out.println(i);
        }
        int i = 0;
        while(i < 3){
            System.out.println((i));
            i++;
        }
        do{
            System.out.println("HelloWorld");
        }while(false);

    }
}
