<h3>Total: Buy vs Sell</h3>
<div id="amChartsPanel">

	<!-- Styles -->
	<style>
#buyVersusSellStackedChart {
	width: 100%;
	height: 200px;
	font-size: 11px;
}
</style>

	<!-- Resources -->
	<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
	<script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
	<script src="https://www.amcharts.com/lib/3/serial.js"></script>
	<script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
	<link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
	<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>

	<!-- Chart code -->
	<script>
		$.ajax({
			url : "http://ec2-52-14-37-239.us-east-2.compute.amazonaws.com:8080/techtest/dashboard/trade/buyselltotals"
		}).then(function(buySellData) {
			console.log(buySellData);
			updateChart(buySellData)
		});

		function getBuyTotal(buySellData, currency) {
			var total = 0;
			if (buySellData != undefined && buySellData[currency] != undefined) {
				total = buySellData[currency].totalBuyAmount;
			}
			return total;
		}

		function getSellTotal(buySellData, currency) {
			var total = 0;
			if (buySellData != undefined && buySellData[currency] != undefined) {
				total = buySellData[currency].totalSellAmount;
			}
			return total;
		}

		function updateChart(buySellData) {

			AmCharts
					.makeChart(
							"buyVersusSellStackedChart",
							{
								"theme" : "light",
								"type" : "serial",
								"dataProvider" : [ {
									"currency" : "USD",
									"buy" : getBuyTotal(buySellData, 'USD'),
									"sell" : getSellTotal(buySellData, 'USD')
								}, {
									"currency" : "YEN",
									"buy" : getBuyTotal(buySellData, 'YEN'),
									"sell" : getSellTotal(buySellData, 'YEN')
								}, {
									"currency" : "GBP",
									"buy" : getBuyTotal(buySellData, 'GBP'),
									"sell" : getSellTotal(buySellData, 'GBP')
								}, {
									"currency" : "AUD",
									"buy" : getBuyTotal(buySellData, 'AUD'),
									"sell" : getSellTotal(buySellData, 'AUD')
								}, {
									"currency" : "NZD",
									"buy" : getBuyTotal(buySellData, 'NZD'),
									"sell" : getSellTotal(buySellData, 'NZD')
								}, {
									"currency" : "EUR",
									"buy" : getBuyTotal(buySellData, 'EUR'),
									"sell" : getSellTotal(buySellData, 'EUR')
								} ],
								"valueAxes" : [ {
									"position" : "left",
									"title" : "Buy vs. Sell",
								} ],
								"startDuration" : 1,
								"graphs" : [
										{
											"balloonText" : "Buy Total [[category]]: <b>[[value]]</b>",
											"fillAlphas" : 0.9,
											"lineAlpha" : 0.2,
											"title" : "Buy",
											"type" : "column",
											"valueField" : "buy"
										},
										{
											"balloonText" : "Sell Total [[category]] : <b>[[value]]</b>",
											"fillAlphas" : 0.9,
											"lineAlpha" : 0.2,
											"title" : "Sell",
											"type" : "column",
											"clustered" : false,
											"columnWidth" : 0.5,
											"valueField" : "sell"
										} ],
								"plotAreaFillAlphas" : 0.1,
								"categoryField" : "currency",
								"categoryAxis" : {
									"gridPosition" : "start"
								},
								"depth3D" : 20,
								"angle" : 30,
								"titles" : [ {
									"text" : "Total Buy versus Sell by currency",
									"size" : 10
								} ],
								"export" : {
									"enabled" : true
								}

							});

		}
	</script>

	<!-- HTML -->
	<div id="buyVersusSellStackedChart"></div>
</div>