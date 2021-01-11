package myPackage;

interface Interface1 {
    int var = 7;
    void Print();
}

interface Interface2 {
    void Print2();
}

interface Interface3 extends Interface1, Interface2 {
    void Print3();
}