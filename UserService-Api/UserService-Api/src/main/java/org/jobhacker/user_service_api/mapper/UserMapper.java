package org.jobhacker.user_service_api.mapper;

import org.jobhacker.user_service_api.dto.UserDTO;
import org.jobhacker.user_service_api.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    // map from entity to dto
    UserDTO mapToDTO(User entity);

    // map from dto to entity
    User mapToEntity(UserDTO dto);
}
