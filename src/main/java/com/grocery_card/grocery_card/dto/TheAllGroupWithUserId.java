package com.grocery_card.grocery_card.dto;

import com.grocery_card.grocery_card.model.groupid.TheGroupId;
import com.grocery_card.grocery_card.model.theallgroup.TheAllGroup;

import java.util.List;

public class TheAllGroupWithUserId {
    private TheAllGroup all_group;
    private TheGroupId groupId;
    public TheAllGroup getAllGroup() {
        return all_group;
    }

    public void setAllGroup(TheAllGroup all_group) {
        this.all_group = all_group;
    }

    public TheAllGroup getAll_group() {
        return all_group;
    }

    public void setAll_group(TheAllGroup all_group) {
        this.all_group = all_group;
    }

    public TheGroupId getGroupId() {
        return groupId;
    }

    public void setGroupId(TheGroupId groupId) {
        this.groupId = groupId;
    }
}
