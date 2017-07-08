<h3>Trades Complete</h3>
<div id="tradeMessageDetails">
	<div class="staticWidth">
		<table class="transaction-table table-header">
			<tr>
				<th width="12%">User</th>
				<th width="12%">Currency From</th>
				<th width="12%">Sell</th>
				<th width="12%">Currency To</th>
				<th width="12%">Buy</th>
				<th width="12%">Rate</th>
				<th width="12%">Trans Time</th>
				<th width="12%">Orig. Country</th>
			</tr>
		</table>
	</div>
	<div id="tradeMessageDetailsDiv">
		<div style="background-color: #EFEFEF;">
			<table style="text-align: center; width: 100%; border-spacing: 0px; border-collapse: separate;">
				<c:forEach items="${trades}" var="trade">
					<tr>
						<td width="12%"><c:out value="${trade.userId}" /></td>
						<td width="12%"><c:out value="${trade.currencyFrom}" /></td>
						<td width="12%"><c:out value="${trade.amountSell}" /></td>
						<td width="12%"><c:out value="${trade.currencyTo}" /></td>
						<td width="12%"><c:out value="${trade.amountBuy}" /></td>
						<td width="12%"><c:out value="${trade.rate}" /></td>
						<td width="12%"><fmt:formatDate type="DATE" pattern="dd/MM/yyyy HH:mm" value="${trade.timePlaced}" /></td>
						<td width="12%"><c:out value="${trade.originatingCountry}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="staticWidth">
		<table class="transaction-table table-footer">
			<tr>
				<th class="green-bg" width="66%"></th>
				<th class="totals-bg" width="34%">Total Records: <c:choose>
						<c:when test="${trades != null}">
							${fn:length(trades)}
						</c:when>
						<c:otherwise>
							<c:out value="0" />
						</c:otherwise>
					</c:choose>
				</th>
			</tr>
		</table>
	</div>
</div>