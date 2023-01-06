package at.fhtw.swen3.services.mapper;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-05T16:25:58+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class HopMapperImpl extends HopMapperDecorater implements HopMapper {

    private final HopMapper delegate;

    public HopMapperImpl() {
        this( new HopMapperImpl_() );
    }

    private HopMapperImpl(HopMapperImpl_ delegate) {
        super( delegate );
        this.delegate = delegate;
    }
}
