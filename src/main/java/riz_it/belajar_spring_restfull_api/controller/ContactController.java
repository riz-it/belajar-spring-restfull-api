package riz_it.belajar_spring_restfull_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import riz_it.belajar_spring_restfull_api.entity.User;
import riz_it.belajar_spring_restfull_api.model.ContactResponse;
import riz_it.belajar_spring_restfull_api.model.CreateContactRequest;
import riz_it.belajar_spring_restfull_api.model.UpdateContactRequest;
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

    @GetMapping(
            path = "/api/contacts/{contactId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ContactResponse> get(User user, @PathVariable("contactId") String id){
        ContactResponse contactResponse = contactService.get(user, id);
        return WebResponse.<ContactResponse>builder()
                .data(contactResponse)
                .build();
    }

    @PutMapping(
            path = "/api/contacts/{contactId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ContactResponse> update(User user, @PathVariable("contactId") String id, @RequestBody UpdateContactRequest request){
        request.setId(id);
        ContactResponse contactResponse = contactService.update(user, request);
        return WebResponse.<ContactResponse>builder()
                .data(contactResponse)
                .build();
    }

}
