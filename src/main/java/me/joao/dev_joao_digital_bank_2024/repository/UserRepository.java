package me.joao.dev_joao_digital_bank_2024.repository;

import me.joao.dev_joao_digital_bank_2024.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByAccountNumber(String accountNumber);
}
