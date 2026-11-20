package com.wora.bffagendador.business.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDTORequest {

    private String nome;
    private String senha;
}
