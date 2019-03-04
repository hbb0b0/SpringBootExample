package com.hbb0b0;

import org.apache.log4j.Logger;

public class MyLogApplication {
    private Logger logger = Logger.getLogger(getClass());
    public MyLogApplication()
    {
        String info=MyLogApplication.class.getName()+" "+"constructor";
        logger.info(info);
        logger.debug(info);
    }

    public void divide(int number)
    {
        final int sum=100;
        String info;
        try {
             info=String.format("%d/%d=%d",sum,number,sum/number);
            logger.info(info);
        }
        catch (Exception ex)
        {
            logger.error(ex);
        }
    }
}
