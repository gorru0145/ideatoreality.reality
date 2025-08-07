package important.ideatoreality.reality.mapper;

import important.ideatoreality.reality.dto.Destinationdto;
import important.ideatoreality.reality.dto.UserDetailsdto;
import important.ideatoreality.reality.model.Destination;
import important.ideatoreality.reality.model.UserDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring",uses ={UserDetailsMapper.class})
public interface DestinationDataMapper {
    DestinationDataMapper INSTANCE= Mappers.getMapper(DestinationDataMapper.class);
    @Mapping(target = "mode", ignore = true)
    Destinationdto toDto(Destination destination);
    Destination toEntity(Destinationdto destinationdto);
    default Optional<Destinationdto> toOptionalDto(Optional<Destination> optional) {
        return optional.map(this::toDto);
    }
    List<Destinationdto> toDtoList(List<Destination> destinations);
    List<Destination> toEntityList(List<Destinationdto> dtos);
}
