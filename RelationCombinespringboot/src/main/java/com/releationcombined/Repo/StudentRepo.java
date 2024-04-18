package com.releationcombined.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.releationcombined.entity.Student;

public interface StudentRepo extends JpaRepository<Student,Integer> {

}
