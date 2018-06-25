package com.redDabbler.review.swagger.controller;

import com.redDabbler.review.swagger.model.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/test")
@Api(value = "test",description = "处理user的数据")
public class HelloController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value={"/users"}, method=RequestMethod.GET)
    public List<User> getUserList() {
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

    @ApiOperation(value="创建用户", notes="")
    @RequestMapping(value="/user", method=RequestMethod.POST)
    @ApiImplicitParam(name="user" ,value = "用户详细实体user",dataTypeClass = User.class)
    public String postUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value = "获取用户信息")
    @RequestMapping(value="/user/{id}", method=RequestMethod.GET)
    @ApiImplicitParam(name="id",value = "用户id",dataType = "Long")
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @ApiOperation(value = "更新用户信息" ,notes="根据id指定更新的用户")
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "要更新的用户id",dataType = "Long",required = true),
            @ApiImplicitParam(name="user",value = "更新的详细实体",dataType = "User",required = true)
    })
    // 指定多个参数描述，类型
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @ApiOperation(value = "删除用户信息",notes = "根据id删除用户")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }

}
