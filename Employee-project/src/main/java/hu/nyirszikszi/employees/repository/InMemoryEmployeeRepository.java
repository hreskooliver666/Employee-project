package hu.nyirszikszi.employees.repository;

import hu.nyirszikszi.employees.domain.Employee;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryEmployeeRepository {

    private final Map<Long, Employee> store = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(0);


}
