package com.briup.test;

import com.briup.bean.SpringConfig;
import com.briup.bean.Teacher;
import com.briup.dao.DaoConfig;
import com.briup.dao.ITeacherDao;
import com.briup.service.impl.ITeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =DaoConfig.class)
public class MybatisTeacherTest {
    @Autowired
    private ITeacherService teacherService;

    @Test
    public void test_inset(){
        //id以配置为使用序列自动生成
        Teacher t = new Teacher();
        t.setName("tom");
        t.setAge(20);
        t.setSalary(2000);
        teacherService.save(t);
    }
}
