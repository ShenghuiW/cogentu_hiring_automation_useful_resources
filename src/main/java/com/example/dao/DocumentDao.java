package com.example.dao;

import com.example.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentDao extends JpaRepository<Document,Integer> {
}
