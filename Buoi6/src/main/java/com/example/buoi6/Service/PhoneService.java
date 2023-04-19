package com.example.buoi6.Service;
import com.example.buoi6.entity.Phone;

import java.util.List;
import java.util.Optional;


public interface PhoneService {
    Phone Save(Phone phone);
    Phone Update(Phone phone);
    void Remove(Long id);
    List<Phone> FindAll();
    Optional<Phone> FindByID(Long id);
}
