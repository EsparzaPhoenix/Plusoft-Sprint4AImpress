package br.com.fiap.aimpress.service;

import br.com.fiap.aimpress.dto.CurriculoDto;
import br.com.fiap.aimpress.model.curriculo.Curriculo;
import br.com.fiap.aimpress.repository.CurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurriculoService {

    @Autowired
    private CurriculoRepository curriculoRepository;

    public List<CurriculoDto> getAllCurriculos() {
        return curriculoRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public CurriculoDto getCurriculoById(Long id) {
        return curriculoRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Currículo não encontrado"));
    }


    public CurriculoDto createCurriculo(CurriculoDto curriculoDto) {
        Curriculo curriculo = toEntity(curriculoDto);
        return toDto(curriculoRepository.save(curriculo));
    }

    public CurriculoDto updateCurriculo(Long id, CurriculoDto curriculoDto) {
        Curriculo curriculo = toEntity(curriculoDto);
        curriculo.setId(id);
        return toDto(curriculoRepository.save(curriculo));
    }

    public void deleteCurriculo(Long id) {
        curriculoRepository.deleteById(id);
    }

    private CurriculoDto toDto(Curriculo curriculo) {
        Long usuarioId = (curriculo.getUsuario() != null) ? curriculo.getUsuario().getId() : null;
        return new CurriculoDto(curriculo.getId(), curriculo.getNome(), curriculo.getNumeroTelefone(),
                curriculo.getResumo(), curriculo.getExperiencia(), curriculo.getNivelEscolaridade(),
                curriculo.getCarreira(), curriculo.getCursos(), curriculo.getIdiomas(), usuarioId);
    }

    private Curriculo toEntity(CurriculoDto dto) {
        Curriculo curriculo = new Curriculo();
        curriculo.setNome(dto.getNome());
        curriculo.setNumeroTelefone(dto.getNumeroTelefone());
        curriculo.setResumo(dto.getResumo());
        curriculo.setExperiencia(dto.getExperiencia());
        curriculo.setNivelEscolaridade(dto.getNivelEscolaridade());
        curriculo.setCarreira(dto.getCarreira());
        curriculo.setCursos(dto.getCursos());
        curriculo.setIdiomas(dto.getIdiomas());
        return curriculo;
    }
}
