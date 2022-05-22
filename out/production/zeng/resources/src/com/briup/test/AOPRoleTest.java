package com.briup.test;

import com.briup.aop.aspect.AOPConfig;
import com.briup.aop.aspect.IRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AOPConfig.class)
public class AOPRoleTest {

    @Autowired
    private IRoleService roleService;

    @Test
    public void test(){
        System.out.println(roleService);
        System.out.println(roleService.getClass());
    }

    @Test
    public void test_print() throws Exception {
        roleService.print();
    }
}
