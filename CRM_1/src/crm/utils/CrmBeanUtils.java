package crm.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import javax.management.RuntimeErrorException;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @author: RookieWangZhiWei
 * @date:2018-3-22 下午8:29:20
 * @version :
 * 
 */
public class CrmBeanUtils {
	public static void changeProperty(Object sourceBean, Object targetBean) {
		try {
			Class sourceClass = sourceBean.getClass();

			Class targetClass = targetBean.getClass();
			if (sourceClass != targetClass) {
				throw new RuntimeException("sourceBean 和 targetBean 不是同一种类");
			}
			BeanInfo beanInfo = Introspector.getBeanInfo(sourceClass,
					Object.class);
			PropertyDescriptor[] allPD = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor pd : allPD) {
				String propName = pd.getName();

				Object propValue = pd.getReadMethod().invoke(sourceBean);
				if (propValue != null) {
					BeanUtils.setProperty(targetBean, propName, propValue);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
}
