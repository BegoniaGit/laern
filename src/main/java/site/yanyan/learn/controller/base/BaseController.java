package site.yanyan.learn.controller.base;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.yanyan.learn.pojo.dev.ResultResponse;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;


public class BaseController {
	protected static final Logger log = LoggerFactory.getLogger("adminLogger");

//	@Autowired
//	private MessageSource msgSource; 
  
//	public SysUser getCurrentUser() {
//		return UserUtil.getLoginUser();
//	}
	
//	public Long getCurrentUserId() {
//		return UserUtil.getLoginUser().getId();
//	}
	
	public ResultResponse<Long> newSaveResult(Long result)
 	{
 		ResultResponse<Long> response = null;
 		if (result < 0)
 		{
 			int iresult = Integer.parseInt(result.toString());
	 		switch(iresult) {
	 		case  (int)-3L :
	 			response = new ResultResponse<Long>(1,"The record of edit is not exist.");
	 			break;
	 		case (int)-1L:
	 			response = new ResultResponse<Long>(1,"The operation error.");
	 			break;
	 		case (int)-2L:
	 			response = new ResultResponse<Long>(1,"The id of edit/save is null.");
	 			break;
	 		case (int)-4L:
	 			response = new ResultResponse<Long>(1,"The state of record can not edit.");
	 			break;
	 		case (int)-5L:
	 			response = new ResultResponse<Long>(1,"The record of edit is existed.");
	 			break;
	 		case (int)-6L:
	 			response = new ResultResponse<Long>(1,"The operation error.");
	 			break;
	 		case (int)-7L:
	 			response = new ResultResponse<Long>(1,"The delete Information is not exist");
	 			break;
	 		case (int)-8L:
	 			response = new ResultResponse<Long>(1,"The Record is  null.");
	 			break;
	 		case (int)-9L:
	 			response = new ResultResponse<Long>(1,"The Id is empty.");
	 			break;
	 		default:
	 			response = new ResultResponse<Long>(result);
	 		}
 		}else
 			response = new ResultResponse<Long>(result);
 		return response;
 	}
}

