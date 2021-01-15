// Stream
// 데이터를 추상화하여 다루므로, 다양한 방식으로 저장된 데이터를 읽고 쓰기 위한 공통된 방법 제공
// Stream API를 이용하면 배열이나 컬렉션 뿐 아니라 파일에 저장된 데이터도 모두 같은 방법으로 다룰 수 있음
// 1. 스트림은 내부 반복을 통해 작업 수행함
// 2. 스트림은 재사용이 가능한 컬렉션과는 달리 단 한 번만 사용할 수 있음
// 3. 스트림은 원본 데이터를 변경하지 않음
// 4. 스트림의 연산은 filter-map 기반의 API를 사용하여 지연 연산을 통해 성능 최적화
// 5. 스트림은 parallelStream() 메서드를 통해 손쉬운 병렬 처리 지원
// 스트림 생성 -> 스트림의 중개 연산(스트림의 변환) -> 스트림의 최종 연산(스트림의 사용)

import java.util.*;
import java.util.stream.*;

public class StreamClass {

    // 스트림 생성
    public void createStreamExample() {
        System.out.println("\n--CreateStream--");

        // Collection
        /*
            Collection 인터페이스에는 stream() 메소드가 정의되어 있음
            따라서 List와 Set 컬렉션 클래스에서도 stream() 메소드로 스트림 생성 가능
            parallelStream() 메소드를 사용하여 병렬 처리가 가능한 스트림 생성 가능
        */
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(3);

        Stream<Integer> stream = list.stream();
        stream.forEach(l -> System.out.print(l + " "));
        System.out.println();
        // Stream 클래스의 forEach()는 해당 스트림의 요소를 하나씩 소모해가며 순차적으로 요소에 접근
        // 같은 스트림으로는 forEach()를 한 번밖에 호출할 수 없음
        // 원본 데이터의 요소를 소모하는것은 아니기 때문에 다른 스트림 생성해서 하면 됨


        // Array
        /*
            배열에 관한 스트림을 생성하기 위해 Arrays 클래스에는 다양한 형태의 stream() 메소드 정의되어있음
            기본 타입인 int, long, double형을 저장할 수 있는 배열에 관한 스트림이 별도로 정의되어 있음
            (IntStream, LongStream, DoubleStream 인터페이스로 제공됨)
         */
        String[] arr = new String[] {"one", "three", "two", "five"};

        Stream<String> stream1 = Arrays.stream(arr);
        stream1.forEach(e -> System.out.print(e + " "));
        System.out.println();

        // 인덱스 1 - 2까지 스트림 생성
        Stream<String> stream2 = Arrays.stream(arr, 1, 3);
        stream2.forEach(e -> System.out.print(e + " "));
        System.out.println();


        // Variable parameter
        /*
            Stream 클래스의 of() 메소드를 사용하면 가변 매개변수 전달받아 스트림 생성
         */
        Stream<Double> stream3 = Stream.of(4.2, 2.5, 3.1, 1.9);
        stream3.forEach(e -> System.out.print(e + " "));
        System.out.println();


        // 지정된 범위의 연속된 정수
        /*
            지정된 범위의 연속된 정수를 스트림으로 생성하기 위해 IntStream, LongStream 인터페이스에는
            range() - (포함, 미포함), rangeClosed() - (포함, 포함) 메소드가 정의되어 있음
         */
        IntStream stream4 = IntStream.range(1, 4);
        stream4.forEach(e -> System.out.print(e + " "));
        System.out.println();

        IntStream stream5 = IntStream.rangeClosed(1, 4);
        stream5.forEach(e -> System.out.print(e + " "));
        System.out.println();


        // Random
        /*
            특정 타입의 난수로 이루어진 스트림을 생성하기 위해 Random클래스에는 ints(), longs(), doubles() 메소드 정의되어 있음
            이 메소드들은 매개변수로 스트림 크기 전달받음 (long)
            전달받지 않으면 크기가 정해지지 않은 무한 스트림 반환
            (이 때에는 limit()메소드를 통해 따로 스트림 크기 제한해야함)
         */
        IntStream stream6 = new Random().ints(4);
        stream6.forEach(e -> System.out.print(e + " "));
        System.out.println();


        // Lambda
        /*
            람다 표현식을 매개변수로 전달받아 해당 람다 표현식에 의해 반환되는 값을 요소로 하는 무한스트림 생성
            Stream 클래스에 iterate(), generate() 메소드 정의되어 있음
            iterate() : seed로 명시된 값을 람다 표현식에 사용하여 반환된 값을 다시 시드로 사용
            generate() : 매개변수가 없는 람다 표현식 사용하여 반환된 값으로 무한 스트림 생성
         */
        //Stream stream7 = Stream.iterate(2, n -> n + 2);


        // Empty Stream
        Stream<Object> stream7 = Stream.empty();
        System.out.println(stream7.count());
    }

    // 스트림 중개 연산
    /*
        생성된 초기 스트림은 중개 연산을 통해 또 다른 스트림으로 변환
        중개 연산은 연속으로 연결해서 사용할 수 있음
        filter-map 기반의 API 사용해서 지연 연산을 통해 성능 최적화 가능

        1. 스트림 필터링 : filter(), distinct()
        2. 스트림 변환 : map(), flatMap()
        3. 스트림 제한 : limit(), skip()
        4. 스트림 정렬 : sorted()
        5. 스트림 연산 결과 확인 : peek()
     */
    public void intermediateOperationExample() {
        System.out.println("\n--Intermediate Operation--");

        // 스트림 필터링
        /*
            filter() : 주어진 조건에 맞는 요소만으로 구성된 새로운 스트림 반환
            distinct() : 중복된 요소가 제거된 새로운 스트림 반환
         */
        IntStream stream1 = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        IntStream stream2 = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);

        stream1.distinct().forEach(e -> System.out.print(e + " "));
        System.out.println();

        stream2.filter(n -> n % 2 != 0).forEach(e -> System.out.print(e + " "));
        System.out.println();

        // 스트림 변환
        /*
            map() : 해당 스트림의 요소들을 주어진 함수에 인수로 전달하여 그 반환값들로 이루어진 새로운 스트림 반환
            flatMap() : 해당 스트림의 요소가 배열일때 각 배열의 각 요소의 반환값을 하나로 합친 새로운 스트림 얻을 수 있음
         */
        Stream<String> stream3 = Stream.of("abcde", "abc", "ab", "abcdef");
        stream3.map(s -> s.length()).forEach(e -> System.out.print(e + " "));
        System.out.println();

        String[] arr = {"I study hard", "You study JAVA", "I am hungry"};
        Stream<String> stream4 = Arrays.stream(arr);
        stream4.flatMap(s -> Stream.of(s.split(" +"))).forEach(e-> System.out.print(e + ", "));
        System.out.println();

        // 스트림 제한
        /*
            limit() : 해당 스트림의 첫 번째 요소부터 전달된 개수만큼의 요소만으로 이루어진 새로운 스트림 반환
            skip() : 해당 스트림의 첫 번째 요소부터 전달된 개수만큼의 요소를 제외한 나머지 요소만으로 이루어진 새로운 스트림 반환
         */
        IntStream stream5 = IntStream.range(0, 10);
        IntStream stream6 = IntStream.range(0, 10);
        IntStream stream7 = IntStream.range(0, 10);

        stream5.skip(4).forEach(e -> System.out.print(e + " "));
        System.out.println();
        stream6.limit(5).forEach(e -> System.out.print(e + " "));
        System.out.println();
        stream7.skip(3).limit(5).forEach(e -> System.out.print(e + " "));
        System.out.println();

        // 스트림 정렬
        /*
            sorted() : 해당 스트림을 주어진 comparator를 이용하여 정렬
            (전달하지 않으면 기본적으로 사전순으로 정렬)
         */
        Stream<String> stream8 = Stream.of("java", "html", "javascript", "css");
        Stream<String> stream9 = Stream.of("java", "html", "javascript", "css");

        stream8.sorted().forEach(e -> System.out.print(e + " "));
        System.out.println();
        stream9.sorted(Comparator.reverseOrder()).forEach(e -> System.out.print(e + " "));
        System.out.println();

        // 스트림 연산 결과 확인
        /*
            peek() : 결과 스트림으로부터 요소를 소모하여 추가로 명시된 동작 수행 (디버깅용)
         */
    }

    // 스트림 최종 연산
    /*
        1. 요소의 출력 : forEach()
        2. 요소의 소모 : reduce()
        3. 요소의 검색 : findFirst(), findAny()
        4. 요소의 검사 : anyMatch(), allMatch(), noneMatch()
        5. 요소의 통계 : count(), min(), max()
        6. 요소의 연산 : sum(), average()
        7. 요소의 수집 : collect()
     */
    public void terminalOperationExample() {
        System.out.println("\n--Terminal Operation--");

        // forEach()
        /*
            스트림의 각 요소를 소모하여 명시된 동작을 수행
            반환타입 void
         */
        Stream<String> stream = Stream.of("one", "two", "three", "four");
        stream.forEach(System.out::print);
        System.out.println();

        // reduce()
        /*
            첫 번째와 두 번째 요소를 가지고 연산 수행한 뒤, 그 결과와 세 번째 요소를 가지고 연산 수행 ...
            인수로 초기값 전달하면 그 값과 첫 번째 요소와 연산 ...
         */
        Stream<String> stream1 = Stream.of("one", "two", "three");
        Stream<String> stream2 = Stream.of("one", "two", "three");

        Optional<String> result1 = stream1.reduce((s1, s2) -> s1 + "++" + s2);
        result1.ifPresent(System.out::println);

        String result2 = stream2.reduce("start", (s1, s2) -> s1 + "++" + s2);
        System.out.println(result2);

        // findFirst(), findAny()
        /*
            해당 스트림에서 첫 번째 요소를 참조하는 Optional 객체를 반환
            (비어있는 스트림이면 비어있는 Optional 객체 반환)
         */
        IntStream stream3 = IntStream.of(4, 2, 7, 3, 5, 1, 6);
        IntStream stream4 = IntStream.of(4, 2, 7, 3, 5, 1, 6);

        OptionalInt result3 = stream3.sorted().findFirst();
        System.out.println(result3);

        OptionalInt result4 = stream4.sorted().findAny();
        System.out.println(result4.getAsInt());

        // 요소의 검사
        /*
            1. anyMatch() : 해당 스트림의 일부 요소가 특정 조건을 만족할 경우에 true를 반환
            2. allMatch() : 해당 스트림의 모든 요소가 특정 조건을 만족할 경우에 true를 반환
            3. noneMatch() : 해당 스트림의 모든 요소가 특정 조건을 만족하지 않을 경우에 true를 반환
         */
        IntStream stream5 = IntStream.of(30, 90, 70, 10);
        IntStream stream6 = IntStream.of(30, 90, 70, 10);

        System.out.println(stream5.anyMatch(n -> n > 80));
        System.out.println(stream6.allMatch(n -> n > 80));

        // count(), min(), max()
        IntStream stream7 = IntStream.of(30, 90, 70, 10);
        IntStream stream8 = IntStream.of(30, 90, 70, 10);

        System.out.println(stream7.count());
        System.out.println(stream8.max().getAsInt());

        // sum(), average()
        IntStream stream9 = IntStream.of(30, 90, 70, 10);
        DoubleStream stream10 = DoubleStream.of(30.3, 90.9, 70.7, 10.1);

        System.out.println(stream9.sum());
        System.out.println(stream10.average().getAsDouble());

        // collect() : 인수로 전달되는 Collectors 객체에 구현된 방법대로 스트림의 요소를 수집
        /*
            toList(), toMap(), toSet(), ...
         */

    }

}
