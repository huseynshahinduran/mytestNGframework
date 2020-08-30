package com.techproed.test;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("========Before Method========");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("========Before Class========");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("========Before Test========");
    }

    @Test
    public void test1(){

        System.out.println("Bu Test1 Methodudur");

    }

    @Test
    public void test2(){

        System.out.println("Bu Test2 Methodudur");

    }

    @Test
    public void test3(){

        System.out.println("Bu Test3 Methodudur");

    }

    @AfterTest
    public void afterTest(){
        System.out.println("========After Test========");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("========After Method========");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("========After Class========");
    }

}
