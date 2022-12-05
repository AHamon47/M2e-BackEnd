package com.messagerie.M2e.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.messagerie.M2e.model.Message;


@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

	
}
