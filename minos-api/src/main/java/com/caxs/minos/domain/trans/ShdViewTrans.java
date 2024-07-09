package com.caxs.minos.domain.trans;

/**
 * ShdView entity.
 */
public class ShdViewTrans implements java.io.Serializable {
	   private static final long serialVersionUID = 7607704161124404623L;
		
	   Integer psPerdNo;
	   String psDueDt;
	   double psInstmAmt = 0.0D;
	   double psPrcpAmt = 0.0D;
	   double psNormIntAmt = 0.0D;
	   double psIntRate = 0.0D;
	   double psOdIntRate = 0.0D;
	   double psRemPrcp = 0.0D;
		
		public Integer getPsPerdNo() {
			return psPerdNo;
		}
	
		public void setPsPerdNo(Integer psPerdNo) {
			this.psPerdNo = psPerdNo;
		}
	
		public String getPsDueDt() {
			return psDueDt;
		}
	
		public void setPsDueDt(String psDueDt) {
			this.psDueDt = psDueDt;
		}
	
		public double getPsInstmAmt() {
			return psInstmAmt;
		}
	
		public void setPsInstmAmt(double psInstmAmt) {
			this.psInstmAmt = psInstmAmt;
		}
	
		public double getPsPrcpAmt() {
			return psPrcpAmt;
		}
	
		public void setPsPrcpAmt(double psPrcpAmt) {
			this.psPrcpAmt = psPrcpAmt;
		}
	
		public double getPsNormIntAmt() {
			return psNormIntAmt;
		}
	
		public void setPsNormIntAmt(double psNormIntAmt) {
			this.psNormIntAmt = psNormIntAmt;
		}
	
		public double getPsIntRate() {
			return psIntRate;
		}
	
		public void setPsIntRate(double psIntRate) {
			this.psIntRate = psIntRate;
		}
	
		public double getPsOdIntRate() {
			return psOdIntRate;
		}
	
		public void setPsOdIntRate(double psOdIntRate) {
			this.psOdIntRate = psOdIntRate;
		}
	
		public double getPsRemPrcp() {
			return psRemPrcp;
		}
	
		public void setPsRemPrcp(double psRemPrcp) {
			this.psRemPrcp = psRemPrcp;
		}
	
		public ShdViewTrans(){
		}
		
		public ShdViewTrans(Integer psPerdNo, String psDueDt, double psInstmAmt,
		    double psPrcpAmt, double psNormIntAmt, double psIntRate, double psOdIntRate, double psRemPrcp){
		    this.psPerdNo = psPerdNo;
		    this.psDueDt = psDueDt;
		    this.psInstmAmt = psInstmAmt;
		    this.psPrcpAmt = psPrcpAmt;
		    this.psNormIntAmt = psNormIntAmt;
		    this.psIntRate = psIntRate;
		    this.psOdIntRate = psOdIntRate;
		    this.psRemPrcp = psRemPrcp;
		 }
}