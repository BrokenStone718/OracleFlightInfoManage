package User;

public class Flight {
	private String HBH;
	private String HZL;
	private String HJT;
	private String JZXM;
	private String SFYW;
	private String YJFXSJ;
	private String SFCS;
	private String MDD;
	public String getHJT() {
		return HJT;
	}
	public void setHJT(String hJT) {
		HJT = hJT;
	}
	public String getHBH() {
		return HBH;
	}
	public void setHBH(String hBH) {
		HBH = hBH;
	}
	public String getHZL() {
		return HZL;
	}
	public void setHZL(String hZL) {
		HZL = hZL;
	}
	public String getJZXM() {
		return JZXM;
	}
	public void setJZXM(String jZXM) {
		JZXM = jZXM;
	}
	public String getSFYW() {
		return SFYW;
	}
	public void setSFYW(String sFYW) {
		SFYW = sFYW;
	}
	public String getYJFXSJ() {
		return YJFXSJ;
	}
	public void setYJFXSJ(String yJFXSJ) {
		YJFXSJ = yJFXSJ;
	}
	public String getSFCS() {
		return SFCS;
	}
	public void setSFCS(String sFCS) {
		SFCS = sFCS;
	}
	public String getMDD() {
		return MDD;
	}
	public void setMDD(String mDD) {
		MDD = mDD;
	}
	

	@Override
	public String toString() {
		return "Flight [HBH=" + HBH + ", HZL=" + HZL + ", HJT=" + HJT + ", JZXM=" + JZXM + ", SFYW=" + SFYW
				+ ", YJFXSJ=" + YJFXSJ + ", SFCS=" + SFCS + ", MDD=" + MDD + "]";
	}
	public Flight(String hBH, String hZL, String hJT, String jZXM, String sFYW, String yJFXSJ, String sFCS,String mDD) {
		super();
		HBH = hBH;
		HZL = hZL;
		HJT = hJT;
		JZXM = jZXM;
		SFYW = sFYW;
		YJFXSJ = yJFXSJ;
		SFCS = sFCS;
		MDD = mDD;
	}
	public Flight() {};

}
