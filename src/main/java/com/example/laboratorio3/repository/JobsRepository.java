package com.example.laboratorio3.repository;

import com.example.laboratorio3.entity.Departaments;
import com.example.laboratorio3.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, String> {
}

