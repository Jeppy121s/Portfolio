package com.example.SpringRestTemplateAlbum.controllers;

import com.example.SpringRestTemplateAlbum.models.Album;
import com.example.SpringRestTemplateAlbum.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {


    private final AlbumService albumService;
    @Autowired
    public AlbumController(AlbumService albumService){
        this.albumService=albumService;
    }

    @GetMapping("/getAlbums")
    public List<Album> getAlbums(){
        return albumService.getAlbums();
    }
}
