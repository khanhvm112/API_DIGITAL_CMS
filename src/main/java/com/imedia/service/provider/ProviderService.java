package com.imedia.service.provider;

import com.imedia.model.BaseResponse;
import com.imedia.oracle.dao.ProviderDAO;
import com.imedia.oracle.entity.Provider;
import com.imedia.oracle.repository.ProviderRepository;
import com.imedia.service.provider.dto.ProviderServiceDTO;
import com.imedia.service.provider.enums.SubServiceTypeEnum;
import com.imedia.service.provider.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProviderService {
    private final ProviderRepository providerRepository;
    private final ProviderDAO providerDAO;

    public BaseResponse getListProvider(GetProviderRequest request){
        List<ProviderServiceDTO> providerServiceDTO = providerDAO.getListProvider(request);
        List<GetProviderResponse> getProviderResponse = new ArrayList<>();
        for(ProviderServiceDTO element : providerServiceDTO) {
            GetProviderResponse provider = new GetProviderResponse();
            provider.setId(element.getId());
            provider.setPid(element.getPid());
            provider.setActive(element.getActive());
            provider.setProvider_code(element.getProvider_code());
            provider.setProvider_name(element.getProvider_name());
            SubServiceTypeEnum serviceType = SubServiceTypeEnum.valueOf(element.getSub_type());
            provider.setSub_type(serviceType.name);
            provider.setServiceName(element.getService_name());
            provider.setCreate_date(element.getCreate_date());
            provider.setUpdate_date(element.getUpdate_date());
            provider.setImage(element.getImage());
            provider.setProvince(element.getProvince());
            provider.setProvince_id(element.getProvince_id());
            provider.setPrepaid_syntax(element.getPrepaid_syntax());
            provider.setPostpaid_syntax(element.getPostpaid_syntax());
            provider.setItopup_id(element.getItopup_id());
            getProviderResponse.add(provider);
        }
        return new BaseResponse(200, getProviderResponse);
    }
    public BaseResponse createProvider(CreateProviderRequest request){
        Provider provider = new Provider();
        provider.setPid(request.getPid());
        provider.setActive(1);
        provider.setProviderCode(request.getProvider_code());
        provider.setProviderName(request.getProvider_name());
        provider.setSubType(request.getSub_type());
        provider.setType(request.getType());
        provider.setImage(request.getImage());
        provider.setProvince(request.getProvince());
        provider.setProvinceId(request.getProvince_id());
        provider.setPrepaidSyntax(request.getPrepaid_syntax());
        provider.setPostpaidSyntax(request.getPostpaid_syntax());
        provider.setItopupid(request.getItopup_id());
        providerRepository.save(provider);
        return new BaseResponse(200);
    }
    public BaseResponse updateProvider(UpdateProviderRequest request){
        Provider provider = providerRepository.getById(request.getId());
        if(request.getId() != null){
            provider.setPid(request.getId());
        }
        provider.setActive(1);
        if(request.getProvider_code() != null && !request.getProvider_code().isEmpty()){
            provider.setProviderCode(request.getProvider_code());
        }
        if(request.getProvider_name() != null && !request.getProvider_name().isEmpty()){
            provider.setProviderName(request.getProvider_name());
        }
//      provider.setProviderName(StringUtils.hasText(request.getProvider_name()) ? request.getProvider_name() : "");
        if(request.getSub_type() != null){
            provider.setSubType(request.getSub_type());
        }
        if(request.getType() != null) {
            provider.setType(request.getType());
        }
        if(request.getImage() != null && !request.getImage().isEmpty()){
            provider.setImage(request.getImage());
        }
        if(request.getProvince() != null && !request.getProvince().isEmpty()){
            provider.setProvince(request.getProvince());
        }
        if(request.getProvince_id() != null){
            provider.setProvinceId(request.getProvince_id());
        }
        if(request.getPrepaid_syntax() != null && !request.getPrepaid_syntax().isEmpty()){
            provider.setPrepaidSyntax(request.getPrepaid_syntax());
        }
        if(request.getPostpaid_syntax() != null && !request.getPostpaid_syntax().isEmpty()){
            provider.setPostpaidSyntax(request.getPostpaid_syntax());
        }
        if(request.getItopup_id() != null){
            provider.setItopupid(request.getItopup_id());
        }
        providerRepository.save(provider);
        return new BaseResponse(200);
    }
    public BaseResponse inactiveProvider(InactiveProviderRequest request){
        Provider provider = providerRepository.getById(request.getId());
        provider.setActive(0);
        providerRepository.save(provider);
        return new BaseResponse(200);
    }
}
