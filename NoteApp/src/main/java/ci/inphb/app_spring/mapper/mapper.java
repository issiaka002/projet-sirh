package ci.inphb.app_spring.mapper;

import ci.inphb.app_spring.dto.EnseigantDtoRequest;
import ci.inphb.app_spring.dto.EnseigantDtoResponse;
import ci.inphb.app_spring.dto.PersonnelAdministratifDtoRequest;
import ci.inphb.app_spring.dto.PersonnelAdministratifDtoResponse;
import org.springframework.beans.BeanUtils;

public class mapper {

    public EnseigantDtoResponse enseigantRequestTOenseignantResponse(EnseigantDtoRequest enseigantDtoRequest){
        EnseigantDtoResponse enseigantDtoResponse = new EnseigantDtoResponse();
        BeanUtils.copyProperties(enseigantDtoRequest, enseigantDtoResponse);
        return enseigantDtoResponse;
    }

    public EnseigantDtoRequest enseigantDtoResponseTOenseignantRequest(EnseigantDtoResponse enseigantDtoResponse){
        EnseigantDtoRequest enseigantDtoRequest = new EnseigantDtoRequest();
        BeanUtils.copyProperties(enseigantDtoResponse, enseigantDtoRequest);
        return enseigantDtoRequest;
    }

    public PersonnelAdministratifDtoRequest personnelAdministratifRequestTOResponse(PersonnelAdministratifDtoResponse administratifDtoResponse){
        PersonnelAdministratifDtoRequest request = new PersonnelAdministratifDtoRequest();
        BeanUtils.copyProperties(administratifDtoResponse, request);
        return request;
    }

}
