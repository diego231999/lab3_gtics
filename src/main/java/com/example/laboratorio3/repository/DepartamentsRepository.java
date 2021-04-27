package com.example.laboratorio3.repository;

import com.example.laboratorio3.entity.Departaments;
import com.example.laboratorio3.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentsRepository extends JpaRepository<Departaments, Integer> {

}
