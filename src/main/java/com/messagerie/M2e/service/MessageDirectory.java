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
	
	public void deleteMessage(Integer id){
		messageRepository.deleteById(id);
	}

	public void updateMessage(Message messageToUpdate, Integer id){
		messageRepository.save(messageToUpdate);
	}

	public void patchMessage(Message messageToUpdate, Integer id){
		Optional<Message> op = messageRepository.findById(id);
		if(op.isPresent()){
			Message message = op.get();
			message.patch(messageToUpdate);
			messageRepository.save(message);
		}
	}
}
