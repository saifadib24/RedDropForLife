package com.reddropforlife.reddropforlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchedRepositoryService {
    @Autowired
    private SearchedRepository srepo;

    public List<Members> listAll(String bldgrp) {
        if (bldgrp != null) {
            return srepo.search(bldgrp);
        }
        return srepo.findAll();
    }
}
