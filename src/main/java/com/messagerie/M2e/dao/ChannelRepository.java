package com.messagerie.M2e.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.messagerie.M2e.model.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Integer> {

}