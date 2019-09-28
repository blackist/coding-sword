package advance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO Date
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/25
 */
public class DateUtil {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1 = df.parse("2004-03-26 13:31:40");
		Date d2 = df.parse("2004-01-02 11:30:24");
		long diff = d1.getTime() - d2.getTime();
		double days = diff / (1000 * 60.0);
		System.out.println(String.format("%.2f", days));
	}
}
