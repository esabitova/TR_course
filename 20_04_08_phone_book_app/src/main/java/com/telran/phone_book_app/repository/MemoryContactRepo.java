package com.telran.phone_book_app.repository;

import com.telran.phone_book_app.entity.Contact;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class MemoryContactRepo implements IContactRepo {

    Map<Integer, Contact> source = new HashMap<>();
    private AtomicInteger currentId = new AtomicInteger();

    @Override
    public void add(Contact contact) {
        source.put(currentId.incrementAndGet(), contact);
        contact.setContactId(currentId.get());
    }

    @Override
    public void edit(Contact contact) {
        source.replace(contact.getContactId(), contact);
    }

    @Override
    public Contact find(int id) {
        return source.get(id);
    }

    @Override
    public Contact remove(int id) {
        return source.remove(id);
    }

    @Override
    public List<Contact> findAll() {
        return source
                .values()
                .stream()
                .sorted(Comparator.comparingInt(Contact::getContactId))
                .collect(Collectors.toList());
    }

    public List<Contact> findAllByName(String name) {
        return source
                .values()
                .stream()
                .filter(contact -> contact.getName().contains(name))
                .collect(Collectors.toList());
    }

    public List<Contact> findAllByLastName(String lastName) {

        return source
                .values()
                .stream()
                .filter(contact -> contact.getLastName().contains(lastName))
                .collect(Collectors.toList());
    }
}
