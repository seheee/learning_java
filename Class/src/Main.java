import myPackage.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Book test1 = new Book();
        test1.printAll();

        Book test2 = new Book("test2", 100, "??", 1000);
        test2.printAll();

        Test1 test11 = new Test1();
        Test2 test22 = new Test2();
        test11.printTest1();
        test22.printTest2();
        Test3 test33 = new Test3();
        test33.printTest1();
        Test3 test55 = new Test3(5);
        System.out.println(test55.test);

        System.out.println();
        Test1 test44 = new Test3();
        test44.printTest1();
        Test3 test66 = new Test3();
        Test1 test77 = (Test1)test66;
        test77.printTest1();
    }
}

class Book {
    private String title;
    private int page;
    private String publisher;
    private int price;

    public Book() {
        title = "none";
        page = 0;
        publisher = "none";
        price = 0;
    }

    public Book(String title, int page, String publisher, int price) {
        this.title = title;
        this.page = page;
        this.publisher = publisher;
        this.price = price;
    }

    public void SetTitle(String title) {
        this.title = title;
    }
    public String GetTitle() {
        return title;
    }
    public void SetPage(int page) {
        this.page = page;
    }
    public int GetPage() {
        return page;
    }
    public void SetPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String GetPublisher() {
        return publisher;
    }
    public void SetPrice(int price) {
        this.price = price;
    }
    public int GetPrice() {
        return price;
    }

    public void printAll() {
        System.out.println(title + ", " + page + ", " + publisher + ", " + price);
    }


}
