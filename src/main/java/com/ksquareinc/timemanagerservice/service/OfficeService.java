package com.ksquareinc.timemanagerservice.service;

import com.ksquareinc.timemanagerservice.model.Office;
import com.ksquareinc.timemanagerservice.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeService {

    @Autowired
    OfficeRepository officeRepository;

    public List<Office> findAll(){
        return officeRepository.findAll();
    }

    public Optional<Office> findOne(long id){
        return officeRepository.findById(id);
    }

    public void delete(Office Office){
            officeRepository.delete(Office);
    }
    public Office save(Office Office){
        return officeRepository.save(Office);
    }
}
