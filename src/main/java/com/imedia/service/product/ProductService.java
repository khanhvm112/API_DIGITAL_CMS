package com.imedia.service.product;

import com.imedia.model.BaseResponse;
import com.imedia.oracle.dao.ProductDAO;
import com.imedia.service.product.dto.ProductServiceDTO;
import com.imedia.service.product.model.GetProductRequest;
import com.imedia.service.product.model.GetProductRespone;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {
    private final ProductDAO productDAO;

    public BaseResponse getListProduct(GetProductRequest getProductRequest){
        List<ProductServiceDTO> productServiceDTO = productDAO.getListProduct(getProductRequest);
        List<GetProductRespone> getProductResponse = new ArrayList<>();
        for(ProductServiceDTO element : productServiceDTO){
            GetProductRespone product = new GetProductRespone();
            product.setId(element.getId());
            product.setProductName(element.getProduct_name());
            product.setProductValue(element.getProduct_value());
            product.setProviderName(element.getProvider_name());
            product.setServiceName(element.getService_name());
            product.setActive(element.getActive());
            getProductResponse.add(product);
        }
        return new BaseResponse(200, getProductResponse);
    }
//    public BaseResponse createProduct(){
//
//    }
}
