<h3>Total: Currency Bought per hour</h3>
<div id="amChartsPanel">

	<!-- Styles -->
	<style>
#buyTransPerHourStackedChart {
	width: 100%;
	height: 200px;
	font-size: 11px;
}

#sellTransPerHourStackedChart {
	width: 100%;
	height: 200px;
	font-size: 11px;
}

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
		$
				.ajax(
						{
							url : "http://ec2-52-14-37-239.us-east-2.compute.amazonaws.com:8080/techtest/dashboard/trade/currencyperhour"
						}).then(function(transPerHourData) {
					console.log(transPerHourData);
					updateBuySellChart(transPerHourData)
				});

		function getBuyCountData(transPerHourData, hour, currency) {
			var total = 0;
			if (transPerHourData != undefined
					&& transPerHourData[hour] != undefined
					&& transPerHourData[hour][currency] != undefined) {
				total = transPerHourData[hour][currency].countBuy;
			}
			return total;
		}

		function getSellCountData(transPerHourData, hour, currency) {
			var total = 0;
			if (transPerHourData != undefined
					&& transPerHourData[hour] != undefined
					&& transPerHourData[hour][currency] != undefined) {
				total = transPerHourData[hour][currency].countSell;
			}
			return total;
		}

		function updateBuySellChart(transPerHourData) {

			AmCharts
					.makeChart(
							"buyTransPerHourStackedChart",
							{
								"type" : "serial",
								"theme" : "light",
								"legend" : {
									"horizontalGap" : 10,
									"maxColumns" : 1,
									"position" : "right",
									"useGraphSettings" : true,
									"markerSize" : 10
								},
								"dataProvider" : [
										{
											"hourOfDay" : 00,
											"eur" : getBuyCountData(
													transPerHourData, 0, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 0, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 0, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 0, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 0, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 0, 'NZD')
										},
										{
											"hourOfDay" : 01,
											"eur" : getBuyCountData(
													transPerHourData, 1, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 1, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 1, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 1, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 1, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 1, 'NZD')
										},
										{
											"hourOfDay" : 02,
											"eur" : getBuyCountData(
													transPerHourData, 2, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 2, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 2, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 2, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 2, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 2, 'NZD')
										},
										{
											"hourOfDay" : 03,
											"eur" : getBuyCountData(
													transPerHourData, 3, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 3, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 3, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 3, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 3, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 3, 'NZD')
										},
										{
											"hourOfDay" : 04,
											"eur" : getBuyCountData(
													transPerHourData, 4, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 4, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 4, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 4, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 4, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 4, 'NZD')
										},
										{
											"hourOfDay" : 05,
											"eur" : getBuyCountData(
													transPerHourData, 5, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 5, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 5, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 5, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 5, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 5, 'NZD')
										},
										{
											"hourOfDay" : 06,
											"eur" : getBuyCountData(
													transPerHourData, 6, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 6, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 6, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 6, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 6, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 6, 'NZD')
										},
										{
											"hourOfDay" : 07,
											"eur" : getBuyCountData(
													transPerHourData, 7, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 7, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 7, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 7, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 7, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 7, 'NZD')
										},
										{
											"hourOfDay" : 08,
											"eur" : getBuyCountData(
													transPerHourData, 8, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 8, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 8, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 8, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 8, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 8, 'NZD')
										},
										{
											"hourOfDay" : 09,
											"eur" : getBuyCountData(
													transPerHourData, 9, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 9, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 9, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 9, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 9, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 9, 'NZD')
										},
										{
											"hourOfDay" : 10,
											"eur" : getBuyCountData(
													transPerHourData, 10, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 10, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 10, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 10, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 10, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 10, 'NZD')
										},
										{
											"hourOfDay" : 11,
											"eur" : getBuyCountData(
													transPerHourData, 11, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 11, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 11, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 11, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 11, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 11, 'NZD')
										},
										{
											"hourOfDay" : 12,
											"eur" : getBuyCountData(
													transPerHourData, 12, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 12, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 12, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 12, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 12, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 12, 'NZD')
										},
										{
											"hourOfDay" : 13,
											"eur" : getBuyCountData(
													transPerHourData, 13, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 13, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 13, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 13, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 13, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 13, 'NZD')
										},
										{
											"hourOfDay" : 14,
											"eur" : getBuyCountData(
													transPerHourData, 14, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 14, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 14, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 14, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 14, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 14, 'NZD')
										},
										{
											"hourOfDay" : 15,
											"eur" : getBuyCountData(
													transPerHourData, 15, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 15, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 15, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 15, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 15, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 15, 'NZD')
										},
										{
											"hourOfDay" : 16,
											"eur" : getBuyCountData(
													transPerHourData, 16, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 16, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 16, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 16, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 16, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 16, 'NZD')
										},
										{
											"hourOfDay" : 17,
											"eur" : getBuyCountData(
													transPerHourData, 17, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 17, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 17, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 17, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 17, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 17, 'NZD')
										},
										{
											"hourOfDay" : 18,
											"eur" : getBuyCountData(
													transPerHourData, 18, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 18, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 18, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 18, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 18, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 18, 'NZD')
										},
										{
											"hourOfDay" : 19,
											"eur" : getBuyCountData(
													transPerHourData, 19, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 19, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 19, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 19, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 19, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 19, 'NZD')
										},
										{
											"hourOfDay" : 20,
											"eur" : getBuyCountData(
													transPerHourData, 20, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 20, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 20, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 20, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 20, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 20, 'NZD')
										},
										{
											"hourOfDay" : 21,
											"eur" : getBuyCountData(
													transPerHourData, 21, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 21, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 21, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 21, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 21, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 21, 'NZD')
										},
										{
											"hourOfDay" : 22,
											"eur" : getBuyCountData(
													transPerHourData, 22, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 22, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 22, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 22, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 22, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 22, 'NZD')
										},
										{
											"hourOfDay" : 23,
											"eur" : getBuyCountData(
													transPerHourData, 23, 'EUR'),
											"usd" : getBuyCountData(
													transPerHourData, 23, 'USD'),
											"yen" : getBuyCountData(
													transPerHourData, 23, 'YEN'),
											"gbp" : getBuyCountData(
													transPerHourData, 23, 'GBP'),
											"aud" : getBuyCountData(
													transPerHourData, 23, 'AUD'),
											"nzd" : getBuyCountData(
													transPerHourData, 23, 'NZD')
										} ],
								"valueAxes" : [ {
									"stackType" : "regular",
									"axisAlpha" : 1.0,
									"gridAlpha" : 0
								} ],
								"graphs" : [
										{
											"balloonText" : "<b>[[title]]</b><br><span style='font-size:14px'>[[category]]: <b>[[value]]</b></span>",
											"fillAlphas" : 0.8,
											"labelText" : "[[value]]",
											"lineAlpha" : 0.3,
											"title" : "EURO",
											"type" : "column",
											"color" : "#000000",
											"valueField" : "eur"
										},
										{
											"balloonText" : "<b>[[title]]</b><br><span style='font-size:14px'>[[category]]: <b>[[value]]</b></span>",
											"fillAlphas" : 0.8,
											"labelText" : "[[value]]",
											"lineAlpha" : 0.3,
											"title" : "US Dollar",
											"type" : "column",
											"color" : "#000000",
											"valueField" : "usd"
										},
										{
											"balloonText" : "<b>[[title]]</b><br><span style='font-size:14px'>[[category]]: <b>[[value]]</b></span>",
											"fillAlphas" : 0.8,
											"labelText" : "[[value]]",
											"lineAlpha" : 0.3,
											"title" : "YEN",
											"type" : "column",
											"color" : "#000000",
											"valueField" : "yen"
										},
										{
											"balloonText" : "<b>[[title]]</b><br><span style='font-size:14px'>[[category]]: <b>[[value]]</b></span>",
											"fillAlphas" : 0.8,
											"labelText" : "[[value]]",
											"lineAlpha" : 0.3,
											"title" : "British Pound",
											"type" : "column",
											"color" : "#000000",
											"valueField" : "gbp"
										},
										{
											"balloonText" : "<b>[[title]]</b><br><span style='font-size:14px'>[[category]]: <b>[[value]]</b></span>",
											"fillAlphas" : 0.8,
											"labelText" : "[[value]]",
											"lineAlpha" : 0.3,
											"title" : "Australian Dollar",
											"type" : "column",
											"color" : "#000000",
											"valueField" : "aud"
										},
										{
											"balloonText" : "<b>[[title]]</b><br><span style='font-size:14px'>[[category]]: <b>[[value]]</b></span>",
											"fillAlphas" : 0.8,
											"labelText" : "[[value]]",
											"lineAlpha" : 0.3,
											"title" : "New Zealand Doller",
											"type" : "column",
											"color" : "#000000",
											"valueField" : "nzd"
										} ],
								"categoryField" : "hourOfDay",
								"columnSpacing" : 1,
								"categoryAxis" : {
									"gridPosition" : "start",
									"axisAlpha" : 0,
									"gridAlpha" : 0,
									"position" : "left"
								},
								"depth3D" : 20,
								"angle" : 30,
								"titles" : [ {
									"text" : "#Buy Trans. per hour by currency",
									"size" : 10
								} ],
								"export" : {
									"enabled" : true
								}

							});

			AmCharts
					.makeChart(
							"sellTransPerHourStackedChart",
							{
								"type" : "serial",
								"theme" : "light",
								"legend" : {
									"horizontalGap" : 10,
									"maxColumns" : 1,
									"position" : "right",
									"useGraphSettings" : true,
									"markerSize" : 10
								},
								"dataProvider" : [
										{
											"hourOfDay" : 00,
											"eur" : getSellCountData(
													transPerHourData, 0, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 0, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 0, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 0, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 0, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 0, 'NZD')
										},
										{
											"hourOfDay" : 01,
											"eur" : getSellCountData(
													transPerHourData, 1, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 1, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 1, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 1, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 1, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 1, 'NZD')
										},
										{
											"hourOfDay" : 02,
											"eur" : getSellCountData(
													transPerHourData, 2, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 2, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 2, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 2, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 2, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 2, 'NZD')
										},
										{
											"hourOfDay" : 03,
											"eur" : getSellCountData(
													transPerHourData, 3, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 3, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 3, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 3, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 3, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 3, 'NZD')
										},
										{
											"hourOfDay" : 04,
											"eur" : getSellCountData(
													transPerHourData, 4, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 4, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 4, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 4, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 4, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 4, 'NZD')
										},
										{
											"hourOfDay" : 05,
											"eur" : getSellCountData(
													transPerHourData, 5, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 5, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 5, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 5, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 5, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 5, 'NZD')
										},
										{
											"hourOfDay" : 06,
											"eur" : getSellCountData(
													transPerHourData, 6, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 6, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 6, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 6, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 6, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 6, 'NZD')
										},
										{
											"hourOfDay" : 07,
											"eur" : getSellCountData(
													transPerHourData, 7, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 7, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 7, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 7, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 7, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 7, 'NZD')
										},
										{
											"hourOfDay" : 08,
											"eur" : getSellCountData(
													transPerHourData, 8, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 8, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 8, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 8, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 8, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 8, 'NZD')
										},
										{
											"hourOfDay" : 09,
											"eur" : getSellCountData(
													transPerHourData, 9, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 9, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 9, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 9, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 9, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 9, 'NZD')
										},
										{
											"hourOfDay" : 10,
											"eur" : getSellCountData(
													transPerHourData, 10, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 10, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 10, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 10, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 10, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 10, 'NZD')
										},
										{
											"hourOfDay" : 11,
											"eur" : getSellCountData(
													transPerHourData, 11, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 11, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 11, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 11, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 11, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 11, 'NZD')
										},
										{
											"hourOfDay" : 12,
											"eur" : getSellCountData(
													transPerHourData, 12, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 12, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 12, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 12, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 12, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 12, 'NZD')
										},
										{
											"hourOfDay" : 13,
											"eur" : getSellCountData(
													transPerHourData, 13, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 13, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 13, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 13, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 13, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 13, 'NZD')
										},
										{
											"hourOfDay" : 14,
											"eur" : getSellCountData(
													transPerHourData, 14, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 14, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 14, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 14, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 14, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 14, 'NZD')
										},
										{
											"hourOfDay" : 15,
											"eur" : getSellCountData(
													transPerHourData, 15, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 15, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 15, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 15, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 15, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 15, 'NZD')
										},
										{
											"hourOfDay" : 16,
											"eur" : getSellCountData(
													transPerHourData, 16, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 16, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 16, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 16, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 16, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 16, 'NZD')
										},
										{
											"hourOfDay" : 17,
											"eur" : getSellCountData(
													transPerHourData, 17, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 17, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 17, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 17, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 17, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 17, 'NZD')
										},
										{
											"hourOfDay" : 18,
											"eur" : getSellCountData(
													transPerHourData, 18, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 18, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 18, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 18, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 18, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 18, 'NZD')
										},
										{
											"hourOfDay" : 19,
											"eur" : getSellCountData(
													transPerHourData, 19, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 19, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 19, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 19, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 19, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 19, 'NZD')
										},
										{
											"hourOfDay" : 20,
											"eur" : getSellCountData(
													transPerHourData, 20, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 20, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 20, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 20, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 20, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 20, 'NZD')
										},
										{
											"hourOfDay" : 21,
											"eur" : getSellCountData(
													transPerHourData, 21, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 21, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 21, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 21, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 21, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 21, 'NZD')
										},
										{
											"hourOfDay" : 22,
											"eur" : getSellCountData(
													transPerHourData, 22, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 22, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 22, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 22, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 22, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 22, 'NZD')
										},
										{
											"hourOfDay" : 23,
											"eur" : getSellCountData(
													transPerHourData, 23, 'EUR'),
											"usd" : getSellCountData(
													transPerHourData, 23, 'USD'),
											"yen" : getSellCountData(
													transPerHourData, 23, 'YEN'),
											"gbp" : getSellCountData(
													transPerHourData, 23, 'GBP'),
											"aud" : getSellCountData(
													transPerHourData, 23, 'AUD'),
											"nzd" : getSellCountData(
													transPerHourData, 23, 'NZD')
										} ],
								"valueAxes" : [ {
									"stackType" : "regular",
									"axisAlpha" : 1.0,
									"gridAlpha" : 0
								} ],
								"graphs" : [
										{
											"balloonText" : "<b>[[title]]</b><br><span style='font-size:14px'>[[category]]: <b>[[value]]</b></span>",
											"fillAlphas" : 0.8,
											"labelText" : "[[value]]",
											"lineAlpha" : 0.3,
											"title" : "EURO",
											"type" : "column",
											"color" : "#000000",
											"valueField" : "eur"
										},
										{
											"balloonText" : "<b>[[title]]</b><br><span style='font-size:14px'>[[category]]: <b>[[value]]</b></span>",
											"fillAlphas" : 0.8,
											"labelText" : "[[value]]",
											"lineAlpha" : 0.3,
											"title" : "US Dollar",
											"type" : "column",
											"color" : "#000000",
											"valueField" : "usd"
										},
										{
											"balloonText" : "<b>[[title]]</b><br><span style='font-size:14px'>[[category]]: <b>[[value]]</b></span>",
											"fillAlphas" : 0.8,
											"labelText" : "[[value]]",
											"lineAlpha" : 0.3,
											"title" : "YEN",
											"type" : "column",
											"color" : "#000000",
											"valueField" : "yen"
										},
										{
											"balloonText" : "<b>[[title]]</b><br><span style='font-size:14px'>[[category]]: <b>[[value]]</b></span>",
											"fillAlphas" : 0.8,
											"labelText" : "[[value]]",
											"lineAlpha" : 0.3,
											"title" : "British Pound",
											"type" : "column",
											"color" : "#000000",
											"valueField" : "gbp"
										},
										{
											"balloonText" : "<b>[[title]]</b><br><span style='font-size:14px'>[[category]]: <b>[[value]]</b></span>",
											"fillAlphas" : 0.8,
											"labelText" : "[[value]]",
											"lineAlpha" : 0.3,
											"title" : "Australian Dollar",
											"type" : "column",
											"color" : "#000000",
											"valueField" : "aud"
										},
										{
											"balloonText" : "<b>[[title]]</b><br><span style='font-size:14px'>[[category]]: <b>[[value]]</b></span>",
											"fillAlphas" : 0.8,
											"labelText" : "[[value]]",
											"lineAlpha" : 0.3,
											"title" : "New Zealand Doller",
											"type" : "column",
											"color" : "#000000",
											"valueField" : "nzd"
										} ],
								"categoryField" : "hourOfDay",
								"columnSpacing" : 1,
								"categoryAxis" : {
									"gridPosition" : "start",
									"axisAlpha" : 0,
									"gridAlpha" : 0,
									"position" : "left"
								},
								"depth3D" : 20,
								"angle" : 30,
								"titles" : [ {
									"text" : "#Sell Trans. per hour by currency",
									"size" : 10
								} ],
								"export" : {
									"enabled" : true
								}

							});

		}
	</script>

	<!-- HTML -->
	<div id="buyTransPerHourStackedChart"></div>
	<div id="sellTransPerHourStackedChart"></div>
</div>