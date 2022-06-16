package com.imedia.service.parentprovider;

import com.imedia.model.BaseResponse;
import com.imedia.oracle.entity.ParentProvider;
import com.imedia.oracle.entity.Provider;
import com.imedia.oracle.repository.ParentProviderRepository;
import com.imedia.service.parentprovider.model.CreateParProviderRequest;
import com.imedia.service.provider.model.CreateProviderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ParentProviderService {
    private final ParentProviderRepository parentProviderRepository;

    public BaseResponse createParentProvider(CreateParProviderRequest request){
        ParentProvider parentProvider = new ParentProvider();
        parentProvider.setProviderCode(request.getProviderCode());
        parentProvider.setImage(request.getImage());
        parentProvider.setActive(request.getActive());
        parentProviderRepository.save(parentProvider);
        return new BaseResponse(200);
    }
}
