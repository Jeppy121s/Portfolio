/*const todoList=[{
    name:'make dinner',
    dueDate:'2024-03-26'
},
{
    name:'make bed',
    dueDate:'2024-04-16'
},

];
renderList();

function renderList(){
let todoListHTML ='';

for(let i =0; i<todoList.length; i++){
    const todoObject = todoList[i];
    // const nam = todoObject.name;
    // const dueDate=todoObject.dueDate;
    const {name, dueDate}=todoObject;
    const html = `<p>
    ${nam}  ${dueDate}
    <button onclick="
        todoList.splice(${i},1);
        renderList();
    ">Delete</button> 
    </p>`;
    todoListHTML +=html
}

document.querySelector('.js-todo-list').innerHTML = todoListHTML;}


function addTodo(){
const inputElement=document.querySelector('.js-name-input');


const name=inputElement.value;
const dateInputElement=document.querySelector('.js-due-date-input');

const dueDate=dateInputElement.value;


todoList.push({
    name,
    dueDate
    // name: name,
    // dueDate: dueDate
});
console.log(todoList);

inputElement.value='';
renderList();
}*/

const todoList=['make dinner', 'shit yourself'];
renderList();

function renderList(){
let todoListHTML ='';

for(let i =0; i<todoList.length; i++){
    const todo = todoList[i];
    const html = `<p>
    ${todo}  
    <button onclick="
        todoList.splice(${i},1);
        renderList();
    ">Delete</button> 
    </p>`;
    todoListHTML +=html
}
console.log(todoListHTML)
document.querySelector('.js-todo-list').innerHTML = todoListHTML;}


function addTodo(){
const inputElement=document.querySelector('.js-name-input');

const name=inputElement.value;
console.log(name);

todoList.push(name);
console.log(todoList);

inputElement.value='';
renderList();
}