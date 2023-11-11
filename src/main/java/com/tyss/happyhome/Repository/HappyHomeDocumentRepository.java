package com.tyss.happyhome.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.happyhome.entity.Document;

public interface HappyHomeDocumentRepository extends JpaRepository<Document, Integer>{

}
