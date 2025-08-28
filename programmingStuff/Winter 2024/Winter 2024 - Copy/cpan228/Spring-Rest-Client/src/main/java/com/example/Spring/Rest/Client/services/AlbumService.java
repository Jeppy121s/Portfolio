package com.example.Spring.Rest.Client.services;

import com.example.Spring.Rest.Client.models.Album;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class AlbumService {

private RestClient restClient;

public AlbumService() {
    restClient = RestClient.builder().baseUrl("http://jsonplaceholder.typicode.com").build();
}
    public List<Album> getAlbums(){
    return restClient
            .get()
            .uri("/albums")
            .retrieve()
            .body(new ParameterizedTypeReference<List<Album>>() {
            });
    }

    public Album getAlbumById(Integer id){
    return restClient.get().uri("/albums/" + id).retrieve().body(Album.class);
    }

    public Album addAlbum(Album album) {
    return restClient.post().uri("/albums").body(album).retrieve().body(Album.class);
    }

    public Album updateAlbum(Integer id, Album album) {
    return restClient.put().uri("/albums/"+id).retrieve().body(Album.class);
    }

    public void deleteAlbum(Integer id) {
    restClient.delete().uri("albums/"+id).retrieve().toBodilessEntity();
    }
}

