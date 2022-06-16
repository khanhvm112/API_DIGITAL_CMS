package com.imedia.service.mbtransaction;

import com.imedia.model.BaseResponse;
import com.imedia.oracle.dao.MBTransactionDAO;
import com.imedia.service.mbtransaction.dto.MBTransactionDTO;
import com.imedia.service.mbtransaction.enums.ParServiceEnum;
import com.imedia.service.mbtransaction.enums.SubServiceEnum;
import com.imedia.service.mbtransaction.model.MBTransactionData;
import com.imedia.service.mbtransaction.model.GetMBTransactionRequest;
import com.imedia.service.mbtransaction.model.GetMBTransactionResponse;
import com.imedia.service.provider.enums.SubServiceTypeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MBTransactionService {
    private final MBTransactionDAO mbTransactionDAO;
    public BaseResponse getListMBTransaction(GetMBTransactionRequest request){
        List<MBTransactionDTO> mbTransactionDTO = mbTransactionDAO.getListMBTransaction(request);
        List<GetMBTransactionResponse> getMBTransactionResponse = new ArrayList<>();
        for(MBTransactionDTO mapMBTransaction : mbTransactionDTO) {
            GetMBTransactionResponse mbTransaction = new GetMBTransactionResponse();
            mbTransaction.setId(mapMBTransaction.getId());
            mbTransaction.setService(ParServiceEnum.valueOf(mapMBTransaction.getServiceId()).name);
            mbTransaction.setSubService(SubServiceEnum.valueOf(mapMBTransaction.getSubServiceId()).name);
            mbTransaction.setCreateDate(mapMBTransaction.getCreateDate());
            mbTransaction.setPhone(mapMBTransaction.getPhone());
            String[] productName = mapMBTransaction.getProductName().split("\\s");
            mbTransaction.setProductName(productName[0]);
            mbTransaction.setProductValue(mapMBTransaction.getProductValue());
            mbTransaction.setEmail(mapMBTransaction.getEmail());
//            mbTransaction.setPhoneType(mapMBTransaction.getPhoneType());
            if(mapMBTransaction.getPhoneType() == null){
                mbTransaction.setPhoneType("");
            }else if(mapMBTransaction.getPhoneType() == 1){
                mbTransaction.setPhoneType("Trả trước");
            }else {
                mbTransaction.setPhoneType("Trả sau");
            }
            mbTransaction.setQuantity(mapMBTransaction.getQuantity());
            mbTransaction.setTransactionId(mapMBTransaction.getTransactionId());
            mbTransaction.setCif(mapMBTransaction.getCif());
            mbTransaction.setAmount(mapMBTransaction.getAmount());
            mbTransaction.setHolaTransactionCode(mapMBTransaction.getHolaTransactionCode());
            mbTransaction.setHolaPhone(mapMBTransaction.getHolaPhone());
            switch (mapMBTransaction.getStatus()){
                case "1":
                    mbTransaction.setStatus("Thanh toán thất bại");
                    break;
                case "2":
                    mbTransaction.setStatus("Pending");
                    break;
                case "3":
                    mbTransaction.setStatus("Thanh toán thành công");
                    break;
                case "4":
                    mbTransaction.setStatus("Đã thực hiện giao dịch Hola");
                    break;
            }
            getMBTransactionResponse.add(mbTransaction);
        }
        return new BaseResponse(200, new MBTransactionData(123, getMBTransactionResponse));
    }
}
