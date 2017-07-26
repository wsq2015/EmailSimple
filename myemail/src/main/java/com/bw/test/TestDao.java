package com.bw.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bw.bean.Email;
import com.bw.bean.EmailExample;
import com.bw.bean.EmailExample.Criteria;
import com.bw.dao.EmailMapper;

/**
 * 1.����spring-test��jar��
 * 2.ʹ��ContextConfigurationע��ָ��spring�������ļ�λ��
 * 3.ʹ��RunWithע��
 * @author Administrator
 *
 */
@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestDao {
	
	@Autowired
	private EmailMapper dao;
	
	
	//����DAo
	@Test
	public void testDao(){
		
		/*//��ѯ�����Ѷ��ʼ�
		EmailExample example = new EmailExample();
		Criteria cri = example.createCriteria();
		
		//����Լ������
		cri.andStatusEqualTo(0);
		List<Email> list = dao.selectByExample(null);
		
		
		//����
		for (Email email : list) {
			System.out.println(email);
		}*/
		
		//������Ϊ�Ѷ�
		//dao.batchSetRead(new int[]{4,5});
		
		//dao.batchDelete(new int[]{7,8});
		
		
		EmailExample example = new EmailExample();
		example.setOrderByClause(" createtime desc");
		List<Email> list = dao.selectByExample(example);
		//����
		for (Email email : list) {
			System.out.println(email);
		}
	}
	
	

}
