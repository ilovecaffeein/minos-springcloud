package com.caxs.minos.domain;

public class LmExternalFile {
    private String outChn;

    private String outDesc;

    private String crtDt;

    private String bankCde;

    private String lmpmshdFileForm;

    private Long lmpmshdFileCont;

    private String lmpmshdFileInd;

    private String repayFileForm;

    private Long repayFileCont;

    private String repayFileInd;

    private String fileIp;

    private String filePort;

    private String userName;

    private String userPasswd;

    private String filePath;

    private String retrunFilePath;

    private String dataSts;

    private String downInd;

    public String getOutChn() {
        return outChn;
    }

    public void setOutChn(String outChn) {
        this.outChn = outChn == null ? null : outChn.trim();
    }

    public String getOutDesc() {
        return outDesc;
    }

    public void setOutDesc(String outDesc) {
        this.outDesc = outDesc == null ? null : outDesc.trim();
    }

    public String getCrtDt() {
        return crtDt;
    }

    public void setCrtDt(String crtDt) {
        this.crtDt = crtDt == null ? null : crtDt.trim();
    }

    public String getBankCde() {
        return bankCde;
    }

    public void setBankCde(String bankCde) {
        this.bankCde = bankCde == null ? null : bankCde.trim();
    }

    public String getLmpmshdFileForm() {
        return lmpmshdFileForm;
    }

    public void setLmpmshdFileForm(String lmpmshdFileForm) {
        this.lmpmshdFileForm = lmpmshdFileForm == null ? null : lmpmshdFileForm.trim();
    }

    public Long getLmpmshdFileCont() {
        return lmpmshdFileCont;
    }

    public void setLmpmshdFileCont(Long lmpmshdFileCont) {
        this.lmpmshdFileCont = lmpmshdFileCont;
    }

    public String getLmpmshdFileInd() {
        return lmpmshdFileInd;
    }

    public void setLmpmshdFileInd(String lmpmshdFileInd) {
        this.lmpmshdFileInd = lmpmshdFileInd == null ? null : lmpmshdFileInd.trim();
    }

    public String getRepayFileForm() {
        return repayFileForm;
    }

    public void setRepayFileForm(String repayFileForm) {
        this.repayFileForm = repayFileForm == null ? null : repayFileForm.trim();
    }

    public Long getRepayFileCont() {
        return repayFileCont;
    }

    public void setRepayFileCont(Long repayFileCont) {
        this.repayFileCont = repayFileCont;
    }

    public String getRepayFileInd() {
        return repayFileInd;
    }

    public void setRepayFileInd(String repayFileInd) {
        this.repayFileInd = repayFileInd == null ? null : repayFileInd.trim();
    }

    public String getFileIp() {
        return fileIp;
    }

    public void setFileIp(String fileIp) {
        this.fileIp = fileIp == null ? null : fileIp.trim();
    }

    public String getFilePort() {
        return filePort;
    }

    public void setFilePort(String filePort) {
        this.filePort = filePort == null ? null : filePort.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd == null ? null : userPasswd.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getRetrunFilePath() {
        return retrunFilePath;
    }

    public void setRetrunFilePath(String retrunFilePath) {
        this.retrunFilePath = retrunFilePath == null ? null : retrunFilePath.trim();
    }

    public String getDataSts() {
        return dataSts;
    }

    public void setDataSts(String dataSts) {
        this.dataSts = dataSts == null ? null : dataSts.trim();
    }

    public String getDownInd() {
        return downInd;
    }

    public void setDownInd(String downInd) {
        this.downInd = downInd == null ? null : downInd.trim();
    }
}