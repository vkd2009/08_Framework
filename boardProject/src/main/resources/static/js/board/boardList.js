/* 글쓰기 버튼 클릭 시 */

const insertBtn = document.querySelector("#insertBtn");

// 글쓰기 버튼이 존재할 때(로그인 상태인 경우)
if(insertBtn != null){
  insertBtn.addEventListener('click', () => {
    
    // * boardCode 얻어오는 방법 *
    // 1) @PathVariable("boardCode") 얻어와 전역 변수 저장
    // 2) location.pathname.split("/")[2]

    // get방식 요청
    location.href = `/editBoard/${boardCode}/insert`;
  })

}