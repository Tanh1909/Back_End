package com.example.buoi6.Service;

import com.example.buoi6.entity.Phone;
import com.example.buoi6.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneServiceImplement implements PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public Phone Save(Phone phone) {
       return phoneRepository.save(phone);
    }

    @Override
    public Phone Update(Phone phone) {
        return phoneRepository.findById(phone.getId()).map(phone1 -> {
            phone1.setName(phone.getName());
            phone1.setBrand(phone.getBrand());
            return phoneRepository.save(phone1);
        }).orElseGet(() -> phoneRepository.save(phone));
    }

    @Override
    public void Remove(Long id) {
        phoneRepository.deleteById(id);
    }

    @Override
    public List<Phone> FindAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Optional<Phone> FindByID(Long id) {
        return phoneRepository.findById(id);
    }
}
