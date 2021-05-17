package com.ello;

import org.junit.jupiter.api.*;

public class Junit5Test {
    @BeforeAll
    public static void before(){
        System.out.println("start-----------------");
    }
    @AfterAll
    public static void after(){
        System.out.println("end-------------");
    }
    @DisplayName("之前")
    @BeforeEach
    public void beforeTest(){
        System.out.println("每个执行之前");
    }

    @DisplayName("之后")
    @AfterEach
    public void afterTest(){
        System.out.println("每个执行之后");
        System.out.println("--------------------------");
    }
    @RepeatedTest(value = 3)
    @DisplayName("测试01")
    @Test
    public void test_01(){
        System.out.println("这是一个测试案例01");
    }

    @DisplayName("测试02")
    @Test
    public void test_02(){
        System.out.println("这是一个测试案例02");
    }


}
