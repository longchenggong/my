package com.ello.base;

import com.ello.entity.Cat;
import com.ello.entity.Pet;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/3/2916:02
 */
public class LambdaTest {
        @Test
        public void Test() {
                Cat cat01 = new Cat("cat01", 11);
                Cat cat02 = new Cat("cat02", 11);
                Cat cat03 = new Cat("cat03", 11);
                Cat cat04 = new Cat("cat04", 11);

                Pet pet01 = new Pet("pet01", 12);
                Pet pet02 = new Pet("pet02", 12);
                Pet pet03 = new Pet("pet03", 12);
                Pet pet04 = new Pet("pet04", 12);
                Pet pet05 = new Pet("pet06", 112);

                List<Pet> pets = Arrays.asList(pet01, pet02, pet03, pet04, pet05);

                List<Cat> cats = Arrays.asList(cat01, cat02, cat03, cat04);

                List<String> collect = pets.stream().map(Pet::getName).distinct().collect(Collectors.toList());
                String s = pets.stream().map(Pet::getName).distinct().collect(Collectors.joining("$"));
                System.out.println("joining:" + s);


                Map<String, Integer> result = pets.stream().collect(toMap(x -> x.getName(), item -> item.getWeight(), (a, b) -> b));

                System.out.println(result);

                cats.stream().forEach(x -> {
                        collect.add(x.getName());
                });

                cats.stream().forEach(Cat::printName);
                System.out.println(collect);
        }
        @Test
        public void testMap(){
                List<String> givenList = Arrays.asList("a", "bb", "c", "d", "bb");



        }
}
