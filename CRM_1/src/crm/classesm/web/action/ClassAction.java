package crm.classesm.web.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import crm.base.BaseAction;
import crm.classesm.domain.CrmClass;
import crm.constant.CommonConstant;
import crm.coursetype.domain.CrmCourseType;
import crm.utils.StringUtils;

/**
 * <p>
 * Title: ClassAction
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author RookieWangZhiWei
 * @date 2018-3-23 下午1:01:33
 */
public class ClassAction extends BaseAction<CrmClass> {
	private static final long serialVersionUID = 7109237028679527218L;

	/**
	 * 
	 * @Title: findAll
	 * @Description: 查找全部
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String findAll() {
		List<CrmClass> allClass = this.getClassService().findAll();
		this.set("allClass", allClass);
		return "findAll";
	}

	/**
	 * 
	 * @Title: preAddOrEdit
	 * @Description: 添加或更新前
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String preAddOrEdit(){
		//1 查询班级
		if(this.getModel().getClassId() != null){
			CrmClass findClass = this.getClassService().findById(this.getModel().getClassId());
			this.push(findClass);
		}
		//2 查询类别
		List<CrmCourseType> allCourseType = this.getCourseTypeService().findAll();
		this.set("allCourseType", allCourseType);
		return "preAddOrEdit";
	}
	/**
	 * 
	 * @Title: addOrEdit
	 * @Description: 添加或更新
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String addOrEdit() {

		this.getClassService().addOrEdit(this.getModel());

		return "addOrEdit";
	}

	/**
	 * 
	 * @Title: findById
	 * @Description: 根据id查询
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String findById() {
		CrmClass findClass = this.getClassService().findById(
				this.getModel().getClassId());

		this.push(findClass);

		return "findById";
	}

	/**
	 * 
	 * @Title: ajaxGetClass
	 * @Description: 通过课程类别id查询所有的班级
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String ajaxGetClass() {

		List<CrmClass> allClass = this.getClassService().findAll();

		this.put("allClass", allClass);
		return "ajaxGetClass";
	}

	public String preUpload() {
		CrmClass findClass = this.getClassService().findById(
				this.getModel().getClassId());

		this.push(findClass);

		return "preUpload";
	}

	private File schedule;

	private String scheduleFileName;

	public void setSchedule(File schedule) {
		this.schedule = schedule;
	}

	public void setScheduleFileName(String scheduleFileName) {
		this.scheduleFileName = scheduleFileName;
	}
	/**
	 * 
	* @Title: upload   
	* @Description: 上传   
	* @param @return      
	* @return String     
	* @throws
	 */
	public String upload() {

		try {
			String parentDir = ServletActionContext.getServletContext()
					.getRealPath(CommonConstant.CLASS_SCHEDULE_DIR);
			String randomName = StringUtils.getUUID();

			File target = new File(parentDir, randomName);

			this.getModel().setUploadPath(
					CommonConstant.CLASS_SCHEDULE_DIR + "/" + randomName);

			this.getModel().setUploadFilename(scheduleFileName);

			this.getClassService().updateSchedule(this.getModel());

			FileUtils.copyFile(schedule, target);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			this.addFieldError("uploadTime", "上传有误" + e.getMessage());
			return "input";
		}
		return "upload";
	}
	public String download(){
		CrmClass findClass = this.getClassService().findById(this.getModel().getClassId());
		InputStream is = ServletActionContext.getServletContext().getResourceAsStream(findClass.getUploadPath());
		if(is == null){
			this.addFieldError("uploadFilename",  "课表已经不存在，请重新上传");
			return "input";
		}
		this.target = is;
		this.downloadFileName  =findClass.getUploadFilename();
		
		
		return "download";
	}
	private InputStream target;
	public InputStream getTarget() {
		return target;
	}
	private String downloadFileName;
	public String getDownloadFileName() throws UnsupportedEncodingException {
		if(downloadFileName != null){
			return new String(downloadFileName.getBytes(),"ISO-8859-1");
		}
		return downloadFileName;
	}
}
