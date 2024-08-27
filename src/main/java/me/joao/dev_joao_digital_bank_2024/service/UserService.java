package me.joao.dev_joao_digital_bank_2024.service;

import me.joao.dev_joao_digital_bank_2024.domain.model.User;


public interface UserService {

    User findById(Long id);
    User create(User userToCreate);
}
