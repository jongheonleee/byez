
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<style>

</style>
<div>
    <h2>게시판 읽기</h2>
    <h4>작성자명 : ${qnaDto.qna_writer}</h4>
    <h4>제목 : ${qnaDto.qna_title}</h4>
    <h4>답변 여부 : ${qnaDto.res_state}</h4>
    <h4>${qnaDto.qna_content}</h4>
    <a href="/qna/list">목록</a>
    <c:if test="${qnaDto.res_content eq null}">
        <a href="/qna/delete?seq_num=${qnaDto.seq_num}" onclick="return confirm('삭제하시겠습니까?')">삭제</a>
        <a href="/qna/update?seq_num=${qnaDto.seq_num}" onclick="return confirm('수정하시겠습니까?')">수정</a>
        <h3>답변 대기중입니다. 조금만 기달려 주세요!</h3>
    </c:if>
    <c:if test="${qnaDto.res_content ne null}">
        <h4>제목 : ${qnaDto.res_title}</h4>
        <h4> 담당자 : ${qnaDto.res_writer}</h4>
        <h4> =======</h4>
        <h4> ${qnaDto.res_content}</h4>
    </c:if>
</div>
<script type="text/javascript">

    function readURL(input) {
        var file = input.files[0]
        console.log(file)
        if (file != '') {
            var reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = function (e) {
                console.log(e.target)
                console.log(e.target.result)
                $('#preview').attr('src', e.target.result);
            }
        }
    }
</script>
</html>
