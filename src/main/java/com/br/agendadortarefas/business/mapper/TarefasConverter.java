package com.br.agendadortarefas.business.mapper;

import com.br.agendadortarefas.business.dto.TarefasDTO;
import com.br.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefasConverter {


    TarefasEntity paraTarefasEntity(TarefasDTO tarefasDTO);

    TarefasDTO paraTarefasDTO(TarefasEntity tarefasEntity);

    List<TarefasEntity> paraTarefasEntity(List<TarefasDTO> dtos);

    List<TarefasDTO> paraTarefasDTO(List<TarefasEntity> entities);
}
