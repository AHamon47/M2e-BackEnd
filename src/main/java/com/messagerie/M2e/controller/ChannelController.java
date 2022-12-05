package com.messagerie.M2e.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.messagerie.M2e.model.Channel;
import com.messagerie.M2e.service.ChannelDirectory;

@RestController
@RequestMapping("api")
public class ChannelController {
	@Autowired
	private ChannelDirectory channelDirectory;

	@GetMapping("channels")
	public List<Channel> getChannels() {
		return channelDirectory.getChannels();
	}

	@GetMapping("channels/{id}")
	public ResponseEntity<Channel> getChannel(@PathVariable("id") Integer id) {
		Optional<Channel> optionalChannel = channelDirectory.getChannel(id);
		if (optionalChannel.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(optionalChannel.get());
		}
	}

	@PostMapping("channels")
	public Channel postChannel(@RequestBody Channel newChannel) {
		channelDirectory.addChannel(newChannel);
		return newChannel;
	}

	@DeleteMapping("channels/{id}")
	public void deleteChannel(@PathVariable("id") Integer id) {
		channelDirectory.deleteChannel(id);
	}

	@PutMapping("channels/{id}")
	public ResponseEntity updateChannel(@RequestBody Channel channel, @PathVariable("id") Integer id) {

		if (id != channel.getId()) {
			return ResponseEntity.badRequest().build();
		} else {

			channelDirectory.updateChannel(channel, id);
			return ResponseEntity.ok().build();
		}
	}

	@PatchMapping("channels/{id}")
	public void patchChannels(@RequestBody Channel channel, @PathVariable("id") Integer id) {
		System.out.println(channel);
		channelDirectory.patchChannel(channel, id);
	}
}
