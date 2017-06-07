package com.mika.credit.facade.admin.model;

import java.util.Date;

/**
 *  @describe: 描述和Group之间的映射关系
 * @author: dhl007
 * Created by dell on 2017/4/5.
 */
public class ResourceGroupLink {

    private  Resource resource;

    private Group group;

    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
