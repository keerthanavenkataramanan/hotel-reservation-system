package hotel_reservation;

public class Customer {
	private String csId;
    private int roomNo;
    private String csName;
    private int CsCost;
    private int CsMeal;
    private int CsMealcost;
    private int total;

    public String getCsId() {
        return csId;
    }

    
    public void setCsId(String csId) {
        this.csId = csId;
    }

    public int getRoomNo() {
        return roomNo;
    }

    
    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
    

  
    public String getCsName() {
        return csName;
    }

    
    public void setCsName(String csName) {
        this.csName = csName;
    }


	public int getCsCost() {
		return CsCost;
	}


	public void setCsCost(int csCost) {
		CsCost = csCost;
	}


	public int getCsMeal() {
		return CsMeal;
	}


	public void setCsMeal(int csMeal) {
		CsMeal = csMeal;
	}


	public int getCsMealcost() {
		return CsMealcost;
	}


	public void setCsMealcost(int csMealcost) {
		CsMealcost = csMealcost;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	




    
    
}
