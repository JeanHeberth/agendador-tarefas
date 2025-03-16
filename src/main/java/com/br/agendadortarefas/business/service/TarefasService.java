package com.br.agendadortarefas.business.service;

import com.br.agendadortarefas.business.dto.TarefasDTO;
import com.br.agendadortarefas.business.mapper.TarefasConverter;
import com.br.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.br.agendadortarefas.infrastructure.repository.TarefaRepository;
import com.br.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.br.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum.*;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefaRepository tarefaRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(TarefasDTO tarefasDTO, String token) {
        String email = jwtUtil.extrairEmailDoToken(token.substring(7));
        tarefasDTO.setDataCriacao(LocalDateTime.now());
        tarefasDTO.setStatusNotificacaoEnum(PENDENTE);
        tarefasDTO.setEmailUsuario(email);

        TarefasEntity tarefaEntity = tarefasConverter.paraTarefasEntity(tarefasDTO);

        return tarefasConverter.paraTarefasDTO(
                tarefaRepository.save(tarefaEntity)
        );

    }

    public List<TarefasDTO> buscarTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal) {
        return tarefasConverter.paraTarefasDTO(
                tarefaRepository.findByDataEventoBetween(dataInicial, dataFinal));
    }

    public List<TarefasDTO> buscarTarefasPorEmail(String token) {
        String email = jwtUtil.extrairEmailDoToken(token.substring(7));
        return tarefasConverter.paraTarefasDTO(
                tarefaRepository.findByEmailUsuario(email));
    }

}
