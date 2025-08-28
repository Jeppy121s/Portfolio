package com.example.SpringRestTemplateDashboard.controllers;

import com.example.SpringRestTemplateDashboard.models.Album;
import com.example.SpringRestTemplateDashboard.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class AlbumController {
    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService){
        this.albumService=albumService;
    }

    @PostMapping("/saveAlbum")
    public void saveAlbum(@RequestBody List<Album> album){
        albumService.saveAlbum(album);
    }
}
