package riz_it.belajar_spring_restfull_api.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import riz_it.belajar_spring_restfull_api.entity.Contact;
import riz_it.belajar_spring_restfull_api.entity.User;
import riz_it.belajar_spring_restfull_api.model.ContactResponse;
import riz_it.belajar_spring_restfull_api.model.CreateContactRequest;
import riz_it.belajar_spring_restfull_api.repository.ContactRepository;

import java.util.UUID;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public ContactResponse create(User user, CreateContactRequest request){
        validationService.validate(request);

        Contact contact = new Contact();
        contact.setId(UUID.randomUUID().toString());
        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setPhone(request.getPhoneNumber());
        contact.setEmail(request.getEmail());
        contact.setUser(user);

        contactRepository.save(contact);

        return ContactResponse.builder()
                .id(contact.getId())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .email(contact.getEmail())
                .phone(contact.getPhone())
                .build();
    }
}
