package com.aluracursos.forumhub.controller;

import com.aluracursos.forumhub.dto.DadosAtualizacaoTopico;
import com.aluracursos.forumhub.dto.DadosCadastroTopico;
import com.aluracursos.forumhub.dto.DadosDetalhamentoTopico;
import com.aluracursos.forumhub.model.Topico;
import com.aluracursos.forumhub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
        if (repository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())) {
            return ResponseEntity.badRequest().body("Tópico duplicado!");
        }
        var topico = new Topico(dados.titulo(), dados.mensagem(), dados.autor(), dados.curso());
        repository.save(topico);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoTopico>> listar() {
        var topicos = repository.findAll().stream()
                .map(DadosDetalhamentoTopico::new)
                .toList();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = repository.findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(new DadosDetalhamentoTopico(topico.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados) {
        var topico = repository.findById(id);
        if (topico.isPresent()) {
            Topico t = topico.get();
            if (dados.titulo() != null) t.setTitulo(dados.titulo());
            if (dados.mensagem() != null) t.setMensagem(dados.mensagem());
            if (dados.autor() != null) t.setAutor(dados.autor());
            if (dados.curso() != null) t.setCurso(dados.curso());
            return ResponseEntity.ok(new DadosDetalhamentoTopico(t));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}