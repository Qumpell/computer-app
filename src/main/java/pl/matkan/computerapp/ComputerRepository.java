package pl.matkan.computerapp;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
