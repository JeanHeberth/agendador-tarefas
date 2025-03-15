package com.br.agendadortarefas.business.dto;

import com.br.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TarefasDTO {

    private String id;
    private String nomeTarefa;
    private String descricao;
    private LocalDateTime dataCriacao;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "America/Sao_Paulo")
    private LocalDateTime dataEvento;
    private String emailUsuario;
    private LocalDateTime dataAlteracao;
    private StatusNotificacaoEnum statusNotificacaoEnum;


    public LocalDateTime converterParaUTC(LocalDateTime data) {
        ZonedDateTime zdt = data.atZone(ZoneId.of("America/Sao_Paulo"));
        return zdt.toLocalDateTime();
    }
}
