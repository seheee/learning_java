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


        /* array */
        int[] nArray;
        nArray = new int[5];
        for(i=0; i<5; i++) {
            nArray[i] = i + 1;
            System.out.printf("%1$d ", nArray[i]);
        }
        System.out.println();

        for(i=0; i<nArray.length; i++) {
            System.out.printf("%1$d ", nArray[i]);
        }
        System.out.println();
        // default : int(0), char(null), float(0.0), boolean(false)

        int[] arr = {1, 2, 3}; // 객체 생성됨
        for(i=0; i<arr.length; i++) {
            System.out.printf("%1$d ", arr[i]);
        }
        System.out.println();

        int var = 1;
        int[][] arr2;
        arr2 = new int[3][];
        arr2[0] = new int[2];
        arr2[1] = new int[3];
        arr2[2] = new int[4];

        for(i=0; i<arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = var++;
                System.out.print(arr2[i][j]+" ");
            }
            System.out.println();
        }

        int[][] nArray1 = {{1, 2}, {3, 4}};
        int[][] nArray2 = {{1, 2}, {3, 4, 5, 6}};
        for(i=0; i<nArray2.length; i++) {
            for (int j = 0; j < nArray2[i].length; j++) {
                System.out.print(nArray2[i][j]+" ");
            }
            System.out.println();
        }

    }
}
