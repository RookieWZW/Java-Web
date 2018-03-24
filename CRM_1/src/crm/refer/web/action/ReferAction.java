package crm.refer.web.action;

import java.util.Date;
import java.util.List;

import crm.base.BaseAction;
import crm.constant.CommonConstant;
import crm.coursetype.domain.CrmCourseType;
import crm.refer.domain.CrmRefer;
import crm.staff.domain.CrmStaff;

/**
 * <p>
 * Title: ReferAction
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author RookieWangZhiWei
 * @date 2018-3-23 下午8:49:46
 */
public class ReferAction extends BaseAction<CrmRefer> {

	public String findAll() {
		List<CrmRefer> allRefer = this.getReferService().findAll(
				this.getModel());
		this.set("allRefer", allRefer);
		// this.set("condition", condition);
		return "findAll";
	}

	public String preAddOrEdit() {

		// 1 查询所有的课程类别
		List<CrmCourseType> allCourseType = this.getCourseTypeService()
				.findAll();
		this.put("allCourseType", allCourseType);

		// 查询指定id的资讯
		if (this.getModel().getReferId() != null) {
			CrmRefer findRefer = this.getReferService().findById(
					this.getModel().getReferId());
			this.push(findRefer);
		}
		return "preAddOrEdit";
	}

	public String addOrEdit() {
		if (this.getModel().getReferId() == null) {
			this.getModel().setCreateDate(new Date());
			CrmStaff crmStaff = (CrmStaff) this.sessionGet("loginUser");
			this.getModel().setCrmStaff(crmStaff);
			// 注意状态
			this.getModel().setStatus(CommonConstant.REFER_STATUS_DEFAULT);
		}
		this.getReferService().addOrEdit(this.getModel());
		return "addOrEdit";
	}

	public String findById() {
		CrmRefer findRefer = this.getReferService().findById(
				this.getModel().getReferId());
		this.push(findRefer);
		return "findById";
	}

	public String preAdd() {

		// 1 查询所有的课程类别
		List<CrmCourseType> allCourseType = this.getCourseTypeService()
				.findAll();
		this.put("allCourseType", allCourseType);

		return "preAdd";
	}

	public String add() {
		this.getModel().setCreateDate(new Date());
		CrmStaff crmStaff = (CrmStaff) this.sessionGet("loginUser");
		this.getModel().setCrmStaff(crmStaff);
		// 注意状态
		this.getModel().setStatus(CommonConstant.REFER_STATUS_DEFAULT);

		this.getReferService().addRefer(this.getModel());
		return "add";
	}

	public String preEdit() {

		// 1 查询所有的课程类别
		List<CrmCourseType> allCourseType = this.getCourseTypeService()
				.findAll();
		this.put("allCourseType", allCourseType);

		// 2 查询指定id的资讯
		CrmRefer findRefer = this.getReferService().findById(
				this.getModel().getReferId());
		this.push(findRefer);

		return "preEdit";
	}

	public String edit() {
		this.getReferService().updateRefer(this.getModel());
		return "edit";
	}

	public String preAddStudent() {
		// 查询指定id的资讯
		CrmRefer findRefer = this.getReferService().findById(
				this.getModel().getReferId());
		this.push(findRefer);
		return "preAddStudent";
	}
	
	public String addStudent(){
		return "addStudent";
	}
}
