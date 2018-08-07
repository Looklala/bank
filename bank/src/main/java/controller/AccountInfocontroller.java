package controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bank.pojo.AccountInfo;
import com.bank.service.AccountInfoservice;

@Controller
@RequestMapping("/user")
public class AccountInfocontroller {
@Resource
private AccountInfoservice accountinfoservice;
/**
 * �û���¼
 */
@RequestMapping("/login")
public ModelAndView login(HttpServletRequest req, ModelAndView mv) {
	List<AccountInfo> list =accountinfoservice.getAccount();
	
    if (list != null) {//��¼�ɹ�������ҳ
    	mv.addObject("list",list);
        mv.setViewName("index");
    } else {//��¼ʧ�ܻص���¼ҳ��
        mv.addObject("message", "�û����������������,����������");
        mv.setViewName("login");
    }
	return mv;

	}
}

