package com.springStart.SpringProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springStart.SpringProject.models.Authority;
import com.springStart.SpringProject.repositories.AuthorityRepository;

import java.util.Optional;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public Authority save(Authority authority) {
        return authorityRepository.save(authority);

    }

    public Optional<Authority> findById(Long id) {
        return authorityRepository.findById(id);
    }

}
