package com.bw.service;

import java.util.List;

import com.bw.bean.Email;


public interface EmailService {
	
    
    //������Ϊ�Ѷ�
    void batchSetRead(int[] eids);
    
    //����ɾ��
    void batchDelete(int[] eids);
	
    //��������ѯ
	List<Email> selectByExample(Integer status, Integer orderFlag);
	
}
