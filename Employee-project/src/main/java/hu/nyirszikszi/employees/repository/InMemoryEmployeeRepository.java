package hu.nyirszikszi.employees.repository;

import hu.nyirszikszi.employees.domain.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryEmployeeRepository {

    private final Map<Long, Employee> store = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(0);

    public Employee save(Employee employee) {
        if (employee.getId() == 0) {
            employee.setId(seq.incrementAndGet());
        }
        store.put(employee.getId(), employee);
        return employee;
    }

    public Optional<Employee> findById(long id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<Employee> findAll() {
        return store.values().stream()
                .sorted(Comparator.comparingLong(Employee::getId))
                .toList();
    }

}
