/**   
* @Title: RegionAction.java 
* @Package bos.web.action 
* @Description: TODO(用一句话描述该文件做什么) 
* @author RookieWangZhiWei
* @date 2018年3月27日 下午8:15:45 
* @version V1.0   
*/
package bos.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import bos.domain.Region;
import bos.service.RegionService;
import bos.utils.PinYin4jUtils;
import bos.web.action.base.BaseAction;
@Controller
@Scope("prototype")
public class RegionAction extends BaseAction<Region> {
		public File myFile;
		/**
		 * @param myFile the myFile to set
		 */
		public void setMyFile(File myFile) {
			this.myFile = myFile;
		}
		
		public String importXls() throws IOException {
				String flag = "1";
				try {
					HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(myFile));
					
					
					HSSFSheet sheet = workbook.getSheetAt(0);
					List<Region> list = new ArrayList<Region>();
					
					
					for (Row row : sheet) {
						int rowNum = row.getRowNum();
						if(rowNum == 0) {
							continue;
						}
						
						
						String id = row.getCell(0).getStringCellValue();
						String province = row.getCell(1).getStringCellValue();
						String city = row.getCell(2).getStringCellValue();
						String district = row.getCell(3).getStringCellValue();
						String postcode = row.getCell(4).getStringCellValue();
						Region region = new Region(id, province, city, district, postcode, null, null, null);
							
						
						city = city.substring(0, city.length()-1);
						String[] stringToPinyin = PinYin4jUtils.stringToPinyin(city);
						
						String citycode = StringUtils.join(stringToPinyin,"");
						
						//简码---->>HBSJZCA
						province  = province.substring(0, province.length() - 1);
						district  = district.substring(0, district.length() - 1);
						String info = province + city + district;//河北石家庄长安
						String[] headByString = PinYin4jUtils.getHeadByString(info);
						String shortcode = StringUtils.join(headByString, "");
						
						region.setCitycode(citycode);
						region.setShortcode(shortcode);
						list.add(region);
						
					}
					regionService.saveBatch(list);
				}catch (Exception e) {
					// TODO: handle exception
					flag = "0";
				}
				ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
				ServletActionContext.getResponse().getWriter().print(flag);
				return NONE;
		}
		
		public String pageQuery() throws IOException {
			regionService.pageQuery(pageBean);
			this.writePageBean2Json(pageBean,new String[]{"currentPage","detachedCriteria","pageSize","subareas"});
			return NONE;
		}
		
		
		private String q;
		public String listajax() throws IOException {
			List<Region> list = null;
			if(StringUtils.isNotBlank(q)) {
				list = regionService.findByQ(q);
			}else {
				list = regionService.findAll();
			}
			String[] excludes = new String[]{"subareas"};
			this.writeList2Json(list, excludes);
			return NONE;
		}
		/**
		 * @return the q
		 */
		public String getQ() {
			return q;
		}
		/**
		 * @param q the q to set
		 */
		public void setQ(String q) {
			this.q = q;
		}
}
