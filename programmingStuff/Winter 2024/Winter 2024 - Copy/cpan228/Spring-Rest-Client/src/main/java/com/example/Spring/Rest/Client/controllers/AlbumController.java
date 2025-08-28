package com.example.Spring.Rest.Client.controllers;

import com.example.Spring.Rest.Client.models.Album;
import com.example.Spring.Rest.Client.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album/api/v1/")
public class AlbumController {
    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService){
        this.albumService=albumService;
    }

    @GetMapping("/albums")
    public List<Album> getAlbums(){
        return this.getAlbums();
    }

    @GetMapping("/albums/{id}")
    public Album getAlbumById(@PathVariable Integer id){
        return this.albumService.getAlbumById(id);
    }

    //save and album
    @PostMapping("/albums")
    public Album addAlbum(@RequestBody Album album){
        return this.albumService.addAlbum(album);
    }
    @PutMapping("/albums/{id}")
    public void updateAlbum(@PathVariable Integer id,@RequestBody Album album){
        this.albumService.updateAlbum(id,album);
    }

    @DeleteMapping
    public void deleteAlbum(@PathVariable Integer id){
        this.albumService.deleteAlbum(id);
    }

}
