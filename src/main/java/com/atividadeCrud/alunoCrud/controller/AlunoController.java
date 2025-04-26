package com.atividadeCrud.alunoCrud.controller;

import com.atividadeCrud.alunoCrud.model.Aluno;
import com.atividadeCrud.alunoCrud.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
     private  final AlunoService _alunoService;

     public AlunoController(AlunoService alunoService){
         this._alunoService = alunoService;
     }

     @GetMapping
    public List<Aluno> listar(){
         return _alunoService.listarTodos();
     }

     @PostMapping
    public Aluno criar(@RequestBody Aluno aluno){
         return _alunoService.salvarAluno(aluno);
     }

     @GetMapping("/{id}")
    public Aluno buscar(@PathVariable Long id){
         return _alunoService.buscarById(id);
     }

     @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno novoAluno){
         Aluno alunoExistente = _alunoService.buscarById(id);
         if (alunoExistente == null) return null;
         alunoExistente.setNome(novoAluno.getNome());
         alunoExistente.setEmail(novoAluno.getEmail());
         alunoExistente.setTelefone(novoAluno.getTelefone());
         return _alunoService.salvarAluno(alunoExistente);
     }

     @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
         _alunoService.deletar(id);
     }
}
