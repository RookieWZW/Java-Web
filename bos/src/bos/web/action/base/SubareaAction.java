/**   
* @Title: SubareaAction.java 
* @Package bos.web.action.base 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author RookieWangZhiWei
* @date 2018��3��27�� ����11:09:00 
* @version V1.0   
*/
package bos.web.action.base;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;


import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import bos.domain.Region;
import bos.domain.Subarea;
import bos.utils.FileUtils;

@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea> {

	public String add() {
		subareaService.save(model);
		
		return "list";
	}

	public String pageQuery() throws IOException {
		DetachedCriteria detachedCriteria2 = pageBean.getDetachedCriteria();
		String addresskey = model.getAddresskey();
		Region region = model.getRegion();
		if (StringUtils.isNotBlank(addresskey)) {
			detachedCriteria2.add(Restrictions.ilike("addresskey", addresskey));
		}
		if (region != null) {
			detachedCriteria2.createAlias("region", "r");
			String province = region.getProvince();
			String city = region.getCity();
			String district = region.getDistrict();

			if (StringUtils.isNotBlank(province)) {
				// ����ʡ����ģ����ѯ
				detachedCriteria2.add(Restrictions.like("r.province", "%" + province + "%"));
			}
			if (StringUtils.isNotBlank(city)) {
				// ����ʡ����ģ����ѯ
				detachedCriteria2.add(Restrictions.like("r.city", "%" + city + "%"));
			}
			if (StringUtils.isNotBlank(district)) {
				// ����ʡ����ģ����ѯ
				detachedCriteria2.add(Restrictions.like("r.district", "%" + district + "%"));
			}
		}
		subareaService.pageQuery(pageBean);
		String[] excludes = new String[] { "detachedCriteria", "currentPage", "pageSize", "decidedzone", "subareas" };
		this.writePageBean2Json(pageBean, excludes);
		return NONE;
	}

	public String exportXls() throws IOException {
		List<Subarea> list = subareaService.findAll();

		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet("��������");

		HSSFRow headRow = sheet.createRow(0);
		headRow.createCell(0).setCellValue("�������");
		headRow.createCell(1).setCellValue("������");
		headRow.createCell(2).setCellValue("��ַ�ؼ���");
		headRow.createCell(3).setCellValue("ʡ����");

		for (Subarea subarea : list) {
			HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
			dataRow.createCell(0).setCellValue(subarea.getId());
			dataRow.createCell(1).setCellValue(subarea.getRegion().getId());
			dataRow.createCell(2).setCellValue(subarea.getAddresskey());
			Region region = subarea.getRegion();
			dataRow.createCell(3).setCellValue(region.getProvince() + region.getCity() + region.getDistrict());
		}

		String filename = "��������.xls";
		String agent = ServletActionContext.getRequest().getHeader("User-Agent");
		filename = FileUtils.encodeDownloadFilename(filename, agent);
		// һ��������ͷ
		ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
		String contentType = ServletActionContext.getServletContext().getMimeType(filename);
		ServletActionContext.getResponse().setContentType(contentType);
		ServletActionContext.getResponse().setHeader("content-disposition", "attchment;filename=" + filename);
		workbook.write(out);
		return NONE;
	}
}
