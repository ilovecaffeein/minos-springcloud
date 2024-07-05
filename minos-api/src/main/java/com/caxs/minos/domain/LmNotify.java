package com.caxs.minos.domain;

public class LmNotify {
    private String seqNo;

    private String instuCde;

    private String noteBussTyp;

    private String noteTyp;

    private String noteDesc;

    private String noteTxt;

    private String autoInd;

    private String noteSts;

    private String lastChgDt;

    private String lastChgUsr;

    private String sendSts;

    private String dueDay;

    private String splitDay;

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo == null ? null : seqNo.trim();
    }

    public String getInstuCde() {
        return instuCde;
    }

    public void setInstuCde(String instuCde) {
        this.instuCde = instuCde == null ? null : instuCde.trim();
    }

    public String getNoteBussTyp() {
        return noteBussTyp;
    }

    public void setNoteBussTyp(String noteBussTyp) {
        this.noteBussTyp = noteBussTyp == null ? null : noteBussTyp.trim();
    }

    public String getNoteTyp() {
        return noteTyp;
    }

    public void setNoteTyp(String noteTyp) {
        this.noteTyp = noteTyp == null ? null : noteTyp.trim();
    }

    public String getNoteDesc() {
        return noteDesc;
    }

    public void setNoteDesc(String noteDesc) {
        this.noteDesc = noteDesc == null ? null : noteDesc.trim();
    }

    public String getNoteTxt() {
        return noteTxt;
    }

    public void setNoteTxt(String noteTxt) {
        this.noteTxt = noteTxt == null ? null : noteTxt.trim();
    }

    public String getAutoInd() {
        return autoInd;
    }

    public void setAutoInd(String autoInd) {
        this.autoInd = autoInd == null ? null : autoInd.trim();
    }

    public String getNoteSts() {
        return noteSts;
    }

    public void setNoteSts(String noteSts) {
        this.noteSts = noteSts == null ? null : noteSts.trim();
    }

    public String getLastChgDt() {
        return lastChgDt;
    }

    public void setLastChgDt(String lastChgDt) {
        this.lastChgDt = lastChgDt == null ? null : lastChgDt.trim();
    }

    public String getLastChgUsr() {
        return lastChgUsr;
    }

    public void setLastChgUsr(String lastChgUsr) {
        this.lastChgUsr = lastChgUsr == null ? null : lastChgUsr.trim();
    }

    public String getSendSts() {
        return sendSts;
    }

    public void setSendSts(String sendSts) {
        this.sendSts = sendSts == null ? null : sendSts.trim();
    }

    public String getDueDay() {
        return dueDay;
    }

    public void setDueDay(String dueDay) {
        this.dueDay = dueDay == null ? null : dueDay.trim();
    }

    public String getSplitDay() {
        return splitDay;
    }

    public void setSplitDay(String splitDay) {
        this.splitDay = splitDay == null ? null : splitDay.trim();
    }
}