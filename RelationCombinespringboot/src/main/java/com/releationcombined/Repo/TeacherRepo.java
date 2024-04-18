package com.releationcombined.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.releationcombined.entity.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher,Integer> {

}
