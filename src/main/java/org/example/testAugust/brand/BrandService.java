package org.example.testAugust.brand;

import lombok.RequiredArgsConstructor;
import org.example.testAugust.brand.Brand;
import org.example.testAugust.brand.BrandRepository;
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
