/**
 * 
 */
function toInt(number) {
	return number*1 | 0 || 0;
}
function pn_increase(idx)
{
	//var y="pnid"+idx.value;
　　		//var x=document.getElementById("preborrow_number");  // 找到元素
	//x.value=y;
　　		var x=document.getElementById("pnid"+idx.value);  // 找到元素
	//var ii=idx.value;
　　		//var y=x[toInt(ii)].value;    // 改变内容
	x.value=toInt(x.value)+1;
	var z=document.getElementById("brnid"+idx.value).innerHTML;  // 找到元素
	//x.value=z.innerHTML;
		
	if(x.value>toInt(z))	x.value=toInt(z);
}

function pn_reduce(idx)
{
　　	var x=document.getElementById("pnid"+idx.value);  // 找到元素
　　	x.value=toInt(x.value)-1;
	if(x.value<0)	x.value=0;
}

function chooseAll(allC){
	var otherC = document.getElementsByName("select_book_id");
	for(var i=0; i<otherC.length; i++){
		otherC[i].checked = allC.checked;
	}
}		