package com.example.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.entity.FileEntity;

public interface FileRepo  extends JpaRepository<FileEntity, Long>{
	
	   FileEntity findAllByFileName(String fileName);

}
