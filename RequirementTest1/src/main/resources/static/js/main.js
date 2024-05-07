// 조회버튼
const selectMemberList = document.querySelector("#selectMemberList");

// 리스트 목록 출력
const memberList = document.querySelector("#memberList");

const createTd = (text) => {
    const td = document.createElement("td");
    td.innerText = text;
    return td;
}

selectMemberList.addEventListener("click", () =>{
    fetch("/student/selectList")
    .then(response => response.json())
    .then(list => {
        memberList.innerHTML = "";
        list.forEach((student,index) =>{


            const keyList = ['studentNo', 'studentName', 'studentMajor', 'studentGender']

            const tr = document.createElement("tr");

            keyList.forEach( key => tr.append( createTd(student[key])));
        
            memberList.append(tr);
        });
    })
    
    
});