package com.yojana.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yojana.entities.Task;

public interface TaskRepository extends JpaRepository<Task,Integer>{
    @Query(nativeQuery = true,value = "{call GetTaskInfo(:project_id)}")  // call store procedure 
    List<Task> getInfo(@Param("project_id")Integer project_id);
    
    
    @Query(nativeQuery = true,value = "{call Delete_Task(:task_id)}")  // call store procedure 
    void getTasks(@Param("task_id")Integer task_id);
 
}
