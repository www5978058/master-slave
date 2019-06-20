package com.shyb.masterslave;

import com.shyb.masterslave.entity.UserOrder;
import com.shyb.masterslave.mapper.order.UserOrderMapper;
import com.shyb.masterslave.mapper.user.UserMapper;
import com.shyb.masterslave.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MasterSlaveApplicationTests {
    @Autowired
    UserService userService;
    @Test
    public void contextLoads() throws SQLException {
        userService.change();
    }
}
