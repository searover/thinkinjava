package com.eho.util;

import java.util.*;
import java.text.*;

public class CTime {
    
    public static String strDateTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
