package com.sandeep.beans;

import java.sql.Timestamp;
import java.util.UUID;

// enum txType {
//     DEPOSIT, WITHDRAW, TRANSFER
// }

public class Transaction {
    private UUID txId;
    private Timestamp tx_timestamp;
    private int amount;
    private String transactionType;
    private int sender;
    private int receiver;

    public Transaction(UUID txId, Timestamp tx_timestamp, int amount, String transactionType, int sender,
            int receiver) {
        this.txId = txId;
        this.tx_timestamp = tx_timestamp;
        this.amount = amount;
        this.transactionType = transactionType;
        this.sender = sender;
        this.receiver = receiver;
    }

    public UUID getTxId() {
        return txId;
    }

    public void setTxId(UUID txId) {
        this.txId = txId;
    }

    public Timestamp getTxTimestamp() {
        return tx_timestamp;
    }

    public void setTxTimestamp(Timestamp txTimestamp) {
        this.tx_timestamp = txTimestamp;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTxType() {
        return transactionType;
    }

    public void setTxType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }
}