package com.goldmantis.process.controller.swagger;
//package com.springboot.mybatis.controller.swagger;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//123
//import com.springboot.mybatis.entity.user.User;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.Authorization;
//
//@RestController
//@RequestMapping(value="/users")     // 通过这里配置使下面的映射都在/users下
//@Api(value = "Swagger动态文档demo")
//public class SwaggerUserController {
//	static Map<String, User> users = Collections.synchronizedMap(new HashMap<String, User>());
//
//    @ApiOperation(value="获取用户列表", notes="获取用户列表",nickname = "gimmieString",authorizations = @Authorization(value = "basicAuth"))
//    @RequestMapping(value={""}, method=RequestMethod.GET)
//    public List<User> getUserList() {
//        List<User> r = new ArrayList<User>(users.values());
//        return r;
//    }
//   
//    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
//    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
//    @RequestMapping(value="", method=RequestMethod.POST)
//    public String postUser(@RequestBody User user) {
//        users.put(user.getUserid(), user);
//        return "success";
//    }
//
//    @ApiOperation(value="获取单个用户详细信息", notes="根据url的id来获取用户详细信息")
//    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path")
//    @RequestMapping(value="/{id}", method=RequestMethod.GET)
//    public User getUser(@PathVariable String id) {
//    	User u = users.get(id);
//        return u;
//    }
//
//    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path"),
//            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
//    })
//    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
//    public String putUser(@PathVariable String id, @RequestBody User user) {
//        User u = users.get(id);
//        u.setUsername(user.getUsername());
//        u.setTelephone(user.getTelephone());
//        users.put(id, u);
//        return "success";
//    }
//
//    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
//    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path")
//    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
//    public String deleteUser(@PathVariable String id) {
//        users.remove(id);
//        return "success";
//    }
//}
