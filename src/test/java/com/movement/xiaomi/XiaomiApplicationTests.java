package com.movement.xiaomi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@SpringBootTest
class XiaomiApplicationTests {

    @Test
    void contextLoads() {
        Map<String,String> map = new HashMap<>();
        map.put("1","1111");
        map.put("2","2222");
        System.out.println(map.toString());
        map.remove(1);
        System.out.println(map.toString());
    }

}
