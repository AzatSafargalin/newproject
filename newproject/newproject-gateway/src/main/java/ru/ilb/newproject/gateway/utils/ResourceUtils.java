package ru.ilb.newproject.gateway.utils;

import javax.annotation.Resource;
import javax.inject.Named;

/**
 *
 * @author AndrewSych
 */
@Named
public class ResourceUtils {

    @Resource(name = "testProxy")
    public ru.ilb.newproject.gateway.utils.custom.TestResource googleResource;
}
