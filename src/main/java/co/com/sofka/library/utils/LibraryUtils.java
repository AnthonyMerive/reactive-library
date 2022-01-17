package co.com.sofka.library.utils;

import co.com.sofka.library.dtos.ResourceDTO;
import co.com.sofka.library.models.Resource;
import org.springframework.beans.BeanUtils;

public class LibraryUtils {

    public static ResourceDTO modelToDTO(Resource resource){
        ResourceDTO resourceDTO = new ResourceDTO();
        BeanUtils.copyProperties(resource, resourceDTO);

        return resourceDTO;
    }

    public static Resource DTOToModel(ResourceDTO resourceDTO){
        Resource resource = new Resource();
        BeanUtils.copyProperties(resourceDTO, resource);

        return resource;
    }

}
