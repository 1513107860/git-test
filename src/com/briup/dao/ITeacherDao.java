package com.briup.dao;

import com.briup.bean.Teacher;

public interface ITeacherDao {
    void insertTeacher(Teacher teacher);

    Teacher selectTeacherById(Teacher id);
}
