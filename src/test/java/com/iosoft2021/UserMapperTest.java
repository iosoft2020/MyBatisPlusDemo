package com.iosoft2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.iosoft2021.mapper.UserMapper;
import com.iosoft2021.pojo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectAll() {

        List<User> users = userMapper.selectList(null);
        users.forEach(System.err::println);
    }

    @Test
    public void testSelectById() {

        User user = userMapper.selectById(666L);
        System.err.println(user);
    }

    @Test
    public void testSelectBatchIds() {

        List<User> users = userMapper.selectBatchIds(Arrays.asList(666, 667));
        users.forEach(System.err::println);
    }

    @Test
    public void testSelectByMap() {

        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("name", "iosoft2021-3");
        columnMap.put("age", 20);

        List<User> users = userMapper.selectByMap(columnMap);
        users.forEach(System.err::println);
    }

    @Test
    public void testPage() {

        Page<User> page = new Page<>(2, 20);
        userMapper.selectPage(page, null).getRecords().forEach(System.err::println);
        System.err.println(page.getTotal());
    }

    @Test
    public void testInsert() {

        IntStream.rangeClosed(1, 100).forEach(index -> {

            User user = new User();
            user.setName("iosoft2021-" + index);
            user.setAge(18);
            user.setEmail("iosoft2021-" + index + "@iosoft.com");
            user.setId((long) index);
            System.err.println(userMapper.insert(user));
            System.err.println(user);
        });

    }

    @Test
    public void testUpdate() {

        User user = new User();
        user.setAge(20);
        user.setId(666L);

        userMapper.updateById(user);
    }

    @Test
    public void testUpdateOptimisticLockerSuccess() {

        User user = new User();
        user.setId(666L);
        User userUpdate = userMapper.selectById(666L);
        userUpdate.setName("iosoft2021-2");
        user.setEmail("iosoft2021-2@iosoft.com");

        userMapper.updateById(userUpdate);

    }

    @Test
    public void testUpdateOptimisticLockerFaild() {

        User userUpdate = userMapper.selectById(666L);
        userUpdate.setName("iosoft2021-2");
        userUpdate.setEmail("iosoft2021-2@iosoft.com");

        User userAnother = userMapper.selectById(666L);
        userAnother.setName("iosoft2021-3");
        userAnother.setEmail("iosoft2021-3@iosoft.com");
        userMapper.updateById(userAnother);

        userMapper.updateById(userUpdate);

    }

    @Test
    public void testDelete() {

        System.err.println(userMapper.deleteById(1L));

        System.err.println(userMapper.selectById(1L));
    }

    @Test
    public void testDeleteBatchIds() {

        System.err.println(userMapper.deleteBatchIds(Arrays.asList(2, 3, 4)));
    }

    @Test
    public void testDeleteMap() {

        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("name", "iosoft2021-5");
        columnMap.put("age", 18);

        System.err.println(userMapper.deleteByMap(columnMap));
    }

    @Test
    public void testSelectByWrapper() {

        QueryWrapper<User> qwu = new QueryWrapper<>();
//        qwu.isNull("email");
//        qwu.eq("name", "iosoft2021-3");
        qwu.between("age", 1,5);


        userMapper.selectList(qwu).forEach(System.err::println);
    }

}
