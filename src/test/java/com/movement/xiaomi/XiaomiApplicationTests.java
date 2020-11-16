package com.movement.xiaomi;

import org.apache.http.client.utils.URIBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@SpringBootTest
class XiaomiApplicationTests {

    @Test
    void contextLoads() throws UnsupportedEncodingException {
        //加密
        String base64 = Base64.getEncoder().encodeToString("123456".getBytes("UTF-8"));
        System.out.println("加密后的字符串为:" + base64);

        //解码解密
        String decoderStr = new String(Base64.getDecoder().decode(base64), StandardCharsets.UTF_8);
        // 推荐使用StandardCharsets类指定
        System.out.println("解密后的字符串为" + decoderStr);

    }

}
