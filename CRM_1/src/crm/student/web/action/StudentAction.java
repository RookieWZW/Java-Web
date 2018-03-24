package crm.student.web.action;

import java.util.List;

import crm.base.BaseAction;
import crm.classesm.domain.CrmClass;
import crm.constant.CommonConstant;
import crm.coursetype.domain.CrmCourseType;
import crm.student.domain.CrmStudent;

public class StudentAction extends BaseAction<CrmStudent> {

	private static final long serialVersionUID = 3713359442852644901L;
	
	/**
	 * 查询所有
	 * @return
	 */
	public String findAll(){
		
		//1 所有的类型
		List<CrmCourseType> allCourseType = this.getCourseTypeService().findAll();
		this.set("allCourseType", allCourseType);
		
		//2当前类型的所有班级
		if(this.getModel().getCrmClass() != null){
			CrmCourseType crmCourseType = this.getModel().getCrmClass().getCrmCourseType();
			if( crmCourseType != null){
				List<CrmClass> allClass = this.getClassService().findAll(crmCourseType);
				this.set("allClass", allClass);
			}
		}
		
		//2 所有学生
		List<CrmStudent> allStudent = this.getStudentService().findAll(this.getModel());
		this.set("allStudent", allStudent);
		return "findAll";
	}
	
	/**
	 * 添加或编辑前
	 * @return
	 */
	public String preAddOrEdit(){
		//1查询所有班级类别
		List<CrmCourseType> allCourseType = this.getCourseTypeService().findAll();
		this.put("allCourseType", allCourseType);
		
		
		//通过id查询学生
		if(this.getModel().getStudentId() != null){
			CrmStudent findStudent = this.getStudentService().findById(this.getModel().getStudentId());
			this.push(findStudent);
			
			//当前类型的所有班级
			if(findStudent.getCrmClass() != null){
				CrmCourseType crmCourseType = findStudent.getCrmClass().getCrmCourseType();
				if( crmCourseType != null){
					List<CrmClass> allClass = this.getClassService().findAll(crmCourseType);
					this.set("allClass", allClass);
				}
			}
		}
		return "preAddOrEdit";
	}
	/**
	 * 添加或编辑
	 * @return
	 */
	public String addOrEdit(){
		// 学生状态默认值
		if(this.getModel().getStatus() == null){
			this.getModel().setStatus(CommonConstant.STUDENT_STATUS_DEFAULT);
		}
		
		this.getStudentService().addOrEdit(this.getModel());
		return "addOrEdit";
	}
	/**
	 * 通过id查询
	 * @return
	 */
	public String findById(){
		CrmStudent findStudent = this.getStudentService().findById(this.getModel().getStudentId());
		this.push(findStudent);
		return "findById";
	}
	
	/**
	 * ajax 通过班级id获得所有的学生
	 * @return
	 */
	public String ajaxGetStudent(){
		List<CrmStudent> allStudent = this.getStudentService().findAll(this.getModel().getCrmClass().getClassId());
		this.set("allStudent", allStudent);
		
		return "ajaxGetStudent";
	}
	

}
