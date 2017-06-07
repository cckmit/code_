package com.mika.credit.facade.admin.model;

import java.util.Date;

/**
 *  @describe: 描述User和Group之间的映射关系
 * @author: dhl007
 * Created by dell on 2017/4/5.
 */
public class UserGroupLink {

    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
