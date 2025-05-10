package com.atividadeCrud.alunoCrud.controller;



import com.atividadeCrud.alunoCrud.model.Professor;
import com.atividadeCrud.alunoCrud.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorService _professorService;

    public ProfessorController(ProfessorService professorService) {
        this._professorService = professorService;
    }

    @GetMapping
    public List<Professor> listarProfessores() {
        return _professorService.listarProfessores();
    }

    @PostMapping
    public Professor salvarProfessor(@RequestBody Professor professor) {
        return _professorService.salvarProfessor(professor);
    }

    @GetMapping("/{id}")
    public Professor buscarProfPorId(@PathVariable Long id) {
        return _professorService.buscarProfById(id);
    }

    @PutMapping("/{id}")
    public Professor atualizarProfessor(@PathVariable Long id, @RequestBody Professor professorAlterado) {
        Professor professorExistente = _professorService.buscarProfById(id);
        if (professorExistente == null) return null;
        professorExistente.setNomeProfessor(professorAlterado.getNomeProfessor());
        professorExistente.setEmailProfessor(professorAlterado.getEmailProfessor());
        professorExistente.setTelefoneProfessor(professorAlterado.getTelefoneProfessor());
        return _professorService.salvarProfessor(professorAlterado);
    }



    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable Long id) {
        _professorService.deletarProfessor(id);
    }
}
