package com.trosko_project.testingCenter.repository;
import com.trosko_project.testingCenter.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer>{
}
