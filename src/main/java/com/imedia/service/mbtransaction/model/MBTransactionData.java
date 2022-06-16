package com.imedia.service.mbtransaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class MBTransactionData {
    private int numberOfRecords;
    private List<GetMBTransactionResponse> MBTransactionData;
}
