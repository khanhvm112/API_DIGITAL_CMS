package com.imedia.service.subservice;

import com.imedia.model.BaseResponse;
import com.imedia.oracle.dao.SubServiceDAO;
import com.imedia.oracle.entity.SubService;
import com.imedia.oracle.repository.SubServiceRepository;
import com.imedia.service.subservice.dto.SubServiceServiceDTO;
import com.imedia.service.subservice.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SubServiceService {
    private final SubServiceRepository subServiceRepository;
    private final SubServiceDAO subServiceDAO;

    public BaseResponse getListService(GetSubServiceRequest request){
        List<SubServiceServiceDTO> subServiceServiceDTO = subServiceDAO.getListService(request);
        List<GetSubServiceResponse> getSubServiceResponse = new ArrayList<>();
        for(SubServiceServiceDTO element : subServiceServiceDTO) {
            GetSubServiceResponse service = new GetSubServiceResponse();
            service.setId(element.getId());
            service.setSubserviceName(element.getSubserviceName());
            service.setTypeId(element.getTypeId());
            service.setCreateDate(element.getCreateDate());
            service.setUpdateDate(element.getUpdateDate());
            service.setUserName("Vũ Minh Khánh");
            service.setActive(element.getActive());
            getSubServiceResponse.add(service);
        }
        return new BaseResponse(200, getSubServiceResponse);
    }
    public BaseResponse createService(CreateSubServiceRequest request){
        SubService subService = new SubService();
        subService.setTypeId(request.getTypeId());
        subService.setActive(1);
        subService.setSubServiceName(request.getSubService_name());
        subServiceRepository.save(subService);
        return new BaseResponse(200);
    }
    public BaseResponse updateService(UpdateSubServiceRequest request){
        SubService subService = subServiceRepository.getById(request.getId());
        subService.setTypeId(request.getTypeId());
        subService.setActive(1);
        subService.setSubServiceName(request.getSubService_name());
        subServiceRepository.save(subService);
        return new BaseResponse(200);
    }

    public BaseResponse inactiveService(InactiveSubServiceRequest request){
        SubService subService = subServiceRepository.getById(request.getId());
        subService.setActive(0);
        subServiceRepository.save(subService);
        return new BaseResponse(200);
    }
}
