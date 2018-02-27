//用户名：  
var  LoginIdRegex = /^\w{3,15}$/;  
//名字：  
var  NameRegex = /[^x00-xff]/;  
//地址：  
var  AddressRegex = /^\w{2,30}$/;  
//密码：  
var LoginPwdRegex = /^\w{6,12}$/;  
//邮箱：  
var emailRegex = /^\w+@\w+(\.\w+)+$/;   
//手机号验证
var PhoneRegex = /^1[3|4|5|7|8][0-9]{9}$/;
function byId(id){  //自定义方法，用于获取传递过来的ID值对应的节点对象  
            return document.getElementById(id);  
        }
//当鼠标离开节点时调用此方法，验证节点内容是否符合注册规范
function Ch_Mail(Node){
	var MailNode = Node.value;
	if(!emailRegex.test(MailNode)){
		byId("Mail").style.color= "red";
	}else{
		byId("Mail").style.color= "green";
	}
} 
function Ch_Address(Node){
	var AddressNode = Node.value;
	if(!AddressRegex.test(AddressNode)){
		byId("Address").style.color= "red";
	}else{
		byId("Address").style.color= "green";
	}
} 
function Ch_Name(Node){
	var NameNode = Node.value;
	if(!NameRegex.test(NameNode)){
		byId("Name").style.color= "red";
	}else{
		byId("Name").style.color= "green";
	}
} 
function Ch_Mail(Node){
	var MailNode = Node.value;
	if(!emailRegex.test(MailNode)){
		byId("Mail").style.color= "red";
	}else{
		byId("Mail").style.color= "green";
	}
}  
function Ch_LoginId(Node){
	var LoginIdNode = Node.value;
	if(!LoginIdRegex.test(LoginIdNode)){
		byId("LoginId").style.color = "red";
	}else{
		byId("LoginId").style.color = "green";
	}
}
function Ch_LoginPwd(Node){
	var LoginPwdNode = Node.value;
	if (!LoginPwdRegex.test(LoginPwdNode)) {
		byId("LoginPwd").style.color ="red";
	}else{
		byId("LoginPwd").style.color = "green";
	};
}
function Ch_reLoginPwd(Node){
	var reLoginPwdNode = Node.value;
	var LoginPwd = byId("LoginPwd").value;
	if (reLoginPwdNode==LoginPwd) {
		byId("reLoginPwd").style.color = "green";
	}else{
		byId("reLoginPwd").style.color ="red";
	};
}
function Ch_Phone(Node){
	var PhoneNode = Node.value;
	if(!PhoneRegex.test(PhoneNode)){
		byId("Phone").style.color = "red";
	}else{
		byId("Phone").style.color = "green";
	}
}

//表单提交验证
var flag = true;  
 function validateForm(){ //定义validateForm方法用于客户端校验  

            //校验用户名  
            var LoginIdNode = byId("LoginId"); //获得ID值为LoginId的节点对象  
            var LoginId = LoginIdNode.value;   //获得LoginIdNode节点的值，即用户在LoginId文本框内填写的值  
            if(!LoginIdRegex.test(LoginId)){    //验证获得到的值是否符合正则表达式  
                byId("LoginId").style.color = "red"; //如果不符合，则将ID值为LoginId_span的节点对象内容变为红色  
                flag = false;        //返回false，不提交  
            }  

            //校验密码  
            var LoginPwdNode = byId("LoginPwd");  
            var LoginPwd = LoginPwdNode.value;  
            if(!LoginPwdRegex.test(LoginPwd)){  
                byId("LoginPwd").style.color = "red";  
                flag = false;  
            }  
            //校验名字
            var NameNode = byId("Name"); 
            var Name = NameNode.value;  
            if(!NameRegex.test(Name)){  
                byId("Name").style.color = "red";  
                flag = false;  
            }  
            //校验地址
            var AddressNode = byId("Address");  
            var Address = AddressNode.value;  
            if(!AddressRegex.test(Address)){  
                byId("Address").style.color = "red";  
                flag = false;  
            }  
              
            //确认密码  
            var reLoginPwdNode = byId("reLoginPwd");  //获得ID值为reLoginPwd的节点对象  
            var reLoginPwd = reLoginPwdNode.value;  
            if(!LoginPwd==reLoginPwd){  
                byId("reLoginPwd").style.color = "red";  
                flag = false;  
            }else if(!LoginPwdRegex.test(reLoginPwd)){  
                byId("reLoginPwd").style.color = "red";  
                flag = false;  
            }else{  
                byId("reLoginPwd").style.color = "green";  
            }  
              
            //校验邮箱  
            var emailNode = byId("Mail");  //获得ID值为Email的节点对象  
            var email = emailNode.value;  
            if(!emailRegex.test(email)){  
                byId("Mail").style.color = "red";  
                flag = false;  
            }  
            return flag;  
     }
 
 function  repass(form){
	 validateForm();
     if (flag) {
          document.myform.submit();
     }
 }
 





