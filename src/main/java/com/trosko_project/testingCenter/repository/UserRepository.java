package com.trosko_project.testingCenter.repository;

import com.trosko_project.testingCenter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
}
