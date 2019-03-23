package ru.itis.maletskov.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itis.maletskov.exception.NotFoundException;
import ru.itis.maletskov.model.Message;
import ru.itis.maletskov.model.Views;
import ru.itis.maletskov.service.MessageService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("message")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Message> list() {
        return messageService.getAllMessages();
    }

    @GetMapping("{id}")
    @JsonView(Views.FullMessage.class)
    public Message getOne(@PathVariable("id") Message message) {
        return message;
    }

    @PostMapping
    public Message create(@RequestBody Message message) {
        message.setCreationDate(LocalDateTime.now());
        messageService.save(message);
        return message;
    }

    @PutMapping("{id}")
    public Message update(@PathVariable("id") Message messageFromDb,
                          @RequestBody Message message) {
        BeanUtils.copyProperties(message, messageFromDb, "id");
        return messageService.save(messageFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message) {
        messageService.deleteMessage(message);
    }
}
