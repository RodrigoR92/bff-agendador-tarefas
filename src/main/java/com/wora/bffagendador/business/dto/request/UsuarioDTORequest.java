package com.wora.bffagendador.business.dto.request;

import com.wora.bffagendador.business.dto.response.EnderecoDTOResponse;
import com.wora.bffagendador.business.dto.response.TelefoneDTOResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTORequest {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDTOResponse> enderecos;
    private List<TelefoneDTOResponse> telefones;
}
