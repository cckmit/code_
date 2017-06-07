package com.mika.credit.facade.front.en.Util;

import java.util.Date;

@SuppressWarnings("UnusedDeclaration")
public class UtilDate {


    public static long getCalculateDate(Date StartData,Date endDate) {
        if (StartData != null && endDate != null) {
            long selectStartTime = StartData.getTime();
            long selectEndTime = endDate.getTime();
            long selectTime = (selectStartTime - selectEndTime) / 86400000;//(1000 * 60 * 60 * 24);

            return selectTime;
        } else {
            return 100000;
        }
    }

}
