package com.messagerie.M2e.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.messagerie.M2e.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
