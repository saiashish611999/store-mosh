package com.ashcode.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashcode.store.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Byte> {

}
