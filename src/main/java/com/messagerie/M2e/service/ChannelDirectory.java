package com.messagerie.M2e.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.messagerie.M2e.dao.ChannelRepository;
import com.messagerie.M2e.model.Channel;

@Service
public class ChannelDirectory {

	@Autowired
	private ChannelRepository channelRepository;
	
	public void addChannel(Channel newChannel) {

		channelRepository.save(newChannel);
	}
	
	public List<Channel> getChannels(){
		return channelRepository.findAll();
	}

	public Optional<Channel> getChannel(Integer id) {
		return channelRepository.findById(id);
	}

	public void deleteChannel(Integer id){
		channelRepository.deleteById(id);
	}

	public void updateChannel(Channel channelToUpdate, Integer id){
		channelRepository.save(channelToUpdate);
	}

	public void patchChannel(Channel channelToUpdate, Integer id){
		Optional<Channel> op = channelRepository.findById(id);
		if(op.isPresent()){
			Channel channel = op.get();
			channel.patch(channelToUpdate);
			channelRepository.save(channel);
		}
	}
}
