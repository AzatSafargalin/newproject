package ru.ilb.newproject.utils;

import javax.inject.Named;

@Named
public class InjectTestImpl implements InjectTest {

    @Override
    public int testMePlease(int i) {
        return i+1;
    }
    
}
