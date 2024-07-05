package com.caxs.minos.def;

/**
 * Created by lenovo on 2020/9/22.
 */
public class DBConst {
    /**
     * 数据库取数的一页数据的记录数，
     *
     */
    public final static int PAGE_RECORD = 800;
    /**
     * 批量保存的记录数
     */
    public final static int BATCH_SAVE_RECORDCOUNT = 100;
    public final static String DB2 = "DB2";			//db2数据库属性
    public final static String ORACLE = "ORACLE";	//oracle数据库属性

    /**
     *会计分录流水号
     */
    public final static String SEQENCE_NAME_SEQ_TX_NO = "seq_tx_no";
    /**
     * 交易流水
     */
    public final static String SEQENCE_NAME_TRANSACTION = "seq_txlog_no";
    public final static int SEQENCE_NAME_TRANSACTION_SEQ = 1000;	//序号名称
}
