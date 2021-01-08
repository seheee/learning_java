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


        int nVar2 = 12;
        if(nVar2 < 20) {
            System.out.println("a");
        } else {
            System.out.println("b");
        }

        int nVar3 = 1;
        char cVar = 4; // unicode
        switch(cVar) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            default:
                System.out.println("none");
                break;
        }

        for(i=0; i<5; i++) {
            if(i == 3)
                continue;
            System.out.println(i);
        }

        // break + label
        i = 0;
        OUT: while(true) {
            while(true) {
              i++;
              if(i == 3) {
                  System.out.println(i);
                  break OUT;
              } else {
                  System.out.println(i);
              }
            }
        }
        System.out.println("end");
    }
}
