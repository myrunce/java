package com.myron.Lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myron.Lookify.models.Song;

@Repository
public interface LookifyRepository extends CrudRepository<Song, Long> {
	List<Song> findByArtistContaining(String search);
	List<Song> findTop10ByOrderByRatingDesc();
}
