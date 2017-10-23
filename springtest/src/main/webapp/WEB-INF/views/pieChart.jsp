<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<html>
<head>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			type:'GET',
			url:'/web/pizzaPieChart',
			success:function(data){
				console.log(data+"asdasd");
				$(data).each(function(item,index){
					$('#chart_div').append(this.topping+","+this.slices+'<br>');
				})
			}
		});
	}); //  ()=>{}  =  function(){}
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