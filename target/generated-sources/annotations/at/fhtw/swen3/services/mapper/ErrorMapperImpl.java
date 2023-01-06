package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.persistence.entities.ErrorEntity.ErrorEntityBuilder;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-05T16:25:58+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class ErrorMapperImpl implements ErrorMapper {

    @Override
    public Error entityToDto(ErrorEntity errorEntity) {
        if ( errorEntity == null ) {
            return null;
        }

        Error error = new Error();

        return error;
    }

    @Override
    public ErrorEntity dtoToDto(Error error) {
        if ( error == null ) {
            return null;
        }

        ErrorEntityBuilder errorEntity = ErrorEntity.builder();

        errorEntity.message( error.getMessage() );

        return errorEntity.build();
    }
}
