package com.yojana.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yojana.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query(nativeQuery = true,value = "{call Delete_Project_Tasks(:proj_id)}")  // call store procedure 
    void deleteProjectTasks(@Param("proj_id")Integer proj_id);
}