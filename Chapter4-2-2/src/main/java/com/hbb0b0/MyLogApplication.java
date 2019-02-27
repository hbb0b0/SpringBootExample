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
}
