package riz_it.belajar_spring_restfull_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import riz_it.belajar_spring_restfull_api.entity.Contact;
import riz_it.belajar_spring_restfull_api.entity.User;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, String> , JpaSpecificationExecutor<Contact> {
    Optional<Contact> findFirstByUserAndId(User user, String id);
}

