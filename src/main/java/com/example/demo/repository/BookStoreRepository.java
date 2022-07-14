package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BookStoreDO;

@Repository
public interface BookStoreRepository extends JpaRepository<BookStoreDO, Long>{

}
