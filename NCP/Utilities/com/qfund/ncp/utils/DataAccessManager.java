package com.qfund.ncp.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;




import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@SuppressWarnings("unused")
public class DataAccessManager {

	String dbUrl = "jdbc:oracle:thin:@192.168.2.243:1521:QFUNDUAT3";
	String username = "NCP_DL_AUTOMATION";
	String password = "NCP_DL_AUTOMATION";
	Connection con = null;
	ResultSet resultSet;
	Statement stmt = null;
	String query;
	String commit="commit";
	static ExtentTest test;
	String isEnabled;
	String isProcessed;
	public void participationProc(String loanNumber,ExtentTest test)
			throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");		
		con = DriverManager.getConnection(dbUrl, username, password);
		query = "{CALL PROC_BNK_LOAN_PARTICIPATION(?)}";
		CallableStatement stmt = con.prepareCall(query);		
		stmt.setInt(1, Integer.parseInt(loanNumber));
		//stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
		stmt.execute();
		test.log(LogStatus.PASS, "Loan Participation Procedure Language for ILP  ran successfully");	}
	
	@SuppressWarnings("rawtypes")
	public void ACHFileCreation(ExtentTest test) throws ClassNotFoundException, SQLException, InterruptedException{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(dbUrl, username, password);
		stmt=con.createStatement();
		
		
		String enabledTT="SELECT IS_ENABLED,IS_PROCESSED FROM SCHEDULE_ATTR WHERE SCHEDULE_ID=?";
		ArrayList list = executePreparedQuery(con, enabledTT, new String[] {"4502"}, new int[] {Types.INTEGER});
		
		
		if(isListHaveData(list)){
			
			String isEnabled = ((String[]) list.get(0))[0];
			String isProcessed=((String[]) list.get(0))[1];
			
			System.out.println("isEnabled: "+isEnabled);
			System.out.println("isProcessed: "+isProcessed);
			
		
				
				String updateIsProcessed="Update Schedule_Attr set IS_PROCESSED='NOP' where SCHEDULE_ID='4502'";
	
				int executed = stmt.executeUpdate(updateIsProcessed);
				con.commit();

				if(executed==1){
					System.out.println("Processed to NOP 4502 Schedule");	
				} else {
					System.out.println("Not Processed to NOP 4502 Schedule");
				}
				
				boolean isExecute = true;
				while(isExecute){
					Thread.sleep(10000);
 					
					ArrayList checkList = executePreparedQuery(con, enabledTT, new String[] {"4502"}, new int[] {Types.INTEGER});
					if(isListHaveData(checkList)){
						String isProcessedCheck = ((String[]) checkList.get(0))[1];
						System.out.println("After File Creation "+isProcessedCheck);
						if(isProcessedCheck.equalsIgnoreCase("PRO") ){
							System.out.println("After NOP File Creation"+isProcessedCheck);
							isExecute = false;
						}					
			}
		}		
	}
}
	
public void processDateReDirect(ExtentTest test) throws Exception{
	

		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(dbUrl, username, password);

		stmt=con.createStatement();
	
 String storeDateChange="update CA_SS_STORE_DATE set ST_DATE='22-JUL-19' where LOC_ID=10005";

		 stmt.executeUpdate(storeDateChange);
		 con.commit();
		 System.out.println("Changed store date");
		 test.log(LogStatus.PASS, "Changed stored date to its original date i.e 22/July/2019");
		
}

public void GBPayments(ExtentTest test,String loanNumber) throws Exception{
	String bo_code=null;
	String paymentAcntNo=null;
	String ssn=null;
	
	Class.forName("oracle.jdbc.driver.OracleDriver");

	con = DriverManager.getConnection(dbUrl, username, password);

	PreparedStatement pstmt=con.prepareStatement("select BO_CODE from BO_IN_APP_QUEUE where APP_NO=?");
	
	pstmt.setString(1, loanNumber);
	ResultSet rs=pstmt.executeQuery();
	while(rs.next()){
		bo_code=rs.getString(1);
		System.out.println(bo_code);
	}
	PreparedStatement pstmt1=con.prepareStatement("select PAYMENT_ACCT_NO,SSN from BO_MASTER where BO_CODE=?");
	pstmt1.setString(1, bo_code);
	ResultSet rs1=pstmt1.executeQuery();
	while(rs1.next()){
		paymentAcntNo=rs1.getString(1);
		System.out.println(paymentAcntNo);
		ssn=rs1.getString(2);
		System.out.println(ssn);
	}
	String last7digits=paymentAcntNo.substring(paymentAcntNo.length()-7, paymentAcntNo.length());
	System.out.println(last7digits);
	
	String pmntlog="Insert into LOANS_PMNT_DETAIL_Log (SEQ_NO,PMT_ACCOUNT_NBR,NAME,COMPANY_NAME,COMPANY_ID,TRACE_NBR,PAYMENT_AMT,PAYMENT_DATE,CUSTOMER_ACCOUNT_NBR,SSN,LOAN_CODE,LAST_NAME,FIRST_NAME,STATUS,DATE_CREATED,CREATED_BY,DATE_UPDATED,UPDATED_BY,FILE_ID,PAYMENT_TYPE,PAYMENT_STATUS,COMMENTS,BILL_PAY_REF_CODE,CORRECTION_DATE) "
			+ "                               values (410790,'1003749','Welch Quiana','Amazon Services','2A109383K9','91000015887900',0.01,to_date('03-MAY-19 12:00:00 AM','DD-MON-RR HH:MI:SS AM'),'5501307911','311828055','23661972','WELCH','QUIANA','NOP',to_date('06-MAY-19 09:39:47 AM','DD-MON-RR HH:MI:SS AM'),1,to_date('06-MAY-19 09:39:47 AM','DD-MON-RR HH:MI:SS AM'),1,15631,'DUP','SUCC',null,'91000015887900T190503',null);";
	//String query="select PAYMENT_ACCT_NO,SSN from BO_MASTER where BO_CODE=?;";

	// con.commit();
	
	
}


	public static void main(String[] args) throws Exception {
		DataAccessManager dam=new DataAccessManager();
		//dam.processDateReDirect(test);
		//final Random randomGenerator = new Random();
		//System.out.println(randomGenerator.nextInt(10000000));
		dam.GBPayments(test,"23673045");
		
	}
	
	//----------------------
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList executePreparedQuery(Connection con, String query,final String[] data,
			final int[] dataType) throws SQLException {
		
		final ArrayList alValues = new ArrayList();
		ResultSet rsResult = null;
		String[] strRow = null;
		int j = 0;
		
		PreparedStatement pstmt = con.prepareStatement(query);
		if ((data != null) && (data.length > 0)) {
			for (int i = 0; i < data.length; i++) {
				switch (dataType[i]) {
					case Types.VARCHAR:
						pstmt.setString(i + 1, data[i]);
						break;

					case Types.INTEGER:
						pstmt.setLong(i + 1, Long.parseLong(data[i]));
						break;

					case Types.DOUBLE:
						pstmt.setDouble(i + 1, Double.parseDouble(data[i]));
						break;

					case Types.TIMESTAMP:
						pstmt.setString(i + 1, data[i]);
						break;
					default:
						pstmt.setString(i + 1, data[i]);
				}
			}
		}

		rsResult = pstmt.executeQuery();
		
		if (rsResult != null) {
			final int iNumColumns = rsResult.getMetaData().getColumnCount();

			while (rsResult.next()) {
				strRow = new String[iNumColumns];

				for (int i = 0; i < iNumColumns; i++) {
					j = i + 1;
					strRow[i] = rsResult.getString(j);
				}

				alValues.add(strRow);
			}
		}
		return alValues;
	}
	
	@SuppressWarnings("rawtypes")
	public int executeUpdate(Connection con, String query,final String[] data,
			final int[] dataType) throws SQLException {
		
		final ArrayList alValues = new ArrayList();
		ResultSet rsResult = null;
		String[] strRow = null;
		int j = 0;
		
		PreparedStatement pstmt = con.prepareStatement(query);
		if ((data != null) && (data.length > 0)) {
			for (int i = 1; i <= data.length; i++) {
				if (dataType[i - 1] == Types.VARCHAR) {
					pstmt.setString(i, data[i - 1]);
				} else if (dataType[i - 1] == Types.TIMESTAMP) {
					if ((data[i - 1] != null) && !data[i - 1].equals("")) {
						pstmt.setTimestamp(i, Timestamp.valueOf(data[i - 1]));
					} else {
						pstmt.setString(i, data[i - 1]);
					}
				} else if (dataType[i - 1] == Types.INTEGER) {
					pstmt.setLong(i, Long.parseLong(data[i - 1]));
				} else if (dataType[i - 1] == Types.DOUBLE) {
					pstmt.setDouble(i, Double.parseDouble(data[i - 1]));
				} else {
					pstmt.setString(i, data[i - 1]);
				}
			}
		}

		return pstmt.executeUpdate();
	}
	
	public ResultSet executeQuery(Connection con, String query, String[] parms) throws SQLException {
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(query);
		return rs;
	}

	public int executeUpdate11(Connection con, String query) throws SQLException {
		Statement statement = con.createStatement();
		int count = statement.executeUpdate(query);
		return count;
	}

	public Connection openConnection() {
		Connection connection = null;		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = (Connection) DriverManager.getConnection(dbUrl, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean isListHaveData(List alist) {
        boolean flag = false;
        if(alist != null && !alist.isEmpty()) {
        	flag = true;
        }
        return flag;
    }
	public void promoCodeUpdate(ExtentTest test) throws Exception{
		

		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(dbUrl, username, password);

		stmt=con.createStatement();
	
 String promoCode="update DL_OFFER_CODE_CONFIG set IS_ACTIVE='Y' where OFFER_CODE='3D8708'";

		 stmt.executeUpdate(promoCode);
		 con.commit();
		 System.out.println("promoCode updated");		
}
	
	public void pastDueInstalmentUpdate(String pastDueDays, String loanNumber, String instNum, ExtentTest test) throws Exception{
		

		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(dbUrl, username, password);

		stmt=con.createStatement();
	
 String pastDueInstalment="update ST_IL_Schedule set INST_DUE_DATE= sysdate-"+pastDueDays+" where INST_NUM= "+instNum+" and ILOAN_CODE="+loanNumber;

		 stmt.executeUpdate(pastDueInstalment);
		 con.commit();
		 System.out.println("pastDueInstalmentdate updated "+pastDueInstalment);		
}
	
	
}