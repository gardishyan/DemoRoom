package com.example.demoroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestThread tt = new TestThread();
        tt.start();
    }

    class TestThread extends Thread {
        @Override
        public void run() {
            super.run();

            AppDatabase adb = DatabaseClient.getInstance(MainActivity.this).getAppDatabase();

            EmployeeEntity emp1 = new EmployeeEntity();
            emp1.name = "Ashot Misakyan";
            emp1.salary = 450000;
            adb.employeeDao().insertEmployee(emp1);

            EmployeeEntity emp2 = new EmployeeEntity();
            emp2.name = "Slavik Petrov";
            emp2.salary = 250000;
            adb.employeeDao().insertEmployee(emp2);

            List<EmployeeEntity> employees = adb.employeeDao().getAll();
            employees.forEach(employee -> {
                Log.i("UWC", employee.name);
            });
        }
    }
}