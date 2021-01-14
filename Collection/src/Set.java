// Set 컬렉션 클래스 (HashSet, TreeSet, LinkedHashSet)
// 요소의 저장 순서를 유지하지 않음
// 같은 요소의 중복 저장을 허용하지 않음

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Set {

    // HashSet
    /*
        해시 알고리즘 사용하여 검색 속도 매우 빠름
        요소를 순서에 상관없이 저장하고 중복된 값 저장하지 않음
        요소의 저장순서 유지해야 한다면 LinkedHashSet 클래스 사용
     */
    public void hashSetExample() {
        System.out.println("\n--HashSet--");

        HashSet<String> hs1 = new HashSet<String>();
        HashSet<String> hs2 = new HashSet<String>();

        // add()
        hs1.add("example1");
        hs1.add("example2");
        System.out.println(hs1.add("example3"));
        System.out.println(hs1.add("example3")); // 중복, false

        // get()
        for(String e : hs1) {
            System.out.print(e + " ");
        }
        System.out.println();

        // add()
        hs2.add("example1");
        hs2.add("example2");
        hs2.add("example3");

        // iterator()
        Iterator<String> it = hs2.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // size()
        System.out.println("size : " + hs2.size());

        // clear()
        hs2.clear();

        System.out.println("size : " + hs2.size());
    }

    // TreeSet
    /*
        데이터가 정렬된 상태로 저장되는 binary search tree의 형태로 요소 저장
        binary search tree는 검색 정렬 등 빠름
        요소를 순서에 상관없이 저장하고 중복된 값은 저장하지 않음
     */
    public void treeSetExample() {
        System.out.println("\n--TreeSet--");

        TreeSet<Integer> treeSet = new TreeSet<Integer>();

        // add()
        treeSet.add(30);
        treeSet.add(40);
        treeSet.add(20);
        treeSet.add(10);

        // get()
        for(int e : treeSet) {
            System.out.print(e + " ");
        }
        System.out.println();

        // remove()
        treeSet.remove(30);

        treeSet.add(15);

        // iterator()
        Iterator<Integer> it = treeSet.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // size()
        System.out.println("size : " + treeSet.size());

        // subset()
        System.out.println(treeSet.subSet(10, 20)); // 10부터 20직전까지의 요소
        System.out.println(treeSet.subSet(10, true, 20, true));
        // 10포함, 20포함 사이의 요소

        // clear()
        treeSet.clear();

        System.out.println("size: " + treeSet.size());
    }

    // LinkedHashSet
    /*
        입력된 순서대로 데이터 관리
     */
    public void linkedHashSetExample() {
        System.out.println("\n--LinkedHashSet--");

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();

        linkedHashSet.add("1");
        linkedHashSet.add("two");
        linkedHashSet.add("3");
        linkedHashSet.add("4");
        linkedHashSet.add("five");

        Iterator<String> it = linkedHashSet.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

    }
}
