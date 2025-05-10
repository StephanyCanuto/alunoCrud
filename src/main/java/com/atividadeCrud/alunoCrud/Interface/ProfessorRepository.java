package com.atividadeCrud.alunoCrud.Interface;

import com.atividadeCrud.alunoCrud.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
