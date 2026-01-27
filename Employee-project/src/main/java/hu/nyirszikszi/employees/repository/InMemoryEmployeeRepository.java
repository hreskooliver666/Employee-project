package hu.nyirszikszi.employees.repository;

import hu.nyirszikszi.employees.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
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

    public boolean existsById(long id) {
        return store.containsKey(id);
    }

    public void deleteById(long id) {
        store.remove(id);
    }

    public Optional<Employee> findByEmailIgnoreCase(String email) {
        if (email == null) return Optional.empty();
        String needle = email.trim().toLowerCase(Locale.ROOT);
        return store.values().stream()
                .filter(e -> e.getEmail() != null && e.getEmail().trim().toLowerCase(Locale.ROOT).equals(needle))
                .findFirst();
    }

}
