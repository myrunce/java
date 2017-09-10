package com.myron.Lookify.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myron.Lookify.models.Song;
import com.myron.Lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	
	private LookifyRepository lookifyRepository;
	
	public LookifyService(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
	
	public void addSong(Song song) {
		lookifyRepository.save(song);
	}
	
	public List<Song> allSongs() {
		return (List<Song>) lookifyRepository.findAll();
	}
	
    public Song findSongById(Long id) {
    	return lookifyRepository.findOne(id);
    }
      
    public void updateSong(Song song) {
    	lookifyRepository.save(song);
    }
    
    public void destroySong(Long id) {
    	lookifyRepository.delete(id);
    }
    
    public List<Song> findbyArtisr(String search){
    	return (List<Song>) lookifyRepository.findByArtistContaining(search);
    }
    
    public List<Song> topTen(){
    	List<Song> topTen = new ArrayList<Song>();
    	topTen = lookifyRepository.findTop10OrderByRatingDesc();
    	return topTen;
    }
}

