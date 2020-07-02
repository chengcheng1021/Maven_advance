package com.cc.test;

import com.cc.dao.ItemsDao;
import com.cc.domain.Items;
import com.cc.service.ItemsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ItemsTest {

    /**
     * dao 测试
     */
    @Test
    public void findById() {
        //获取 spring 容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中拿到所需的dao的代理对象
        ItemsDao itemsDao = ac.getBean(ItemsDao.class);
        //调用方法
        Items items = itemsDao.findById(1);
        System.out.println(items.getName());
    }

    /**
     * service 测试
     */
    @Test
    public void findById2() {
        //获取 spring 容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ItemsService itemsService = ac.getBean(ItemsService.class);
        //调用方法
        Items items = itemsService.findById(1);
        System.out.println(items.getName());
    }
}
