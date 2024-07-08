package riz_it.belajar_spring_restfull_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import riz_it.belajar_spring_restfull_api.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, String> {
}

