package com.example.samuraitravel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.samuraitravel.entity.House;

//JpaRepositoryを継承すると基本的なCRUD操作メソッドが利用可能になる
public interface HouseRepository extends JpaRepository<House,Integer>{
	public Page<House> findByNameLike(String keyword,Pageable pageable);//https://www.baeldung.com/spring-jpa-like-queriesに説明がある。インターフェースなので、具体的に中身は書かない。
}
