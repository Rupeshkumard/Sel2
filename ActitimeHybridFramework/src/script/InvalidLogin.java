package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.XL;
import page.LoginPage;

public class InvalidLogin extends BaseTest {
	@Test(priority=2)
	public void testInvalidLogin() {
		int rc = XL.getRowCount(XL_PATH,"InvalidLogin");
		Reporter.log("RowCount:"+rc,true);
		for(int i=1;i<=rc;i++) {
		String un=XL.getData(XL_PATH, "InvalidLogin", i, 0);
		String pw=XL.getData(XL_PATH, "InvalidLogin", i, 1);
		Reporter.log("UN:"+un,true);
		Reporter.log("PW:"+pw,true);
		
		
		//Enter valid username
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		
		//Enter valid password
		l.setPassword(pw);
		
		//click on login button
		l.clickLogi();
		
		//verify error message is displayed
		l.verifyErrMsgDisplayed();
		}
		
	}

}
