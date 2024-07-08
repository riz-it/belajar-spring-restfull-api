package riz_it.belajar_spring_restfull_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import riz_it.belajar_spring_restfull_api.entity.User;
import riz_it.belajar_spring_restfull_api.model.ContactResponse;
import riz_it.belajar_spring_restfull_api.model.CreateContactRequest;
import riz_it.belajar_spring_restfull_api.model.WebResponse;
import riz_it.belajar_spring_restfull_api.service.ContactService;
import org.springframework.http.MediaType;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping(
            path = "/api/contacts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ContactResponse> create(User user, @RequestBody CreateContactRequest request){
        ContactResponse contactResponse = contactService.create(user, request);
        return WebResponse.<ContactResponse>builder()
                .data(contactResponse)
                .build();
    }

}
