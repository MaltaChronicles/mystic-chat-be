package it.mystic.chat.util.constant;

import it.mystic.chat.util.DateUtil;

import java.util.Date;

public class DateConstant {

    //+++++ MESI +++++
    public static final Date ONE_MONTH_AGO = DateUtil.subtractYear(new Date(), 1);

    //+++++ ANNI +++++
    public static final Date ONE_YEAR_AGO = DateUtil.subtractMonth(new Date(), 1);
}
