package com.cg.repository;

import com.cg.model.Deposit;
import com.cg.model.Transfer;
import com.cg.model.TransferHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    @Query("SELECT  NEW com.cg.model.TransferHistory(" +
            "    t.id, " +
            "    t.senderId," +
            "    sender.fullName," +
            "    t.recipientId," +
            "    recipient.fullName," +
            "    t.transferAmount," +
            "    t.fees," +
            "    t.feesAmount)" +
            "FROM Transfer  AS t " +
            "INNER JOIN Customer AS sender " +
            "ON sender.id = t.senderId\n" +
            "INNER JOIN Customer AS recipient " +
            "ON recipient.id = t.recipientId")
    List<TransferHistory> findAllTransfer();
}
