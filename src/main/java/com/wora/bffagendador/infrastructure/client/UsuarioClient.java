package com.wora.bffagendador.infrastructure.client;

import com.wora.bffagendador.business.dto.request.EnderecoDTORequest;
import com.wora.bffagendador.business.dto.request.LoginDTORequest;
import com.wora.bffagendador.business.dto.request.TelefoneDTORequest;
import com.wora.bffagendador.business.dto.request.UsuarioDTORequest;
import com.wora.bffagendador.business.dto.response.EnderecoDTOResponse;
import com.wora.bffagendador.business.dto.response.TelefoneDTOResponse;
import com.wora.bffagendador.business.dto.response.UsuarioDTOResponse;
import com.wora.bffagendador.business.dto.response.ViaCepDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario_url}")
public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest request);

    @PostMapping("/login")
    String login(@RequestBody LoginDTORequest request);

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                                @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTOResponse atualizaDadosUsuario(@RequestBody UsuarioDTORequest request,
                                            @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest request,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest request,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest request,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest request,
                                         @RequestHeader("Authorization") String token);

    @GetMapping("/endereco/{cep}")
    ViaCepDTOResponse buscaDadosCep(@PathVariable("cep") String cep);
}
