package com.huang;

import com.huang.pojo.Dog;
import com.huang.pojo.Person;
import com.huang.pojo.Person2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ConfigApplicationTests {

    @Autowired
    private Dog dog;
    @Autowired
    private Person person;
    @Autowired
    private Person2 person2;

    @Test
    void contextLoads() {

        System.out.println(dog);
        System.out.println(person);
        System.out.println(person2);
    }

}
