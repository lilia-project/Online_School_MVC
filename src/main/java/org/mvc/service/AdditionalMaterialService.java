package org.mvc.service;

import org.mvc.entity.AdditionalMaterial;
import org.mvc.handler.EntityNotFoundException;
import org.mvc.repository.AdditionalMaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdditionalMaterialService {
    private final AdditionalMaterialRepo additionalMaterialRepo;

    @Autowired
    public AdditionalMaterialService(AdditionalMaterialRepo additionalMaterialRepo) {
        this.additionalMaterialRepo = additionalMaterialRepo;
    }

    public void save(String name, int lectureId) {

        AdditionalMaterial additionalMaterial = new AdditionalMaterial();
        additionalMaterial.setName(name);
        additionalMaterial.setLectureId(lectureId);
        additionalMaterialRepo.saveAndFlush(additionalMaterial);
    }

    public AdditionalMaterial getRequireById(int additionalMaterialId) throws EntityNotFoundException {
        Optional<AdditionalMaterial> additionalMaterial = Optional.of(additionalMaterialRepo.getById(additionalMaterialId));
        if (additionalMaterial.isEmpty()) {
            throw new EntityNotFoundException("entity not found");
        }
        return additionalMaterial.get();
    }

    public Optional<List<AdditionalMaterial>> findAllByLectureId(int lectureId) {
        return additionalMaterialRepo.getByLectureId(lectureId);
    }

}
