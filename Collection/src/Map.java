// Map 컬렉션 클래스용 (HashMap, HashTable, TreeMap, LinkedHashMap)
// key-value 방식
// 요소의 저장 순서를 유지하지 않음
// 키는 중복을 허용하지 않지만, 값의 중복은 허용

import java.util.*;

public class Map {

    // HashMap
    /*
       해시 알고리즘 사용하여 검색 속도 빠름
     */
    public void hashMapExample() {
        System.out.println("\n--HashMap--");

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        // put()
        hashMap.put("three", 3);
        hashMap.put("one", 1);
        hashMap.put("five", 5);
        hashMap.put("two", 2);

        // keySet() : 모든 키 값들을 하나의 set으로 반환
        System.out.println("keys : " + hashMap.keySet());

        // get()
        for(String key : hashMap.keySet()) {
            System.out.print(String.format("{%s, %d}", key, hashMap.get(key)));
        }
        System.out.println();

        // remove()
        hashMap.remove("one");

        // iterator()
        Iterator<String> keys = hashMap.keySet().iterator();
        while(keys.hasNext()) {
            String key = keys.next();
            System.out.print(String.format("{%s, %d}", key, hashMap.get(key)));
        }
        System.out.println();

        // replace
        hashMap.replace("five", 50);

        for(String key : hashMap.keySet()) {
            System.out.print(String.format("{%s, %d}", key, hashMap.get(key)));
        }
        System.out.println();

        // size()
        System.out.println("size : " + hashMap.size());
    }

    // TreeMap
    /*
        key, value를 한 쌍으로 하는 데이터를 binary search tree 형태로 저장
        key 정렬
     */
    public void treeMapExample() {
        System.out.println("\n--TreeMap--");

        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();

        // put()
        treeMap.put(3, "three");
        treeMap.put(1, "one");
        treeMap.put(2, "two");
        treeMap.put(5, "five");

        // keySet()
        System.out.println("keys : " + treeMap.keySet());

        // get()
        for(int key : treeMap.keySet()) {
            System.out.print(String.format("{%d, %s}", key, treeMap.get(key)));
        }
        System.out.println();

        // remove()
        treeMap.remove(3);

        // iterator()
        Iterator<Integer> keys = treeMap.keySet().iterator();
        while(keys.hasNext()) {
            int key = keys.next();
            System.out.print(String.format("{%d, %s}", key, treeMap.get(key)));
        }
        System.out.println();

        // replace()
        treeMap.replace(2, "twenty");

        for(int key : treeMap.keySet()) {
            System.out.print(String.format("{%d, %s}", key, treeMap.get(key)));
        }
        System.out.println();

        // size()
        System.out.println("size : " + treeMap.size());
    }

    // LinkedHashMap
    /*
        입력된 순서대로 유지
     */
    public void linkedHashMapExample() {
        System.out.println("\n--LinkedHashMap--");

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();

        linkedHashMap.put("five", 5);
        linkedHashMap.put("two", 2);
        linkedHashMap.put("three", 3);

        for(String key : linkedHashMap.keySet()) {
            System.out.print(String.format("{%s, %d}", key, linkedHashMap.get(key)));
        }
        System.out.println();
    }

}
