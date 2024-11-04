package br.com.fiap.aimpress.service;

import br.com.fiap.aimpress.dto.EmpresaDto;
import br.com.fiap.aimpress.model.empresa.Empresa;
import br.com.fiap.aimpress.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<EmpresaDto> getAllEmpresas() {
        return empresaRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public EmpresaDto getEmpresaById(Long id) {
        Empresa empresa = empresaRepository.findById(id).orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
        return toDto(empresa);
    }

    public EmpresaDto createEmpresa(EmpresaDto empresaDto) {
        Empresa empresa = toEntity(empresaDto);
        return toDto(empresaRepository.save(empresa));
    }

    public EmpresaDto updateEmpresa(Long id, EmpresaDto empresaDto) {
        Empresa empresa = toEntity(empresaDto);
        empresa.setId(id);
        return toDto(empresaRepository.save(empresa));
    }

    public void deleteEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }

    private EmpresaDto toDto(Empresa empresa) {
        return new EmpresaDto(empresa.getId(), empresa.getNome(), empresa.getCnpj(), empresa.getDescricao(),
                empresa.getEmail(), empresa.getTelefone());
    }

    private Empresa toEntity(EmpresaDto dto) {
        Empresa empresa = new Empresa();
        empresa.setNome(dto.getNome());
        empresa.setCnpj(dto.getCnpj());
        empresa.setDescricao(dto.getDescricao());
        empresa.setEmail(dto.getEmail());
        empresa.setTelefone(dto.getTelefone());
        return empresa;
    }
}
