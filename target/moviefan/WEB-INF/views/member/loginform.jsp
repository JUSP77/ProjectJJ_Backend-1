<%--
  Created by IntelliJ IDEA.
  User: JUSEONG
  Date: 2023-06-21
  Time: 오후 3:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginform</title>
    <!-- 부트스트랩 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <!-- 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <!-- 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <div class="row mt-4 mb-2">
        <div class="col">
            <h2 class="text-center">로그인 후 이용해주세요.</h2>
        </div>
    </div>
    <div class="d-flex justify-content-center mb-5">
        <form class="border bg-light w-50" method="post" action="login" id="form-normal-login-error">
            <div class="row mb-3 mt-3">
                <div class="col-8 offset-2">
                    <label class="form-label align-middle">아이디</label>
                    <input type="text" class="form-control" name="id">
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-8 offset-2">
                    <label class="form-label">비밀번호</label>
                    <input type="password" class="form-control" name="password">
                </div>
            </div>
            <div class="d-flex justify-content-center mb-1">
                <button class="btn btn-danger" id="button-normal-login-error" style="width: 300px;">로그인</button>
            </div>
            <div class="d-flex justify-content-center">
                <a class="link-dark" href="/findid">아이디 찾기</a>
                <p>&nbsp;|&nbsp;</p>
                <a class="link-dark" href="/findpassword">비밀번호 찾기</a>
                <p>&nbsp;|&nbsp;</p>
                <a class="link-dark" href="/join">회원가입</a>
            </div>
            <div class="d-flex justify-content-center mb-3">
                <a id="btn-kakao-login-error" href="">
                    <img src="/resources/images/kakao_login.png" alt="카카오 로그인 버튼"/>
                </a>
            </div>
        </form>
    </div>
    <div class="row">
        <%--
            카카오 로그인 서비스가 제공하는 사용자 정보를 서버로 제출할 때 사용하는 폼과 폼 입력요소다.
            카카오 로그인 인증이 완료되면 사용자정보를 전달받아서 아래 폼 입력필드에 설정하고, 폼을 서버로 제출한다.
         --%>
        <form id="form-kakao-login-error" method="post" action="kakao-login">
            <input type="hidden" name="id" />
            <input type="hidden" name="nickName" />
            <input type="hidden" name="email" />
            <input type="hidden" name="gender" />
        </form>
    </div>
</div>

</body>
</html>
