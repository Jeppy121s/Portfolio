package com.example.SpringRestTemplateDashboard.repositories;

import com.example.SpringRestTemplateDashboard.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Integer> {

}
