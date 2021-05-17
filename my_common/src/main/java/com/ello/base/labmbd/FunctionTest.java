package com.ello.base.labmbd;

import com.ello.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Stream;

public class FunctionTest {
    @Test
    public void 方法引入() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("x",11));
        users.add(new User("aa",1));
        users.add(new User("aa",221));
        users.add(new User("ee",31));
        users.add(new User("dd",81));
        Stream<User> stream1 = users.stream();
        BiFunction<String, Integer, Integer> stringIntegerIntegerBiFunction = Integer::parseInt;


        Function<String, Integer> str2Int = Integer::parseInt;

        System.out.println("str2Int:" +str2Int.apply("4")+"type:"+str2Int.apply("4").getClass());
        MyTest myTest=new MyTest();
        Function<Integer, Integer> getInteger = myTest::getInteger;
        System.out.println("getInteger:"+ getInteger.apply(123123));

        Function<String, Integer> function = String::length;

        List<User> list = new MyTest().fileUserList(users, user -> "aa".equals(user.getName()));
        list.forEach(System.out::println);

        BiFunction<String, Object, Boolean> stringObjectBooleanBiFunction = String::equals;
        BiPredicate<String, Object> stringObjectBooleanBiFunction1 = String::equals;
        Boolean apply = stringObjectBooleanBiFunction.apply("a", "a");
        System.out.println(apply);
    }
    @Test
    public void 规(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = integers.stream().reduce(100,new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        });


        Optional<Integer> reduce1 = integers.stream().reduce(Integer::sum);
        System.out.println(reduce+" "+reduce1);


    }
}
