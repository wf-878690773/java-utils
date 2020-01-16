package com.zr.lister;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.zr.mapper.UserMapper;
import com.zr.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UploadDataLister extends AnalysisEventListener<User> {


    private UserMapper userMapper;


    private static final int BATCH_COUNT = 10;

    List<User> list = new ArrayList<User>();

    public UploadDataLister(UserMapper userMapper){

        this.userMapper = userMapper;
    }

    @Override
    public void invoke(User user, AnalysisContext context) {


        list.add(user);

        if (list.size() >= BATCH_COUNT){

            saveData();

            list.clear();
        }


    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

        saveData();

    }

    private void saveData() {
        for (User user : list) {
            System.out.println(user);
        }

        userMapper.batchInsert(list);

    }


}
