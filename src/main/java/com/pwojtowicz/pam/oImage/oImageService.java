package com.pwojtowicz.pam.oImage;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@Service
public class oImageService {

    private final oImageRepository imageRepository;

    @Autowired
    public oImageService(oImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public void saveImage(oImage image){
        this.imageRepository.save(image);
    }

    public oImage getImageById(Long id){
        return this.imageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Image not found -> id: " + id));
    }

    public void deleteImageById(Long id) {
        imageRepository.deleteById(id);
    }
}
