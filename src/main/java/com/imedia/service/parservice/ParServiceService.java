package com.imedia.service.parservice;

import com.imedia.model.BaseResponse;
import com.imedia.oracle.dao.ParServiceDAO;
import com.imedia.oracle.entity.ParService;
import com.imedia.oracle.entity.Provider;
import com.imedia.oracle.repository.ParServiceRepository;
import com.imedia.service.parservice.dto.ParServiceServiceDTO;
import com.imedia.service.parservice.model.*;
import com.imedia.service.provider.model.InactiveProviderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ParServiceService {
    public final ParServiceDAO parServiceDAO;
    public final ParServiceRepository parServiceRepository;
    public BaseResponse getListParService(GetParServiceRequest request){
        List<ParServiceServiceDTO> parServiceServiceDTO = parServiceDAO.getListService(request);
        List<GetParServiceResponse> getParServiceResponse = new ArrayList<>();
        for(ParServiceServiceDTO mapService : parServiceServiceDTO){
            GetParServiceResponse service = new GetParServiceResponse();
            service.setId(mapService.getId());
            service.setServiceName(mapService.getServiceName());
            service.setServiceType(mapService.getServiceType());
            service.setCreateDate(mapService.getCreateDate());
            service.setActive(mapService.getActive());
            getParServiceResponse.add(service);
        }
        return new BaseResponse(200, getParServiceResponse);
    }

    public BaseResponse createParService(CreateParServiceRequest request){
        ParService parService = new ParService();
        parService.setServiceName(request.getServiceName());
        parService.setServiceType(request.getServiceType());
        parService.setActive(request.getActive());
        parServiceRepository.save(parService);
        return new BaseResponse(200);
    }

    public BaseResponse updateParParent(UpdateParServiceRequest request){
        ParService parService = parServiceRepository.getById(request.getId());
        parService.setServiceName(request.getServiceNameEdit());
        parService.setServiceType(request.getServiceTypeEdit());
        parServiceRepository.save(parService);
        return new BaseResponse(200);
    }

    public BaseResponse setStatusParService(GetParServiceStatus request) {
        ParService parService = parServiceRepository.getById(request.getId());
        if (parService.getActive() == 1) {
            parService.setActive(0);
        } else {
            parService.setActive(1);
        }
        parServiceRepository.save(parService);
        return new BaseResponse(200);
    }

}
