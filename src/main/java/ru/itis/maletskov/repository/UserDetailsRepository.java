package ru.itis.maletskov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.maletskov.model.User;

public interface UserDetailsRepository extends JpaRepository<User, String> {
}
