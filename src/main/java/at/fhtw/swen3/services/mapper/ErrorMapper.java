package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.ErrorEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ErrorMapper {
    Error entityToDto(ErrorEntity errorEntity);
    ErrorEntity dtoToDto(Error error);
}
