package important.ideatoreality.reality.mapper;
import important.ideatoreality.reality.dto.PostCommentdto;
import important.ideatoreality.reality.model.PostComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PostDataMapper.class})
public interface PostCommentDataMapper {
    @Mapping(target = "post", ignore = true) // prevent infinite loop
    PostCommentdto toDto(PostComment postComment);

    // DTO to Entity
    //@Mapping(target = "post", ignore = true) // prevent infinite loop
    PostComment toEntity(PostCommentdto dto);

    @Mapping(target = "post", ignore = true)
    List<PostCommentdto> toDtoList(List<PostComment> comments);


    List<PostComment> toEntityList(List<PostCommentdto> dtos);


}