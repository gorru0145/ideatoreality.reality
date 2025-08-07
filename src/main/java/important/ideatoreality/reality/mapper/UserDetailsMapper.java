package important.ideatoreality.reality.mapper;

import important.ideatoreality.reality.dto.OAuthUserDatadto;
import important.ideatoreality.reality.dto.UserDetailsdto;
import important.ideatoreality.reality.model.OAuthUserData;
import important.ideatoreality.reality.model.UserDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserDetailsMapper {
    UserDetailsMapper INSTANCE= Mappers.getMapper(UserDetailsMapper.class);

    @Mapping(target = "posts", ignore = true)
    @Mapping(target = "comments", ignore = true)
    UserDetailsdto toDto(UserDetails userDetails);
    UserDetails toEntity(UserDetailsdto userDetailsdto);

    default Optional<UserDetailsdto> toOptionalDto(Optional<UserDetails> optional) {
        return optional.map(this::toDto);
    }
    @Mapping(target = "posts", ignore = true)
    @Mapping(target = "comments", ignore = true)
    List<UserDetailsdto> toDtoList(List<UserDetails> users);
    List<UserDetails> toEntityList(List<UserDetailsdto> dtos);

}