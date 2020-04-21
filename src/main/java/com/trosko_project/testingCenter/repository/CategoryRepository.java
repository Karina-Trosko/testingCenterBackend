package com.trosko_project.testingCenter.repository;

import com.trosko_project.testingCenter.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Integer>{
}
