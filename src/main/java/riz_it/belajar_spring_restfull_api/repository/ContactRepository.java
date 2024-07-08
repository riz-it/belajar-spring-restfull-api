package riz_it.belajar_spring_restfull_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import riz_it.belajar_spring_restfull_api.entity.Contact;
import riz_it.belajar_spring_restfull_api.entity.User;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, String> {
    Optional<Contact> findFirstByUserAndId(User user, String id);
}

