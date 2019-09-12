<jsp:include page="jqueryCombined.jsp"></jsp:include>
<style>
.button {
    background-color: #555555; /* Green */
    border: none;
    color: white;
    padding: 12px;
    height:60px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    border-radius: 12px;
}
.button:hover{
   box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);transition-duration: 0.4s; 
}
.key-button-submit{
background-color:cadetblue;
color:white;
opacity:1;
}
#controlPanel img{
height:22px;
padding-right:6.5px;
padding-left:6.5px;
cursor:pointer;
}
</style>


<div id="home_content" style="background:url(./images/background_wall.png);background-repeat: no-repeat;background-size: 100% 140%;width:100%;height:500px;margin-top:0px;background-position:0px -100px;"></div>


<div class="modal fade" id="myModal-home" tabindex="-1" role="dialog">
<div class="modal-dialog">
 <div class="modal-content" id="home-modal-content">
        <div class="modal-header" id="home-modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title" id="home-modal-title">Modal Header</h4>
        </div>
		<div class="modal-body" id="home-modalContainer">
		</div>
		<div class="modal-footer" id="home-modal-footer">
		<label class="btn btn-default  modal-submit" id="home-modal_submit" onclick="$('.home_submit_form').click();">Submit</label>
          <button type="button" id="home_modal_close" class="btn btn-default modal-cancel" data-dismiss="modal" >Cancel</button>
        </div>
</div>
</div>
</div>

<div class="modal fade" id="myModal-view" tabindex="-1" role="dialog">
<div class="modal-dialog">
 <div class="modal-content" id="view-modal-content">
        <div class="modal-header" id="view-modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title" id="view-modal-title">Modal Header</h4>
        </div>
		<div class="modal-body" id="view-modalContainer">
		</div>
		<div class="modal-footer" id="view-modal-footer">
          <button type="button" id="view_modal_close" class="btn btn-default modal-cancel" data-dismiss="modal" >Close</button>
        </div>
</div>
</div>
</div>

<script type="text/javascript">
$('#logout_user').on('click',function(){
	$.ajax({
		type:"POST",
		url:"UserController",
		data:"action=logout",
		dataType:"text",
		success: function( data, textStatus, jqXHR) {
       	 //alert(data);
            if(data.toLowerCase()=="success")
           	 {
           $('#centercol').load("success_logout.jsp");
           $('#sub_header').html("");
           $('#user_attr').html("");
           	 }
            else
				{
            alert("Error Occured");
            }
		}
	});
})
</script>

<script>
$("#search_key").on('click',function(){
	$('#home_content').html('<center style="padding: 80px 0 0 0;"><div><label><span style="color: darkmagenta;font-size: medium;"><b>Key:</b>&nbsp;<input type="text" id="key_to_search"  value="" style="width: 80%" /></span><br><br><input type="button" class="btn btn-default key-button-submit" value="Search" onclick="searchKey();"/></label></div><div id="result_div"></div></center>'); 
	
})
$("#manage_key").on('click',function(){
	$('#home_content').html('<center style="padding :80px 0 0 0;"><div><label><span style="color:darkmagenta; font-size:medium;"><b>Key:</b>&nbsp;<input type="text" id="key_to_update"  value="" style="width: 80%" /><br><br><b>Value:</b>&nbsp;<input type="text" id="value_to_update" value="" style="width: 80%" /></span><br><br><input type="button"  class="btn btn-default key-button-submit" value="Update" onclick="manageKey();"/></label></div><div id="result_div"></div></center>'); 
	
})
function searchKey(){
	var key=$('#key_to_search').val().trim();
	var current_usrid=$('#enter_val').val();
	if(key==""){
		alert("Kindly provide a valid key to search");
	}
	else{
	var dataString="action=search_key&key="+key+"&userId="+current_usrid;
	$.ajax({
	type:"POST",
	url:"UserDataController",
	data:dataString,
	dataType:"text",
	success:function(data, textStatus, jqXHR)
	{
		if(data=="")
			{
				$('#result_div').html("<br><br><span style='font-size:medium; font-weight: 700; color: brown;'>Value:</span>&nbsp;<span style='color:red'>No data Available to Display!</span>");
			}
		else
			{
			$('#result_div').html("<br><br><span style='font-size:medium; font-weight: 700; color: brown;'>Value:</span>&nbsp;<span style='color:green'>"+data+"</span>"); 	
			
			}
	}
	})
	
}
}
function manageKey(){
	var value=$('#value_to_update').val().trim();
	var key=$('#key_to_update').val().trim();
	var current_usrid=$('#enter_val').val();
	if(key==""){
		alert("Kindly provide a valid key to search");
	}
	else{
	var dataString="action=manage_key&key="+key+"&userId="+current_usrid+"&value="+value;
	$.ajax({
	type:"POST",
	url:"UserDataController",
	data:dataString,
	dataType:"text",
	success:function(data, textStatus, jqXHR)
	{
		if(data=="")
			{
				$('#result_div').html("<br><br><span style='font-size:medium; font-weight: 700; color: brown;'>Value:</span>&nbsp;<span style='color:red'>Error Occurred</span>");
			}
		else
			{
			$('#result_div').html("<br><br><span style='font-size:medium; font-weight: 700; color: brown;'>Value:</span>&nbsp;<span style='color:darkgreen'>"+data+"</span>");	
			
			}
	}
	})
	
}
}

</script>