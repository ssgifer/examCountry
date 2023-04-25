<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../css.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">
	<meta charset="utf-8">
	<meta equiv="Content-Type" content="text/html; charset=TIS-620">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta name="description" content="">
	<meta name="author" content="">
	
<title>Country Test</title>
</head>

<body>
	<table align="right" width="100">
		<td>
			<a href="testTH.jsp"><img src="th.png" alt="th-icon" width="50" height="50"></a> 
	    </td>
	    <td>
	    	<a href="testEN.jsp"><img src="en.png" alt="en-icon" width="50" height="50"></a> 
	    </td>
	</table>
	<br>
	<br>

	<form action="THCountry" method="post">
		<center><table id="tbhead">
			<tr>	
			    <td>ชื่อประเทศ :</td> 
			    <td><input type="text" name="countryName" id="text"/></td>
			</tr>
			
			<tr>	    
			    <td>จำนวนประชากร :</td> 
			    <td><input type="text" name="population" id="text"/></td>
			</tr>
			    
			<tr>
			    <td>เรียงลำดับ :</td>
			    <td>
				    <select name="sorting" id="sorting">
				    	<option>เลือก</option>
				    	<option value="name">ชื่อประเทศ</option>
					    <option value="area">พื้นที่</option>
					    <option value="population">จำนวนประชากร</option>
					</select>
				</td>
			</tr>
				
			<tr>  
			    <td>รูปแบบการจัดเรียง :</td>
				<td>
					<input type="radio" id="asc" name="orderBy" value="asc" checked="checked"/>
			    	<label for="coding">น้อยไปมาก</label>
			    	<input type="radio" id="desc" name="orderBy" value="desc" />
			    	<label for="coding">มากไปน้อย</label>
			    </td>
		    </tr>
		</table>	
		
			<center>
			<tr>
				<td><input type="submit" value="ค้นหา" id="search"/></td>
				<td><button onclick="location.href='testTH.jsp'" type="button" id="reset">เริ่มใหม่</button></td>
			</tr>	
			</center>					
	</form>
	
	<br>
	<table width="100%" border="3" id="table"> 
		<c:if test="${countryTHSearch ne null}">
			<tr id="head">
				<th>ลำดับ</th>
				<th>ประเทศ</th>
				<th>พื้นที่ (ตร.กม.)</th>
				<th>จำนวนประชากร</th>
			</tr>
		</c:if>
			
			<c:set var="sumArea" value="0" />
			<c:set var="sumPopulation" value="0" />
			<c:forEach items="${countryTHSearch}" var="item" varStatus="irow">
			<c:set var="sumArea" value="${sumArea + item.area}" />
			<c:set var="sumPopulation" value="${sumPopulation + item.people}" />
			</c:forEach>
			
		<tr>
			<c:forEach items="${countryTHSearch}" var="country" varStatus="irow">	
		    	<tr>  	
					<td align="center">${irow.index + 1}</td>
					<td>${country.name}</td>
					<td><fmt:formatNumber type = "number" value = "${country.area}"  pattern = "#,###.00"/></td>
					<td><fmt:formatNumber type = "number" value = "${country.people}"  pattern = "#,###.00"/></td>
				</tr>
		   </c:forEach>
	   </tr> 
	   
	   <c:if test="${countryTHSearch ne null}">
			<tr>
				<td colspan="2" align="right">Total</td>
				<td><fmt:formatNumber type = "number" value = "${sumArea}"  pattern = "#,###.00"/></td>
				<td><fmt:formatNumber type = "number" value = "${sumPopulation}"  pattern = "#,###.00"/></td>
			</tr> 	
		</c:if>	
		
		<tr>
			<c:forEach items="${NotFound}" var="country" varStatus="irow">		
					<center><h1>ไม่พบข้อมูล !!!</h1></center>
	
		   	</c:forEach>
		</tr> 
		
	</table>
	
</body>
</html>