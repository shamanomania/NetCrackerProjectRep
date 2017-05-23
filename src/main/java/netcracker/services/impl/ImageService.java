package netcracker.services.impl;

import netcracker.domain.entities.Images;
import netcracker.domain.entities.Test;
import netcracker.repository.ImagesRepository;
import netcracker.services.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Sid775 on 11.02.2017.
 */

@Service
public class ImageService implements IImageService {

    @Autowired
    private ImagesRepository imagesRepository;

    @Override
    public Images findById(Long id) {
        return imagesRepository.findOne(id);
    }

    @Override
    public void save(Images images) {
        imagesRepository.save(images);
    }

    @Override
    public Images findTestImg(Test test) {
        return imagesRepository.findByTest(test);
    }

    @Override
    public Images findTop() {
        return imagesRepository.findAll().get(imagesRepository.findAll().size()-1);
    }
}
