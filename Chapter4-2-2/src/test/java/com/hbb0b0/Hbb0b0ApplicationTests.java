package com.hbb0b0;

import com.didispace.Application;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class Hbb0b0ApplicationTests {



    @Test
    public void test() throws Exception {
        MyLogApplication myLogApplication=new MyLogApplication();
    }

}
