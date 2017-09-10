package com.myron.Lookify.controllers;



import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myron.Lookify.models.Song;
import com.myron.Lookify.services.LookifyService;

@Controller
public class LookifyController {
	@SuppressWarnings("unused")
	private final LookifyService lookifyService;
	
	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(@Valid @ModelAttribute("song") Song song, BindingResult result, Model model) {
		List<Song> songs = lookifyService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/songs/new")
    public String newSong(@Valid @ModelAttribute("song") Song song, BindingResult result){
        return "newSong.jsp";
    }
	
	@PostMapping("/songs/new")
	public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
            return "newSong.jsp";
        }else{
            lookifyService.addSong(song);
            return "redirect:/dashboard";
        }
	}
	
	@RequestMapping("/songs/{id}")
    public String findSongByIndex(Model model, @PathVariable("id") Long id) {
        Song song = lookifyService.findSongById(id);
        model.addAttribute("song", song);
        model.addAttribute("id", id);
        return "showSong.jsp";
    }
	
	@RequestMapping("/songs/topSongs")
    public String topSongs(Model model) {
        List<Song> songs = lookifyService.topTen();
        model.addAttribute("songs", songs);
        return "topSongs.jsp";
    }
	
	@RequestMapping("/search/{artist}")
	public String byArtist(Model model, @PathVariable("artist") String artist,@Valid @ModelAttribute("song") Song song, BindingResult result) {
		List<Song> songs = lookifyService.findbyArtisr(artist);
		model.addAttribute("songs", songs);
		return "artistSongs.jsp";
	}
	
	@PostMapping("/search")
	public String checkArtist(@Valid @ModelAttribute("song") Song song, BindingResult result, Model model, @RequestParam("artist") String artist) {
		if (result.hasErrors()) {
            return "redirect:/dashboard";
        }else{
    		return "redirect:/search/" + artist;
        }
	}
	
	@RequestMapping("/delete/{id}")
	public String destroySong(@PathVariable("id") Long id) {
        lookifyService.destroySong(id);
        return "redirect:/dashboard";
	}
}
