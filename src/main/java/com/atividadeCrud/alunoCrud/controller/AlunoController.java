package com.atividadeCrud.alunoCrud.controller;

import com.atividadeCrud.alunoCrud.model.Aluno;
import com.atividadeCrud.alunoCrud.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService _alunoService;

    public AlunoController(AlunoService alunoService) {
        this._alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> listarAlunos() {
        return _alunoService.listarTodos();
    }

    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return _alunoService.salvarAluno(aluno);
    }

    @GetMapping("/{id}")
    public Aluno buscarAlunoPorId(@PathVariable Long id) {
        return _alunoService.buscarById(id);
    }

    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAlterado) {
        Aluno alunoExistente = _alunoService.buscarById(id);
        if (alunoExistente == null) return null;
        alunoExistente.setNomeAluno(alunoAlterado.getNomeAluno());
        alunoExistente.setEmailAluno(alunoAlterado.getEmailAluno());
        alunoExistente.setTelefoneAluno(alunoAlterado.getTelefoneAluno());
        return _alunoService.salvarAluno(alunoAlterado);
    }



    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id) {
        _alunoService.deletar(id);
    }
}
