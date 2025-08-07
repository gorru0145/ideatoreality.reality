package important.ideatoreality.reality.mapper;

import important.ideatoreality.reality.dto.PostCommentdto;
import important.ideatoreality.reality.dto.UserPostdto;
import important.ideatoreality.reality.model.PostComment;
import important.ideatoreality.reality.model.User_Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface PostDataMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "comments",ignore = true)
    UserPostdto toDto(User_Post post);

    //@Mapping(target = "user", ignore = true)
    User_Post toEntity(UserPostdto dto);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "comments", ignore = true)
    List<UserPostdto> toDtoList(List<User_Post> posts);

    //@Mapping(target = "user", ignore = true)
    List<User_Post> toEntityList(List<UserPostdto> dtos);
}
