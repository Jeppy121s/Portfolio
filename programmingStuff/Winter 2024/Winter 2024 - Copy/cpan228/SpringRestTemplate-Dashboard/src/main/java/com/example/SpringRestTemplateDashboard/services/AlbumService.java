package com.example.SpringRestTemplateDashboard.services;

import com.example.SpringRestTemplateDashboard.models.Album;
import com.example.SpringRestTemplateDashboard.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository){
        this.albumRepository=albumRepository;
    }

    public void saveAlbum(Album album) {
        this.albumRepository.save(album);
    }
}
