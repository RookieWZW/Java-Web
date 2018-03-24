
package crm.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: RookieWangZhiWei
 * @date:2018-3-17 下午9:47:57
 * @version :
 * 
 */
public class CommonConstant {
	public static List<String> REFER_INTENTION_LEVEL = new ArrayList<String>();
	
	static {
		REFER_INTENTION_LEVEL.add("A.马上报名");
		REFER_INTENTION_LEVEL.add("B.想报名，考虑中");
		REFER_INTENTION_LEVEL.add("C.有报名集合，但暂时不能报名");
		REFER_INTENTION_LEVEL.add("D.不能报名，以及其他原因");
	}
	
	public static List<String> REFER_SOURCE = new ArrayList<String>();
	static{
		REFER_SOURCE.add("1.QQ");
		REFER_SOURCE.add("2.电话咨询");
		REFER_SOURCE.add("3.上门");
		REFER_SOURCE.add("4.其他（老学员介绍）");
	}
	public static Map<String,String> REFER_STATUS = new HashMap<String,String>();
	public static String REFER_STATUS_DEFAULT = "1";
	public static String REFER_STATUS_SIGNUP = "2";
	static{
		REFER_STATUS.put("1", "资讯中");
		REFER_STATUS.put("2", "已报名");
	}
	
	public static List<String> STUDENT_EDUCATION = new ArrayList<String>(); 
	static{
		STUDENT_EDUCATION.add("1.博士");
		STUDENT_EDUCATION.add("2.研究生");
		STUDENT_EDUCATION.add("3.本科");
		STUDENT_EDUCATION.add("4.大专");
		STUDENT_EDUCATION.add("5.高中");
		STUDENT_EDUCATION.add("6.初中");
		STUDENT_EDUCATION.add("7.其他");
	}
	
	public static Map<String,String> STUDENT_STATUS = new HashMap<String, String>(); 
	public static String STUDENT_STATUS_DEFAULT = "1";
	public static String STUDENT_STATUS_CHANGE = "2";
	public static String STUDENT_STATUS_UPGRADE = "3";
	public static String STUDENT_STATUS_GRADUATE = "4";
	public static String STUDENT_STATUS_RUNOFF = "5";
	static{
		STUDENT_STATUS.put("1", "新生");
		STUDENT_STATUS.put("2", "转班");	//change
		STUDENT_STATUS.put("3", "升级");	//upgrade
		STUDENT_STATUS.put("4", "毕业");	
		STUDENT_STATUS.put("5", "退费");	//runoff
	}
	
	public static Map<String,String> RUNOFF_REFUND = new HashMap<String, String>(); 
	public static String RUNOFF_REFUND_NOT = "0";
	static{
		RUNOFF_REFUND.put("1", "退款");
		RUNOFF_REFUND.put("0", "不退");
	}
	
	public static String CLASS_SCHEDULE_DIR = "/WEB-INF/upload";
}
