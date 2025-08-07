package important.ideatoreality.reality.mapper;

import important.ideatoreality.reality.dto.Modedto;
import important.ideatoreality.reality.dto.UserDetailsdto;
import important.ideatoreality.reality.model.Mode;
import important.ideatoreality.reality.model.UserDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;
@Mapper(componentModel = "spring",uses = {UserDetailsMapper.class}) // <-- IMPORTANT
public interface ModeDataMapper {

    ModeDataMapper INSTANCE= Mappers.getMapper(ModeDataMapper.class);
    Mode toEntity (Modedto dto);
    @Mapping(target = "destination", ignore = true)
    Modedto toDto (Mode mode);
    List<Modedto> toDtoList(List<Mode> modes);
    List<Mode> toEntityList(List<Modedto> dtos);

    default Optional<Modedto> toOptionalDto(Optional<Mode> optional) {
        return optional.map(this::toDto);
    }
}
