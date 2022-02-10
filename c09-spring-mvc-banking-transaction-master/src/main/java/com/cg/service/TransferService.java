package com.cg.service;

import com.cg.model.Transfer;
import com.cg.model.TransferHistory;
import com.cg.model.Withdraw;

import java.util.List;

public interface TransferService extends IGeneralService<Transfer>{
    List<TransferHistory> findAllTransfer();
}
