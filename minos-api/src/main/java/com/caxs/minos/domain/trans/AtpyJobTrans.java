package com.caxs.minos.domain.trans;

import com.caxs.minos.domain.DeAtpyJobs;

import java.io.Serializable;

/**
 * Created by lenovo on 2020/9/21.
 */
public class AtpyJobTrans  extends DeAtpyJobs implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private boolean isNewFileSeq;
    private DeAtpyJobs job;

    /**
     * 记录数
     */
    private int recCnt = 0;

    public int getRecCnt() {
        return recCnt;
    }

    public void addRec() {
        recCnt++;
    }
    public DeAtpyJobs getJob() {
        return job;
    }

    public void setJob(DeAtpyJobs job) {
        this.job = job;
    }

    public AtpyJobTrans(boolean isNewFileSeq, DeAtpyJobs job) {
        super();
        this.isNewFileSeq = isNewFileSeq;
        this.job=job;
    }

    public boolean isNewFileSeq() {
        return isNewFileSeq;
    }

    public void setNewFileSeq(boolean isNewFileSeq) {
        this.isNewFileSeq = isNewFileSeq;
    }

    public String getAtpySeqNo() {
        return job.getAtpySeqNo();
    }

    public void setAtpySeqNo(String atpySeqNo) {
        job.setAtpySeqNo(atpySeqNo);
    }

    public String getBussTyp() {
        return job.getBussTyp();
    }

    public void setBussTyp(String bussTyp) {
        job.setBussTyp(bussTyp);
    }

    public String getBchCde() {
        return job.getBchCde();
    }

    public void setBchCde(String bchCde) {
        job.setBchCde(bchCde);
    }

    public String getCcyCde() {
        return job.getCcyCde();
    }

    public void setCcyCde(String ccyCde) {
        job.setCcyCde(ccyCde);
    }

    public String getAtpyDt() {
        return job.getAtpyDt();
    }

    public void setAtpyDt(String atpyDt) {
        job.setAtpyDt(atpyDt);
    }

    public Integer getJobCount() {
        return job.getJobCount();
    }

    public void setJobCount(Integer jobCount) {
        job.setJobCount(jobCount);
    }

    public String getAtpySts() {
        return job.getAtpySts();
    }

    public void setAtpySts(String atpySts) {
        job.setAtpySts(atpySts);
    }

    public String getAtpyexpSts() {
        return job.getAtpyexpSts();
    }

    public void setAtpyexpSts(String atpyexpSts) {
        job.setAtpyexpSts(atpyexpSts);
    }

    public String getAtpyToCorebankSts() {
        return job.getAtpyToCorebankSts();
    }

    public void setAtpyToCorebankSts(String atpyToCorebankSts) {
        job.setAtpyToCorebankSts(atpyToCorebankSts);
    }

    public String getAtpyexpUdpSts() {
        return job.getAtpyexpUdpSts();
    }

    public void setAtpyexpUdpSts(String atpyexpUdpSts) {
        job.setAtpyexpUdpSts(atpyexpUdpSts);
    }

    public String getStartTime() {
        return job.getStartTime();
    }

    public void setStartTime(String startTime) {
        job.setStartTime(startTime);
    }

    public String getEndTime() {
        return job.getEndTime();
    }

    public void setEndTime(String endTime) {
        job.setEndTime(endTime);
    }

    public String getUploadFile() {
        return job.getUploadFile();
    }

    public void setUploadFile(String uploadFile) {
        job.setUploadFile(uploadFile);
    }

    public Integer getUpRowCount() {
        return job.getUpRowCount();
    }



    public void setUpRowCount(Integer upRowCount) {
        job.setUpRowCount(upRowCount);
    }

    public String getDownloadFile() {
        return job.getDownloadFile();
    }

    public void setDownloadFile(String downloadFile) {
        job.setDownloadFile(downloadFile);
    }

    public Integer getDownRowCount() {
        return job.getDownRowCount();
    }

    public void setDownRowCount(Integer downRowCount) {
        job.setDownRowCount(downRowCount);
    }

    public String getFileSeq() {
        return job.getFileSeq();
    }

    public void setFileSeq(String fileSeq) {
        job.setFileSeq(fileSeq);
    }
}
