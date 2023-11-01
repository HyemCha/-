const list = document.getElementById('list');
const createBtn = document.getElementById('create-btn');

let todos = [];

createBtn.addEventListener('click', createNewTodo)

function createNewTodo() {
    // 새로운 아이템 객체 생성
    const item = {
        id: new Date().getTime(),
        text: "",
        completed: false
    }

    todos.unshift(item);

    // 요소 생성하기
    const {itemEl, inputEl, editBtnEl, removeBtnEl} = createTodoElement(item)

    // 리스트 요소 안에 방금 생성한 아이템 요소 추가(가장 첫번째 요소로 추가
    list.prepend(itemEl)

    // diabled 속성 제거
    inputEl.removeAttribute('disabled')

    // input 요소에 focus
    inputEl.focus()

    saveToLocalStorage()
}

function createTodoElement(item) {
    const itemEl = document.createElement('div')
    itemEl.classList.add('item')

    const checkboxEl = document.createElement("input")
    checkboxEl.type = "checkbox"
    checkboxEl.checked = item.completed

    if(item.completed) {
        itemEl.classList.add('completed')
    }

    const inputEl = document.createElement("input")
    inputEl.type = "text"
    inputEl.value = item.text
    inputEl.setAttribute('disabled', '')

    const actionsEl = document.createElement('div')
    actionsEl.classList.add('actions')

    const editBtnEl = document.createElement('button')
    editBtnEl.classList.add('material-icons')
    editBtnEl.innerText = 'edit'

    const removeBtnEl = document.createElement('button')
    removeBtnEl.classList.add('material-icons', 'remove-btn')
    removeBtnEl.innerText ='remove_circle'

    actionsEl.append(editBtnEl, removeBtnEl)
    itemEl.append(checkboxEl, inputEl, actionsEl)

    checkboxEl.addEventListener('change', () => {
        item.completed = checkboxEl.checked

        if(item.completed) {
            itemEl.classList.add('completed')
        } else {
            itemEl.classList.remove('completed')
        }
        saveToLocalStorage()
    })

    inputEl.addEventListener('input', () => {
        item.text = inputEl.value
    })

    inputEl.addEventListener('blur', () => {
        inputEl.setAttribute('disabled', '')
        saveToLocalStorage()
    })

    editBtnEl.addEventListener('click', () => {
        inputEl.removeAttribute('disabled')
        inputEl.focus()
    })

    removeBtnEl.addEventListener('click', () => {
        todos.filter(todo => todo.id!== item.id)
        itemEl.remove()
    })

    return {itemEl, inputEl, editBtnEl, removeBtnEl}
}

function saveToLocalStorage() {
    // 로컬스토리지에 넣을 때는 문자열로 변경해야한다.!!!
    const data = JSON.stringify(todos)

    localStorage.setItem('my_todos', data)
}

function loadFromLocalStorage() {
    const data = localStorage.getItem('my_todos')

    if(data) {
        todos = JSON.parse(data)

    }
}

function displayTodos() {
    loadFromLocalStorage()
    
    for (let i = 0; i < todos.length; i++) {
        const item = todos[i]

        const { itemEl } = createTodoElement(item);
        list.prepend(itemEl)
    }
}

displayTodos()