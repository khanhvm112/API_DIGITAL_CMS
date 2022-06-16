package com.imedia.service.provider;

import com.imedia.model.BaseResponse;
import com.imedia.oracle.dao.ProviderDAO;
import com.imedia.service.provider.dto.ProviderServiceDTO;
import com.imedia.service.provider.dto.ProvinceServiceDTO;
import com.imedia.service.provider.enums.SubServiceTypeEnum;
import com.imedia.service.provider.model.GetProviderRequest;
import com.imedia.service.provider.model.GetProviderResponse;
import com.imedia.service.provider.model.GetProvinceRespone;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProvinceService {
    private final ProviderDAO providerDAO;
    public BaseResponse getListProvince(){
        List<ProvinceServiceDTO> providerServiceDTO = providerDAO.getListProvince();
        List<GetProvinceRespone> getProvinceResponse = new ArrayList<>();
        for(ProvinceServiceDTO element : providerServiceDTO) {
            GetProvinceRespone province = new GetProvinceRespone();
            province.setId(element.getId());
            province.setName(element.getName());
            getProvinceResponse.add(province);
        }
        return new BaseResponse(200, getProvinceResponse);
    }
}
