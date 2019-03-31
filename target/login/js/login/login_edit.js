$(document).ready(function(){
    $("#modal-dialog").on('click','.ok',
        doLogin);
    //获得模态框上绑定的id值
    var id=$("#modal-dialog").data("id");

    //假如id有值,说明这是修改,然后根据id获得对象,初始化模态框数据
    if(id)doGetObjectById(id);
    //当模态框隐藏时在.ok上绑定的事件执行解绑动作
    $("#modal-dialog").on(
        "hidden.bs.modal",function() {
            $(this).off('click', '.ok')
                .removeData("id")
        });
})

function doLogin() {
    var username=$("nameId").value;
    var password=$("password").value;
    var valid=$("").valid();
    var url="comfrmUser.do";
    var param={"username":username,"usepwd":password}
    $.post(url,param,function(result){
            if(result==1){

            }else{
                alert(result.message);
            }

    })
}

