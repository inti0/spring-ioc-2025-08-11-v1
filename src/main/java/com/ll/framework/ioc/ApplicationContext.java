package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestFacadePostService;
import com.ll.domain.testPost.testPost.service.TestPostService;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    Map<String, Object> map = new HashMap<String, Object>();

    public ApplicationContext() {
        TestPostRepository testPostRepository = new TestPostRepository();
        TestPostService testPostService = new TestPostService(testPostRepository);
        TestFacadePostService testFacadePostService = new TestFacadePostService(testPostService, testPostRepository);
        map.put("testPostRepository", testPostRepository);
        map.put("testPostService", testPostService);
        map.put("testFacadePostService", testFacadePostService);
    }

    public <T> T genBean(String beanName) {
        return (T) map.get(beanName);
    }
}
