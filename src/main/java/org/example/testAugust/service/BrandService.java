package org.example.testAugust.service;

import lombok.RequiredArgsConstructor;
import org.example.testAugust.entity.Brand;
import org.example.testAugust.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public List<Brand> getList() {
        return this.brandRepository.findAll();
    }
}
