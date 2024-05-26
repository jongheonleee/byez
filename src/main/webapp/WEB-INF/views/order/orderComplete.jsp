<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/orderComplete.css">
    <link rel="stylesheet" href="/css/footer.css?after?after">
    <link rel="stylesheet" href="/css/quick.css">
    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">

</head>
<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp"/>
<section>
    <div class="wrapper">
        <div class="orderWrapper">
            <p class="orderNum">주문번호 <span id="orderId"></span></p>
            <p>결제가 정상적으로 완료되었습니다.</p>
            <div class="payInfo">
                <p>결제금액<span id="amount"></span></p>
                <p>결제수단<span>토스</span></p>
            </div>
            <button onClick="location.href='/'">홈으로 가기</button>
            <button onClick="location.href='/order/orderHist?ord_num=${param.orderId}'">주문상세확인</button>
            <div id="response" style="white-space: initial"></div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<jsp:include page="/WEB-INF/views/include/quick.jsp"/>
<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js"></script>
<script>
    // 쿼리 파라미터 값이 결제 요청할 때 보낸 데이터와 동일한지 반드시 확인하세요.
    // 클라이언트에서 결제 금액을 조작하는 행위를 방지할 수 있습니다.
    const urlParams = new URLSearchParams(window.location.search);

    // 서버로 결제 승인에 필요한 결제 정보를 보내세요.
    async function confirm() {
        var requestData = {
            paymentKey: urlParams.get("paymentKey"),
            orderId: urlParams.get("orderId"),
            amount: urlParams.get("amount"),
        };

        const response = await fetch("/confirm", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(requestData),
        });

        const json = await response.json();

        if (!response.ok) {
            // TODO: 결제 실패 비즈니스 로직을 구현하세요.
            console.log(json);
            window.location.href = `/fail?message=${json.message}&code=${json.code}`;
        }

        // TODO: 결제 성공 비즈니스 로직을 구현하세요.
        console.log(json);
        return json;
    }
    confirm().then(function (data) {
        document.getElementById("response").innerHTML = `<pre>${JSON.stringify(data, null, 4)}</pre>`;
    });

    const paymentKeyElement = document.getElementById("paymentKey");
    const orderIdElement = document.getElementById("orderId");
    const amountElement = document.getElementById("amount");

    orderIdElement.textContent = urlParams.get("orderId");
    amountElement.textContent = urlParams.get("amount") + "원";
    paymentKeyElement.textContent = urlParams.get("paymentKey");
</script>
</body>
</html>