package com.citius.inboxms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citius.inboxms.entity.Notes;
import com.citius.inboxms.service.impl.NoteServiceImpl;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "http://localhost:4200")
public class NotesController {
	
	@Autowired
	private NoteServiceImpl noteService;


	@GetMapping("/ping")
	public String greetings() {
		return "Working";
	}

	@GetMapping("/all")
	public List<Notes> AllNotes() {
		return noteService.getAllNotes();
	}

	@GetMapping("/{id}")
	public Notes getNotesId(@PathVariable("id") Long id) {
		return noteService.getNotesById(id);
	}

	@PostMapping("/save")
	public Notes newNotes(@RequestBody Notes notes) {
		return noteService.save(notes);
	}

	@PatchMapping("/update/{id}")
	public Notes addReply(@RequestBody Notes notes ,@PathVariable("id") Long id) {
		noteService.save(notes);
		return notes;
	}

	@DeleteMapping("/{id}")
	public void deleteNotes(@PathVariable("id") long id) {
		noteService.deleteNotes(id);
	}
    @GetMapping("name/{name}")
    public List<Notes> getNotesByName(@PathVariable("name")String name){
    	return noteService.getNotesByName(name);
    }
}
