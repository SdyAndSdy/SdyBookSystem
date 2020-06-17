package com.hq.masterdaotext;

import org.junit.Test;

import com.hq.bean.SysMaster;
import com.hq.daoimpl.MasterDaoImpl;
//dao的测试类
public class MasertDaoTest {
	MasterDaoImpl masterdao = new MasterDaoImpl();
	
	@Test
	public void selectByaccountAndPassword(){
		SysMaster master = masterdao.selectByaccountAndPassword("meien1", "123");
	    System.out.println("masterTest:"+master);
	}
}
