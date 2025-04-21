package com.todo.user_api_demo.repository;


import com.todo.user_api_demo.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Notes, Long> {
    @Override
    List<Notes> findAllById(Iterable<Long> longs);

}
