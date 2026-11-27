package com.wora.bffagendador.business;


import com.wora.bffagendador.business.dto.request.EnderecoDTORequest;
import com.wora.bffagendador.business.dto.request.LoginDTORequest;
import com.wora.bffagendador.business.dto.request.TelefoneDTORequest;
import com.wora.bffagendador.business.dto.request.UsuarioDTORequest;
import com.wora.bffagendador.business.dto.response.EnderecoDTOResponse;
import com.wora.bffagendador.business.dto.response.TelefoneDTOResponse;
import com.wora.bffagendador.business.dto.response.UsuarioDTOResponse;
import com.wora.bffagendador.business.dto.response.ViaCepDTOResponse;
import com.wora.bffagendador.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest request) {
        return usuarioClient.salvaUsuario(request);
    }

    public String loginUsuario(LoginDTORequest request) {
        return usuarioClient.login(request);
    }

    public UsuarioDTOResponse buscaUsuarioPorEmail(String email, String token) {
        return usuarioClient.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token) {
        usuarioClient.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest request) {
        return usuarioClient.atualizaDadosUsuario(request, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest request, String token) {
        return usuarioClient.atualizaEndereco(request, idEndereco, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest request, String token) {
        return usuarioClient.atualizaTelefone(request, idTelefone, token);
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest request) {
      return usuarioClient.cadastraEndereco(request, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest request) {
        return usuarioClient.cadastraTelefone(request, token);
    }

    public ViaCepDTOResponse buscarEnderecoPorCep(String cep) {
        return usuarioClient.buscaDadosCep(cep);
    }
}
