package com.pwojtowicz.pam.oImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/image")
public class oImageController {

    private final oImageService imageService;

    @Autowired
    public oImageController(oImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        oImage image = imageService.getImageById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image.getData());
    }

}
