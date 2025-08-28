package com.example.SpringRestTemplateAlbum.repositories;

import com.example.SpringRestTemplateAlbum.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Integer> {

}
