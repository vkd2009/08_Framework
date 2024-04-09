const selectBookList = document.querySelector("#selectBookList");
const bookList = dcoument.querySelector("#bookList");

const createTd = (text) => {
    const td = document.createElement("td");
    td.innerText = text;
    return td;
}


selectBookList.addEventListener("click", () => {

fetch("/book/selectList")

.then(response => response.json())

.then(list =>{
    bookList.innerHTML = "";
    list.forEach( (book,index) => {

        const keyList = ['bookNo', 'bookTitle' , 'bookWriter', 'bookPrice', 'regDate']

        const tr = document.createElement("tr");

        keyList.forEach( key => tr.append( createTd(book[key])));

        bookList.append(tr);
    });        
 })
});


