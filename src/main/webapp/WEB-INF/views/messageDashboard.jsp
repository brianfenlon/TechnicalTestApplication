<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false"%>
<html>
<head>
<title>Message Dashboard</title>
<link rel="stylesheet" href="<c:url value="/resources/styles/techtest-styling.css" />" type="text/css"/>
</head>
<body>
	<h1>Dashboard Contents</h1>
	<div id="mainContent" align="left">

		<!-- Message Details -->
		<%@ include file="panels/tradeMessageCompleteDetails.jsp"%>

		<!-- Charts -->
		<div>
			<%@ include file="panels/tradeTransPerHourChart.jsp"%>
		</div>
		<div>
			<%@ include file="panels/buyVersusSellChart.jsp"%>
		</div>
	</div>

</body>
</html>
