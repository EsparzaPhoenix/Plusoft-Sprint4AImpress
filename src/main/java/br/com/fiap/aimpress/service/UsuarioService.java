package br.com.fiap.aimpress.service;

import br.com.fiap.aimpress.dto.UsuarioDto;
import br.com.fiap.aimpress.model.usuario.Usuario;
import br.com.fiap.aimpress.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDto> getAllUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public UsuarioDto getUsuarioById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return toDto(usuario);
    }

    public UsuarioDto createUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = toEntity(usuarioDto);
        usuario = usuarioRepository.save(usuario);
        return toDto(usuario);
    }

    public UsuarioDto updateUsuario(Long id, UsuarioDto usuarioDto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuario.setName(usuarioDto.getName());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setCpf(usuarioDto.getCpf());
        usuario.setTelefone(usuarioDto.getTelefone());
        usuario.setDataNascimento(usuarioDto.getDataNascimento());
        usuario = usuarioRepository.save(usuario);
        return toDto(usuario);
    }

    public void deleteUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        usuarioRepository.deleteById(id);
    }

    private UsuarioDto toDto(Usuario usuario) {
        UsuarioDto dto = new UsuarioDto();
        dto.setId(usuario.getId());
        dto.setName(usuario.getName());
        dto.setEmail(usuario.getEmail());
        dto.setCpf(usuario.getCpf());
        dto.setTelefone(usuario.getTelefone());
        dto.setDataNascimento(usuario.getDataNascimento());
        dto.setCurriculosIds(usuario.getCurriculos().stream()
                .map(curriculo -> curriculo.getId())
                .collect(Collectors.toList()));
        return dto;
    }

    private Usuario toEntity(UsuarioDto dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setName(dto.getName());
        usuario.setEmail(dto.getEmail());
        usuario.setCpf(dto.getCpf());
        usuario.setTelefone(dto.getTelefone());
        usuario.setDataNascimento(dto.getDataNascimento());
        // Nota: A lista de currículos pode ser mapeada aqui caso necessário
        return usuario;
    }
}
