package com.searover.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by searover on 4/5/16.
 */
public class DateHelper {

	public static String getDate() {
//		return helper.DateHelper.format(TimeZone.getTimeZone("GMT0"), new Date(),
//				"yyyy-MM-dd'T'HH:mm:ss'Z'");

		return null;
	}

	public static String getGMTDate() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(d);
	}
}