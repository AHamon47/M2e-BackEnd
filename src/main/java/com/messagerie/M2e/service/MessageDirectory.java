package com.messagerie.M2e.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.messagerie.M2e.dao.MessageRepository;
import com.messagerie.M2e.model.Message;

@Service
public class MessageDirectory {
	
	@Autowired
	private MessageRepository messageRepository;
	
	public void addMessage(Message newMessage) {

		messageRepository.save(newMessage);
		
	}
	
	public List<Message> getMessages(){
		return messageRepository.findAll();
	}

	public Optional<Message> getMessage(Integer id) {
		return messageRepository.findById(id);
	}
	
	
}
