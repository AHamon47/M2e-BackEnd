package com.messagerie.M2e.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.messagerie.M2e.model.Message;
import com.messagerie.M2e.service.MessageDirectory;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("api")
public class MessageController {
	
	@Autowired
	private MessageDirectory messageDirectory;
	
	@GetMapping("messages")
	public List<Message> getClients() {
		return messageDirectory.getMessages();
	}

	@GetMapping("messages/{id}")
	public ResponseEntity<Message> getMessage(@PathVariable("id") Integer id) {
		Optional<Message> optionalMessage = messageDirectory.getMessage(id);
		if (optionalMessage.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(optionalMessage.get());
		}
	}
	
	@PostMapping("messages")
	public Message postClient(@RequestBody Message newMessage) {
		messageDirectory.addMessage(newMessage);
		return newMessage;
	}

}
