/* 쿠키에서 key가 일치하는 value 얻어오기 함수 */

// 쿠키는 "K=V; K=V;" 형식

// 배열.map(함수) : 배열의 각 요소를 이용해 함수 수행 후
//                  결과 값으로 새로운 배열을 만들어서 반환
const getCookie = key => {
    const cookies = document.cookie; // "K=V; K=V"
  
    // cookies 문자열을 배열 형태로 변환
    const cookieList = cookies.split("; ")  // ["K=V", "K=V"]
                      .map( el => el.split("=") ); // ["K", "V"]
  
    // 배열 -> 객체로 변환 (그래야 다루기 쉽다)
  
    const obj = {}; // 비어있는 객체 선언
  
    for(let i=0 ; i<cookieList.length ; i++){
      const k = cookieList[i][0]; // key 값
      const v = cookieList[i][1];
      obj[k] = v; // 객체에 추가
    }
  
    // console.log("obj", obj);
  
    return obj[key]; // 매개 변수로 전달 받은 key와 
                    // obj 객체에 저장된 키가 일치하는 요소의 값 반환
    
  }


  const loginEmail 
  = document.querySelector("#loginForm input[name='memberEmail']");

  // 로그인 안된 상태인 경우에만 수행
  if(loginEmail != null){ // 로그인창의 이메일 입력 부분이 있을 때

    // 쿠키 중 key 값이 "svaeId"인 요소의 value 얻어오기
    const saveId = getCookie("saveId"); // undefined 또는 이메일

    // svaeId 값이 있을 경우
    if(saveId != undefined){
      loginEmail.value = saveId; // 쿠키에서 얻어온 값을 input에 value로 세팅

      // 아이디 저장 체크박스에 체크 해두기
      document.querySelector("input[name='saveId']").checked = true;
    }
  }


  /* 이메일, 비밀번호 미작성 시 로그인 막기 */

  const loginForm = document.querySelector("#loginForm");

  const loginPw = document.querySelector("#loginForm input[name='memberPw']");

  // #loginForm이 화면에 존재 할 때 (== 로그인 상태 아닐 때)
  if(loginForm != null){

    // 제출 이벤트 발생 시
    loginForm.addEventListener("submit", e => {

      // loginEmail : 이메일 입력
      // loginPw    : 비밀번호 입력

      // 이메일 미작성
      if(loginEmail.value.trim().length == 0){
        alert("이메일을 작성해 주세요!");
        e.preventDefault(); // 기본 이벤트(제출) 막기
        loginEmail.focus(); // 초점이동
        return;
      }

      //비밀번호 미작성
      if(loginPw.value.trim().length === 0){
        alert("비밀번호를 작성해 주세요!");
        e.preventDefault(); // 기본 이벤트(제출) 막기
        loginPw.focus(); // 초점 이동
        return;
      }

    });
  }




  /* 빠른 로그인 */
  const quickLoginBtns= document.querySelectorAll(".quick-login");

  quickLoginBtns.forEach( (item, index) => {
    // item  : 현재 반복 시 꺼내온 객체
    // index : 현재 반복 중인 인덱스
    
    // quickLoginBtns 요소를 하나씩 꺼내서 이벤트 리스너 추가
    item.addEventListener("click", e => {

      const email = item.innerText; // 버튼에 작성된 이메일 얻어오기

      location.href = "/member/quickLogin?memberEmail="+email;
    });
  });


  // ---------------------------------------------------------

  /* 회원 목록 조회 (비동기) */

  // 조회 버튼
  const selectMemberList = document.querySelector("#selectMemberList");

  // tbody
  const memberList = document.querySelector("#memberList");

  selectMemberList.addEventListener("click", () => {

    // 1) 비동기로 회원 목록 조회
    //    (포함될 회원 정보 : 회원번호, 이메일, 닉네임, 탈퇴여부)
    fetch("member/selectList")
    
    //    첫 번째 then(response => response.json()) -> 
    //    JSON Array -> JS 객체 배열로 변환 [{}, {}, {}, {}]
   .then(response => response.json()) 
   const arr = ['memberNo', 'memberEmail', 'memberNickName','memberDelFl']
    // 2) 두 번째 then
    //    tbody에 이미 작성되어 있던 내용(이전에 조회한 목록) 삭제 
    memberList.innerHTML = "";

    // 3) 두 번째 then
    //    조회된 JS 객체 배열을 이용해
    //    tbody에 들어갈 요소를 만들고 값 세팅 후 추가
    for(let key of arr){
      const td = document.createElement("td");

    }
    
  });