package com.wora.bffagendador.business.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDTOResponse {

    private Long id;
    private String rua;
    private Long numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
}
