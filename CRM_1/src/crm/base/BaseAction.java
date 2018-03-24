package crm.base;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import crm.classesm.service.ClassService;
import crm.coursetype.service.CourseTypeService;
import crm.department.service.DepartmentService;
import crm.follow.service.FollowService;
import crm.graduate.service.GraduateService;
import crm.post.service.PostService;
import crm.refer.service.ReferService;
import crm.runoff.service.RunOffService;
import crm.staff.service.StaffService;
import crm.station.service.StationService;
import crm.student.service.StudentService;

/**
 * <p>
 * Title: BaseAction
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author RookieWangZhiWei
 * @date 2018-3-23 上午9:23:05
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	private Class<T> beanClass;

	public BaseAction() {

		try {
			ParameterizedType parameterizedType = (ParameterizedType) this
					.getClass().getGenericSuperclass();
			beanClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];

			t = beanClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private T t;

	@Override
	public T getModel() {
		return t;
	}

	/*******************************************************************/
	//2.1员工
		private StaffService staffService;
		public void setStaffService(StaffService staffService) {
			this.staffService = staffService;
		}
		public StaffService getStaffService() {
			return staffService;
		}
		
		//2.2 部门
		private DepartmentService departmentService;
		public void setDepartmentService(DepartmentService departmentService) {
			this.departmentService = departmentService;
		}
		public DepartmentService getDepartmentService() {
			return departmentService;
		}
		//2.3 职务
		private PostService postService;
		public void setPostService(PostService postService) {
			this.postService = postService;
		}
		public PostService getPostService() {
			return postService;
		}
		// 2.4 课程类别
		private CourseTypeService courseTypeService;
		public void setCourseTypeService(CourseTypeService courseTypeService) {
			this.courseTypeService = courseTypeService;
		}
		public CourseTypeService getCourseTypeService() {
			return courseTypeService;
		}
		// 2.5 班级
		private ClassService classService;
		public void setClassService(ClassService classService) {
			this.classService = classService;
		}
		public ClassService getClassService() {
			return classService;
		}
		
		// 2.6 咨询
		private ReferService referService;
		public void setReferService(ReferService referService) {
			this.referService = referService;
		}
		public ReferService getReferService() {
			return referService;
		}
		
		// 2.7 跟踪
		private FollowService followService;
		public void setFollowService(FollowService followService) {
			this.followService = followService;
		}
		public FollowService getFollowService() {
			return followService;
		}
		
		// 2.8 学生
		private StudentService studentService;
		public void setStudentService(StudentService studentService) {
			this.studentService = studentService;
		}
		public StudentService getStudentService() {
			return studentService;
		}
		
		// 2.9 升级/转班
		private StationService stationService;
		public void setStationService(StationService stationService) {
			this.stationService = stationService;
		}
		public StationService getStationService() {
			return stationService;
		}
		
		// 2.10 丢失
		private RunOffService runOffService;
		public void setRunOffService(RunOffService runOffService) {
			this.runOffService = runOffService;
		}
		public RunOffService getRunOffService() {
			return runOffService;
		}
		
		// 2.11 就业
		private GraduateService graduateService;
		public void setGraduateService(GraduateService graduateService) {
			this.graduateService = graduateService;
		}
		public GraduateService getGraduateService() {
			return graduateService;
		}

	/****************************************************************************/

	// 获取当前页
	private int pageNum = 1;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	// 每页显示个数
	private int pageSize = 2;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	// 公共方法
	// 给context赋值
	public void put(String key, Object value) {
		ActionContext.getContext().put(key, value);
	}

	// 给session 赋值
	public void sessionPut(String key, Object value) {
		ActionContext.getContext().getSession().put(key, value);
	}

	// 给application赋值
	public void applicationPut(String key, Object value) {
		ActionContext.getContext().getApplication().put(key, value);
	}

	// 给值栈赋值
	public void set(String key, Object value) {
		ActionContext.getContext().getValueStack().set(key, value);
	}

	public void push(Object value) {
		ActionContext.getContext().getValueStack().push(value);
	}

	public Object get(String o) {
		return ActionContext.getContext().get(o);
	}

	public Object sessionGet(String o) {
		return ActionContext.getContext().getSession().get(o);

	}

	public Object applicationGet(String o) {
		return ActionContext.getContext().getApplication().get(o);
	}
}
