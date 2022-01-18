package com.citius.inboxms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citius.inboxms.entity.Notes;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {

	List<Notes> findAllByReceiverName(String rename);

}
