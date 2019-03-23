package ru.itis.maletskov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.maletskov.model.Message;
import ru.itis.maletskov.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message save(Message message) {
        return messageRepository.save(message);

    }

    public void deleteMessage(Message message) {
        messageRepository.delete(message);
    }
}
