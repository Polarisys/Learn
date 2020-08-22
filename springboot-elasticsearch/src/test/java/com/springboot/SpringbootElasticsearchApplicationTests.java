package com.springboot;

import com.springboot.bean.Book;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class SpringbootElasticsearchApplicationTests {

    @Autowired
    JestClient jestClient;



    @Test
    void contextLoads() {
        Book book = new Book();
        book.setId(1);
        book.setAuthor("wangWu");
        book.setTitle("好消息");
        book.setContent("hello world");

        //构建一个索引功能
        Index index = new Index.Builder(book).index("atguigu").type("news").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
