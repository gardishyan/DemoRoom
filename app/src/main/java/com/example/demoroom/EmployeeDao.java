package com.example.demoroom;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface EmployeeDao {
    @Query("SELECT * FROM employees")
    List<EmployeeEntity> getAll();

    @Insert
    long insertEmployee(EmployeeEntity employeeEntity);

    @Query("DELETE FROM employees WHERE salary > :top")
    void deleteEmployee(Integer top);
}