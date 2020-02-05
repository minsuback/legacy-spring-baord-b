<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html lang="ko">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Dashboard</title>

  <!-- Custom fonts for this template-->
  <link href="/spring-board-a/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="/spring-board-a/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <jsp:include page="/WEB-INF/views/modules/sidebar.jsp" />

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <jsp:include page="/WEB-INF/views/modules/topbar.jsp" />
        
        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">자유 게시판</h1>
          <br>
          
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <span class="m-0 font-weight-bold text-primary">글 수정</span>
            </div>
            <div class="card-body">
           		<form id="update-form" role="form" action="update.action" method="post">
           			<input type="hidden" name="bno" value="${ board.bno }">
           			<input type="hidden" id="searchType" name="searchType" value="${ param.searchType }">
  					<input type="hidden" id="searchKey" name="searchKey" value="${ param.searchKey }">
           			<input type="hidden" name="pageNo" value="${ param.pageNo }">
		          <div class="form-group">
		            <label>제목</label> <input class="form-control" id="title" name='title' value="${ board.title }">
		          </div>
		
		          <div class="form-group">
		            <label>내용</label>
		            <textarea class="form-control" rows="3" id="content" name='content'>${ board.content }</textarea>
		          </div>
		
		          <div class="form-group">
		            <label>작성자</label> <input class="form-control" id="writer" name='writer' value="${ board.writer }">
		          </div>
		          
		          <button id="update-button" type="button" class="btn btn-success">수정</button>
		          <button type="reset" class="btn btn-success">다시쓰기</button>
		          <button id="cancel-button" type="button" class="btn btn-success">취소</button>
		          <button id="toList-button" type="button" class="btn btn-success">목록</button>
		       </form>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <%@include file="/WEB-INF/views/modules/common-js.jsp" %>
  <script type="text/javascript">
	$("#toList-button").on("click" , function(event){
			location.href="list.action?pageNo=${ param.pageNo }&searchType=${ param.searchType }&searchKey=${ param.searchKey }";
		});
		
	$("#update-button").on("click" , function(event) {
			// 1. 유효성 검사
			if($("#title").val() == '' ){
				alert("제목을 입력하세요!");
				$("#title").focus();
				return;
			}
			if($("#writer").val() == '' ){
				alert("작성 입력하세요!");
				$("#writer").focus();
				return;
			}
			
			// 2. 오류가 없다면 서버로 전송
			$("#update-form").submit();
		});

	$("#cancel-button").on("click" , function(event) {
			//history.back();
			location.href="detail.action?bno=${ board.bno }&pageNo=${ param.pageNo }&searchType=${ param.searchType }&searchKey=${ param.searchKey }";
		});
	
  </script>
  
</body>

</html>
