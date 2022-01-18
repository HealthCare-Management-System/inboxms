package com.citius.inboxms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citius.inboxms.entity.Notes;
import com.citius.inboxms.repository.NotesRepository;

@Service
public class NoteServiceImpl {

	@Autowired
	private NotesRepository notesRepository;

	
	public Notes save(Notes notes) {

		return notesRepository.save(notes);
	}

	public void update(Notes n, long id) {
		notesRepository.save(n);
	}

	public List<Notes> getAllNotes() {
		return notesRepository.findAll();
	}

	public void deleteNotes(Long id) {

		notesRepository.deleteById(id);
	}

	public Notes getNotesById(Long id) {
		return notesRepository.findById(id).get();
	}
	public List<Notes> getNotesByName(String rename){
		List<Notes> notes=notesRepository.findAllByReceiverName(rename);
		return notes;
	}
	
}
