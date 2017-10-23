<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<html>
<head>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

	//1. 문서 로딩
	$(document).ready(()=>{	//  ()=>{}  =  function(){}
		//2.ajax요청
		$.ajax({
			type:'GET',
			url:'/web/pizzaPieChart',
			//3.요청성공
			success:function(json){	//json타입으로 data를 받는다.
				//console.log(data+"asdasd");
				/* 	$(data).each(function(item,index){
					$('#chart_div').append(this.topping+","+this.slices+'<br>'); 
					})
				*/
					//4. 구글차트 로드	
					google.charts.load('current', {'packages':['corechart']});
					//5. 구글차트 그리기
					google.charts.setOnLoadCallback(function(){
						var data = new google.visualization.DataTable();
				        data.addColumn('string', 'Topping');
				        data.addColumn('number', 'Slices');
				        //변수 선언 변수 let은 생명주기가 중괄호로 된다.
				        var rowList = new Array();	//var rowList = []; 이렇게 해도 배열이 만들어진다.
				        $(json).each(function(){
				        	var row = [];
				        	row[0] = this.topping;
				        	row[1] = this.slices;
				        	rowList.push(row);
				        });
				        data.addRows(rowList);
				        var options = {'title':'How Much Pizza I Ate Last Night',
				                       'width':400,
				                       'height':300};
				        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
				        chart.draw(data, options);					
					});				
			}
		});
	}); 
      /* google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
    	var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
          ['Mushrooms', 3],
          ['Onions', 1],
          ['Olives', 1],
          ['Zucchini', 1],
          ['Pepperoni', 2]
        ]);
        var options = {'title':'How Much Pizza I Ate Last Night',
                       'width':400,
                       'height':300};
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      } */
	</script>
</head>
<body>
	<!--Div that will hold the pie chart-->
	<div id="chart_div"></div>
</body>
</html>