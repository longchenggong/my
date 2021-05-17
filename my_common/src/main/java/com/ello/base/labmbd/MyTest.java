package com.ello.base.labmbd;

import com.ello.base.labmbd.service.LamTest;
import com.ello.base.labmbd.service.OrderService;
import com.ello.entity.User;
import org.junit.Test;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyTest {
    public static String getStaticStr(String str){
        return str;
    }
    private String getStr(String str){
        return str;
    }

    public Integer getInteger(Integer integer){
        return integer;
    }
    public static void main(String[] args) {
        ((OrderService) () -> System.out.println("get")).get();

        new Thread(() -> System.out.println(Thread.currentThread().getName())).run();
    }
    @org.junit.Test
    public void lamTest(){
        Integer add = ((LamTest) (a, b) -> a + b).add(1, 3);
        System.out.println(add);
    }

    @Test
    public void testList(){
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bvbb");
        list.add("ccc");
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
    @Test
    public void userTest(){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("x",11));
        users.add(new User("aa",1));
        users.add(new User("ee",31));
        users.add(new User("dd",81));
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge()- o2.getAge();
            }
        });
        users.forEach(user -> System.out.println(user.toString()));

        Map<String, User> userMap = users.stream().collect(Collectors.toMap(user -> user.getName(), user -> user));
        userMap.forEach((k,v)-> System.out.println(k+" "+v));
    }
    @Test
    public void reduce(){
        Stream<Integer> stream = Stream.of(11, 12, 11);
        Integer integer = stream.reduce((integer1, integer2) -> integer1 + integer2).get();
        System.out.println(integer);


        ArrayList<User> users = new ArrayList<>();
        users.add(new User("x",11));
        users.add(new User("aa",1));
        users.add(new User("ee",31));
        users.add(new User("dd",81));
        Stream<User> stream1 = users.stream();
        System.out.println("--------");
//        Optional<User> sum = stream1.reduce(new BinaryOperator<User>() {
//            @Override
//            public User apply(User user, User user2) {
//                return new User("sum", user.getAge() + user2.getAge());
//            }
//        });
//        System.out.println(sum);

        boolean b = stream1.anyMatch(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return "aa".equals(user.getName());
            }
        });
        System.out.println(b);

    }
    @Test
    public void 对象引入(){
        Function<String, String> getStaticStr = MyTest::getStaticStr;
        System.out.println(getStaticStr("my。。。。"));
        System.out.println(getStaticStr.apply("applymy"));

        BiFunction<MyTest, String, String> getStr = MyTest::getStr;
        System.out.println(getStr("sdfsdf"));
    }

    public List<User> fileUserList(List<User> userList,Predicate<User> predicate){
        List<User> list=new ArrayList<>();
        userList.forEach(user -> {
            if (predicate.test(user))
                list.add(user);
        });
        return list;
    }
}
