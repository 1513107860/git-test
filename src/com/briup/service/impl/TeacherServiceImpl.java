package com.briup.service.impl;

import com.briup.bean.Teacher;
import com.briup.dao.ITeacherDao;

public class TeacherServiceImpl implements ITeacherService {
    private ITeacherDao teacherDao;

    public void save(Teacher t) {
        teacherDao.insertTeacher(t);
// throw new RuntimeException("异常测试");
    }

    public ITeacherDao getTeacherDao() {
        return teacherDao;
    }

    public void setTeacherDao(ITeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
}
