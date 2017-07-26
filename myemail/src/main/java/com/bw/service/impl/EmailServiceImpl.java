package com.bw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bw.bean.Email;
import com.bw.bean.EmailExample;
import com.bw.bean.EmailExample.Criteria;
import com.bw.dao.EmailMapper;
import com.bw.service.EmailService;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private EmailMapper dao;

	@Override
	public void batchSetRead(int[] eids) {
		dao.batchSetRead(eids);
		
	}

	@Override
	public void batchDelete(int[] eids) {
		dao.batchDelete(eids);
	}

	/**
	 * statusĬ�ϵ��Ķ�״̬:  0---ȫ����1----δ��,2----�Ѷ�
	 * orderFlagĬ�ϵ����� 0---������1----��ʱ������,2----��ʱ������
	 */
	@Override
	public List<Email> selectByExample(Integer status, Integer orderFlag) {
		if(status ==0 && orderFlag == 0){
			
			return dao.selectByExample(null);
		}else{
			EmailExample example = new EmailExample();
			
			//�Ķ�״̬����������
			if(status != 0){
				Criteria cri = example.createCriteria();
				cri.andStatusEqualTo(status);
			}
			
			if(orderFlag != 0){
				if(orderFlag == 1){
					//��ʱ������
					example.setOrderByClause(" createtime asc");
				}else{
					//��ʱ������
					example.setOrderByClause(" createtime desc");
				}
				
			}
			
			return dao.selectByExample(example);
		}
	}

	/*@Override
	public List<Email> selectByExample(EmailExample example) {
		return dao.selectByExample(example);
	}*/
	
	
}
