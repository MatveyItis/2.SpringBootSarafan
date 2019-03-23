package ru.itis.maletskov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.maletskov.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
