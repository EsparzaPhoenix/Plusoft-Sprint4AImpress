package br.com.fiap.aimpress.service;

import br.com.fiap.aimpress.dto.VagaDto;
import br.com.fiap.aimpress.model.vaga.Vaga;
import br.com.fiap.aimpress.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    public List<VagaDto> getAllVagas() {
        return vagaRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public VagaDto getVagaById(Long id) {
        Vaga vaga = vagaRepository.findById(id).orElseThrow(() -> new RuntimeException("Vaga não encontrada"));
        return toDto(vaga);
    }

    public VagaDto createVaga(VagaDto vagaDto) {
        Vaga vaga = toEntity(vagaDto);
        return toDto(vagaRepository.save(vaga));
    }

    public VagaDto updateVaga(Long id, VagaDto vagaDto) {
        Vaga vaga = toEntity(vagaDto);
        vaga.setId(id);
        return toDto(vagaRepository.save(vaga));
    }

    public void deleteVaga(Long id) {
        vagaRepository.deleteById(id);
    }

    private VagaDto toDto(Vaga vaga) {
        return new VagaDto(vaga.getId(), vaga.getTitulo(), vaga.getDescricao(), vaga.getRequisitos(), vaga.getEmpresa().getId());
    }

    private Vaga toEntity(VagaDto dto) {
        Vaga vaga = new Vaga();
        vaga.setTitulo(dto.getTitulo());
        vaga.setDescricao(dto.getDescricao());
        vaga.setRequisitos(dto.getRequisitos());
        return vaga;
    }
}
