package com.springStart.SpringProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springStart.SpringProject.models.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
