package com.reddropforlife.reddropforlife;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SearchedRepository extends JpaRepository<Members, Long> {
    @Query("SELECT p FROM Members p WHERE p.bloodGrp LIKE %?1"
    )
    public List<Members> search(String bldgrp);
}
