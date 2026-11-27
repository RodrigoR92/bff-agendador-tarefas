package com.wora.bffagendador.business;

import com.wora.bffagendador.business.dto.request.LoginDTORequest;
import com.wora.bffagendador.business.dto.response.TarefaDTOResponse;
import com.wora.bffagendador.business.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CronService {

    private final TarefaService tarefaService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")
    public void buscarTarefasProximaHora() {
        String token = login(converterParaRquestDTO());
        log.info("Iniciada a busca de tarefas");
        LocalDateTime horaAtual = LocalDateTime.now();
        LocalDateTime horafutura = LocalDateTime.now().plusHours(1);

        List<TarefaDTOResponse> listaTarefas = tarefaService.buscaTarefaAgendadaPorPeriodo(
                                                    horaAtual, horafutura, token);
        log.info("Tarefa encontrada: " + listaTarefas);

        listaTarefas.forEach(tarefa -> {emailService.enviarEmail(tarefa);
            log.info("Email enviado para o usuario: " + tarefa);
        tarefaService.alteraStatus(StatusNotificacaoEnum.NOTIFICADO, tarefa.getId(),
                token);});
        log.info("Finalizada a busca e notificação de tarefas");
    }

    public String login(LoginDTORequest request) {
        return usuarioService.loginUsuario(request);
    }

    public LoginDTORequest converterParaRquestDTO() {
        return LoginDTORequest.builder()
                .email(email)
                .senha(senha)
                .build();
    }
}
