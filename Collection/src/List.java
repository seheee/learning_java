import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

// List 컬렉션 클래스 (ArrayList, LinkedList, Vector, Stack)
// 요소의 저장 순서가 유지됨
// 같은 요소의 중복 저장을 허용

public class List {

    // ArrayList
    /*
        내부적으로 배열을 이용하여 요소 저장
        -> 인덱스를 이용해 배열 요소에 빠르게 접근할 수 있음.
        -> 배열 크기를 늘리는 과정은 자동으로 수행되지만, 이를 위한 시간이 길다는 단점 존재
     */
    public void arrayListExample() {
        System.out.println("\n--ArrayList--");

        ArrayList<Integer> arrList = new ArrayList<Integer>();

        // add() : 요소 저장
        arrList.add(40);
        arrList.add(20);
        arrList.add(30);
        arrList.add(10);

        // get()
        for(int i=0; i<arrList.size(); i++) {
            System.out.print(arrList.get(i) + " ");
        }
        System.out.println();

        // remove() : 요소 제거
        arrList.remove(1);

        for(int e : arrList) {
            System.out.print(e + " ");
        }
        System.out.println();

        // Collections.sort() : 요소 정렬
        Collections.sort(arrList);

        // iterator()
        Iterator<Integer> it = arrList.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // set() : 요소 변경
        arrList.set(0, 20);

        for(int e : arrList) {
            System.out.print(e +" ");
        }
        System.out.println();

        // add()
        arrList.add(1, 50);

        for(int e : arrList) {
            System.out.print(e +" ");
        }
        System.out.println();

        // size() : 요소 총 개수
        System.out.println("size : " + arrList.size());

        // clear()
        arrList.clear();
        System.out.println("size : " + arrList.size());
    }

    // LinkedList
    /*
        ArrayList 클래스가 배열을 이용하여 요소를 저장함으로써 발생하는 단점 극복하기 위해 고안
        내부적으로 이중 연결리스트를 이용하여 요소 저장함
        List 인터페이스를 구현하므로 ArrayList 클래스와 사용할 수 있는 메소드가 거의 같음
     */
    public void linkedListExample() {
        System.out.println("\n--LinkedList--");

        LinkedList<String> linkList = new LinkedList<String>();

        // add()
        linkList.add("one");
        linkList.add("two");
        linkList.add("three");
        linkList.add("four");

        // get()
        for(int i=0; i<linkList.size(); i++) {
            System.out.print(linkList.get(i) + " ");
        }
        System.out.println();

        // remove()
        linkList.remove(1);

        for(String e : linkList) {
            System.out.print(e + " ");
        }
        System.out.println();

        // set()
        linkList.set(2, "two");

        for(String e : linkList) {
            System.out.print(e + " ");
        }
        System.out.println();

        // add()
        linkList.add(1, "one");
        for(String e : linkList) {
            System.out.print(e + " ");
        }
        System.out.println();

        // size()
        System.out.println("size : " + linkList.size());

        // clear()
        linkList.clear();
        System.out.println("size : " + linkList.size());


    }

}
