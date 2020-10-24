package test;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import test.mapper.UMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: wzg
 * @Date: 2020/9/23 6:56 下午
 */
public class Test {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.selectById(1);
        sqlSession.commit();
        sqlSession.flushStatements();
        sqlSession.close();
        System.out.println(JSON.toJSONString(user));

    }
}
