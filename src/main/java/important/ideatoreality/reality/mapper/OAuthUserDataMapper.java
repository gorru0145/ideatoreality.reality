package important.ideatoreality.reality.mapper;

import important.ideatoreality.reality.dto.OAuthUserDatadto;
import important.ideatoreality.reality.model.OAuthUserData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface OAuthUserDataMapper {

    OAuthUserDataMapper INSTANCE= Mappers.getMapper(OAuthUserDataMapper.class);

    OAuthUserDatadto toDto(OAuthUserData oauth);

    //Optional<OAuthUserDatadto> toOptionalDto(Optional<OAuthUserData> oauth);

    OAuthUserData toEntity(OAuthUserDatadto oauth);

    default Optional<OAuthUserDatadto> toOptionalDto(Optional<OAuthUserData> optional) {
        return optional.map(this::toDto);
    }

}
