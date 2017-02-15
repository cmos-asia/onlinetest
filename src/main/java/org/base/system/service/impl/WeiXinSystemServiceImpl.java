package org.base.system.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.base.frame.util.Finder;
import org.base.system.entity.User;
import org.base.system.service.BaseSpringServiceImpl;
import org.base.system.service.IWeiXinSystemService;
import org.springframework.stereotype.Service;

@Service("weiXinSystemService")
public class WeiXinSystemServiceImpl  extends BaseSpringServiceImpl implements IWeiXinSystemService{

	@Override
	public User findMemberByweixinId(String weixinId) throws Exception {
		if(StringUtils.isBlank(weixinId)){
			return null;
		}
		Finder finder=Finder.getSelectFinder(User.class).append(" WHERE weixinId=:weixinId ").setParam("weixinId", weixinId);
		return super.queryForObject(finder, User.class);
	}

	@Override
	public void updateMemberinfoByweixinId(String weixinId, Integer state)
			throws Exception {
		if(StringUtils.isBlank(weixinId)){
			return;
		}
		User findMemberByweixinId = findMemberByweixinId(weixinId);
		if(findMemberByweixinId==null){
			User member=new User();
			member.setId(weixinId);
			member.setAccount(weixinId);
			member.setPassword("");
			member.setWeixinId(weixinId);
			super.save(member);
		}else{
			String memberId=findMemberByweixinId.getId();
			if(StringUtils.isBlank(memberId)){
				return;
			}
			Finder finder=Finder.getUpdateFinder(User.class," state=:state ").append(" WHERE weixinId=:weixinId and id=:id ");
			finder.setParam("state", state).setParam("weixinId", weixinId).setParam("id", memberId);
			super.update(finder);
		}
		
	}

}
